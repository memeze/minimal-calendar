package com.memeze.minimalcalendar.ui

import androidx.compose.animation.*
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.PagerState
import com.memeze.minimalcalendar.R
import com.memeze.minimalcalendar.config.MinimalCalendarColors
import java.time.LocalDate
import java.time.YearMonth


@Composable
internal fun MinimalCalendarHeader(
    modifier: Modifier = Modifier,
    calendarColors: MinimalCalendarColors,
    title: String,
    pagerState: PagerState,
    selectedDate: LocalDate,
    currentMonth: YearMonth,
    showSelectDateBox: Boolean,
    onClickSelectDateBox: () -> Unit,
    onClickPrev: () -> Unit,
    onClickNext: () -> Unit,
    onClickToday: () -> Unit
) {
    val defaultStyle = MaterialTheme.typography.h5
    var autoTextStyle by remember { mutableStateOf(defaultStyle) }
    var readyToDraw by remember { mutableStateOf(false) }

    val angle: Float by animateFloatAsState(
        targetValue = if (showSelectDateBox) 180f else 0f,
        animationSpec = tween(durationMillis = 200)
    )

    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(calendarColors.headerBackgroundColor)
            .padding(start = 16.dp, top = 16.dp, end = 16.dp)
            .height(56.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        CompositionLocalProvider(
            LocalContentColor provides calendarColors.headerDateTextColor
        ) {
            ScaleButton(
                modifier = Modifier,
                onClick = { onClickSelectDateBox() }
            ) {
                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier
                            .padding(start = 4.dp)
                            .drawWithContent { if (readyToDraw) drawContent() },
                        style = autoTextStyle,
                        textAlign = TextAlign.Start,
                        text = title,
                        onTextLayout = { textLayoutResult ->
                            if (textLayoutResult.didOverflowHeight) {
                                autoTextStyle = autoTextStyle.copy(
                                    fontSize = autoTextStyle.fontSize * 0.9
                                )
                            } else {
                                readyToDraw = true
                            }
                        }
                    )
                    Icon(
                        modifier = Modifier.rotate(angle),
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "Select year"
                    )
                }
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        AnimatedVisibility(
            visible = !showSelectDateBox,
            enter = fadeIn(animationSpec = tween(100)),
            exit = fadeOut(animationSpec = tween(100))
        ) {
            Row {
                AnimatedVisibility(
                    visible = ((currentMonth != YearMonth.now()) || (selectedDate != LocalDate.now())),
                    enter = scaleIn(animationSpec = tween(100)),
                    exit = scaleOut(animationSpec = tween(100))
                ) {
                    ScaleButton(
                        modifier = Modifier.size(48.dp),
                        onClick = onClickToday
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_round_today_24),
                            contentDescription = "Today",
                            tint = calendarColors.headerTodayIconColor
                        )
                    }
                }
                CompositionLocalProvider(
                    LocalContentColor provides calendarColors.headerArrowIconColor
                ) {
                    ScaleButton(
                        modifier = Modifier.size(48.dp),
                        enabled = pagerState.currentPage - 1 >= 0,
                        onClick = onClickPrev
                    ) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowLeft,
                            contentDescription = "Previous month"
                        )
                    }
                    ScaleButton(
                        modifier = Modifier.size(48.dp),
                        enabled = pagerState.currentPage + 1 < pagerState.pageCount,
                        onClick = onClickNext
                    ) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowRight,
                            contentDescription = "Next month"
                        )
                    }
                }
            }
        }
    }
}