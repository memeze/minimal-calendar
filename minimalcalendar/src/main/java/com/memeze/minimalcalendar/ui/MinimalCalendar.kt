/*
 * Copyright 2022 memeze
 *
 * Licensed under the Apache License, Version 2.0 (the "License")
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.memeze.minimalcalendar.ui

import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.memeze.minimalcalendar.config.Constant.CALENDAR_MAX_HEIGHT
import com.memeze.minimalcalendar.config.Constant.CALENDAR_MAX_WIDTH
import com.memeze.minimalcalendar.config.Constant.DATE_PATTERN
import com.memeze.minimalcalendar.config.Constant.SELECT_ITEM_HEIGHT
import com.memeze.minimalcalendar.config.Constant.SELECT_LIST_HEIGHT
import com.memeze.minimalcalendar.config.MinimalCalendarColors
import com.memeze.minimalcalendar.config.MinimalCalendarConfig
import com.memeze.minimalcalendar.config.MinimalCalendarTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.DateTimeFormatter
import java.util.*


@Composable
fun MinimalCalendar(
    modifier: Modifier = Modifier,
    initDate: LocalDate = LocalDate.now(),
    onSelectDate: (date: LocalDate) -> Unit,
    calendarColors: MinimalCalendarColors = MinimalCalendarTheme.colors(),
    calendarConfig: MinimalCalendarConfig = MinimalCalendarConfig()
) {
    val scope = rememberCoroutineScope()
    var selectedDate by remember { mutableStateOf(initDate) }
    var currentMonth by remember { mutableStateOf(YearMonth.now()) }
    var showSelectDateBox by remember { mutableStateOf(false) }
    var selectedYearMonth by remember { mutableStateOf(currentMonth) }

    val initPage = (selectedDate.year - calendarConfig.yearRange.first) * 12 + selectedDate.monthValue - 1
    var currentPageIndex by remember { mutableStateOf(initPage) }
    val pagerState = rememberPagerState(initialPage = currentPageIndex)

    LaunchedEffect(pagerState.currentPage) {
        val index = (pagerState.currentPage - currentPageIndex).toLong()
        currentMonth = currentMonth.plusMonths(index)
        currentPageIndex = pagerState.currentPage
    }

    LaunchedEffect(selectedDate) {
        onSelectDate(selectedDate)
    }

    CompositionLocalProvider(LocalContentColor provides calendarColors.defaultColor) {
        Column(
            modifier = modifier
                .widthIn(max = CALENDAR_MAX_WIDTH.dp)
                .background(calendarColors.backgroundColor)
        ) {
            MinimalCalendarHeader(
                calendarColors = calendarColors,
                title = currentMonth.dateFormat(locale = calendarConfig.locale),
                pagerState = pagerState,
                selectedDate = selectedDate,
                currentMonth = currentMonth,
                showSelectDateBox = showSelectDateBox,
                onClickSelectDateBox = {
                    showSelectDateBox = !showSelectDateBox
                    selectedYearMonth = currentMonth
                },
                onClickPrev = {
                    scope.launch {
                        pagerState.animateScrollToPage(pagerState.currentPage - 1)
                    }
                },
                onClickNext = {
                    scope.launch {
                        pagerState.animateScrollToPage(pagerState.currentPage + 1)
                    }
                },
                onClickToday = {
                    selectedDate = LocalDate.now()
                    scope.launch {
                        pagerState.scrollToPage(page = initPage)
                    }
                },
                onClickSelect = {
                    scope.launch {
                        showSelectDateBox = false
                        pagerState.scrollToPage(
                            page = (selectedYearMonth.year - calendarConfig.yearRange.first) * 12 + selectedYearMonth.monthValue - 1
                        )
                    }
                }
            )
            Box(modifier = Modifier.height(CALENDAR_MAX_HEIGHT.dp)) {
                androidx.compose.animation.AnimatedVisibility(
                    visible = showSelectDateBox,
                    modifier = Modifier
                        .zIndex(1f)
                        .clipToBounds(),
                    enter = slideInVertically(initialOffsetY = { -it }),
                    exit = slideOutVertically(targetOffsetY = { -it })
                ) {
                    val initYearIndex = calendarConfig.yearRange.indexOf(selectedYearMonth.year) - 2
                    val yearState = rememberLazyListState(
                        initialFirstVisibleItemIndex = if (initYearIndex >= 0) initYearIndex else 0
                    )

                    val initMonthIndex = selectedYearMonth.monthValue - 3
                    val monthState = rememberLazyListState(
                        initialFirstVisibleItemIndex = if (initMonthIndex >= 0) initMonthIndex else 0
                    )

                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                color = calendarColors.selectionBackgroundColor,
                                shape = RoundedCornerShape(8.dp)
                            )
                            .padding(horizontal = 16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            SelectionList(
                                modifier = Modifier.weight(1f),
                                calendarColors = calendarColors,
                                scope = scope,
                                state = yearState,
                                range = calendarConfig.yearRange,
                                selectedItem = selectedYearMonth.year,
                                onSelectItem = { year ->
                                    selectedYearMonth = selectedYearMonth.withYear(year)
                                }
                            )
                            SelectionList(
                                modifier = Modifier.weight(1f),
                                calendarColors = calendarColors,
                                scope = scope,
                                state = monthState,
                                range = (1..12),
                                selectedItem = selectedYearMonth.monthValue,
                                onSelectItem = { month ->
                                    selectedYearMonth = selectedYearMonth.withMonth(month)
                                }
                            )
                        }
                    }
                }
                Column {
                    MinimalCalendarWeek(
                        modifier = Modifier,
                        calendarColors = calendarColors
                    )
                    HorizontalPager(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        count = (calendarConfig.yearRange.last - calendarConfig.yearRange.first + 1) * 12,
                        state = pagerState,
                        verticalAlignment = Alignment.Top
                    ) { page ->
                        val viewDate = remember {
                            LocalDate.of(
                                calendarConfig.yearRange.first + page / 12,
                                page % 12 + 1,
                                1
                            )
                        }
                        MinimalCalendarDays(
                            calendarColors = calendarColors,
                            viewDate = viewDate,
                            selectedDate = selectedDate,
                            onSelectDate = { date ->
                                selectedDate = date
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun SelectionList(
    modifier: Modifier = Modifier,
    calendarColors: MinimalCalendarColors,
    scope: CoroutineScope,
    state: LazyListState,
    range: IntRange,
    selectedItem: Int,
    onSelectItem: (Int) -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(SELECT_LIST_HEIGHT.dp)
            .clip(RoundedCornerShape(8.dp))
    ) {
        LazyColumn(
            modifier = Modifier,
            state = state,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(range.toList()) { item ->
                val selectedModifier = when (selectedItem == item) {
                    true -> Modifier.background(
                        color = calendarColors.selectionItemSelectedBackgroundColor,
                        shape = RoundedCornerShape(8.dp)
                    )
                    else -> Modifier
                }

                ScaleButton(
                    onClick = {
                        onSelectItem(item)
                        val index = range.indexOf(item) - 2
                        scope.launch {
                            state.animateScrollToItem(if (index >= 0) index else 0)
                        }
                    }
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(SELECT_ITEM_HEIGHT.dp)
                            .then(selectedModifier)
                    )
                    Text(
                        text = item.toString(),
                        style = MaterialTheme.typography.body1,
                        color = when (selectedItem == item) {
                            true -> calendarColors.selectionItemSelectedTextColor
                            else -> calendarColors.selectionItemTextColor
                        },
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

private fun YearMonth.dateFormat(locale: Locale = Locale.getDefault()): String {
    return format(DateTimeFormatter.ofPattern(DATE_PATTERN, locale))
}