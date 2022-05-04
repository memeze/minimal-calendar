package com.memeze.minimalcalendar.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.memeze.minimalcalendar.config.Constant.WEEK_HEIGHT
import com.memeze.minimalcalendar.config.MinimalCalendarColors
import java.text.DateFormatSymbols
import java.util.*

@Composable
internal fun MinimalCalendarWeek(
    modifier: Modifier = Modifier,
    calendarColors: MinimalCalendarColors
) {
    val defaultStyle = MaterialTheme.typography.subtitle2
    var autoTextStyle by remember { mutableStateOf(defaultStyle) }
    var readyToDraw by remember { mutableStateOf(false) }

    val week = DateFormatSymbols(Locale.getDefault()).shortWeekdays.takeLast(7)

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(WEEK_HEIGHT.dp)
            .background(calendarColors.weekBackgroundColor)
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        week.forEach { day ->
            Text(
                modifier = Modifier
                    .weight(1f)
                    .drawWithContent { if (readyToDraw) drawContent() },
                text = day.uppercase(),
                textAlign = TextAlign.Center,
                style = autoTextStyle,
                color = calendarColors.weekTextColor,
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
        }
    }
}