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

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.memeze.minimalcalendar.config.Constant.DAY_ITEM_SIZE
import com.memeze.minimalcalendar.config.Constant.DAY_OF_WEEK_COUNT
import com.memeze.minimalcalendar.config.MinimalCalendarColors
import java.time.LocalDate

@Composable
internal fun MinimalCalendarDays(
    modifier: Modifier = Modifier,
    calendarColors: MinimalCalendarColors,
    viewDate: LocalDate,
    selectedDate: LocalDate,
    onSelectDate: (LocalDate) -> Unit
) {
    val calendarDatesData = remember { getDates(viewDate) }
    val days = remember { IntRange(1, calendarDatesData.second).toList() }
    val enabled = remember(selectedDate) {
        viewDate.year == selectedDate.year && viewDate.month == selectedDate.month
    }

    LazyVerticalGrid(
        modifier = modifier,
        columns = GridCells.Fixed(DAY_OF_WEEK_COUNT)
    ) {
        for (x in 0 until calendarDatesData.first) {
            item { Box(modifier = Modifier.size(DAY_ITEM_SIZE.dp)) }
        }

        items(days) { day ->
            val selected = remember(selectedDate) { enabled && day == selectedDate.dayOfMonth }
            val date = viewDate.withDayOfMonth(day)
            MinimalCalendarDay(
                modifier = Modifier.size(DAY_ITEM_SIZE.dp),
                calendarColors = calendarColors,
                date = date,
                isToday = date == LocalDate.now(),
                isSelected = selected,
                onClickDate = onSelectDate
            )
        }
    }
}

@Composable
private fun MinimalCalendarDay(
    modifier: Modifier = Modifier,
    calendarColors: MinimalCalendarColors,
    date: LocalDate,
    isToday: Boolean,
    isSelected: Boolean,
    onClickDate: (LocalDate) -> Unit
) {
    val defaultStyle = MaterialTheme.typography.body1
    var autoTextStyle by remember { mutableStateOf(defaultStyle) }
    var readyToDraw by remember { mutableStateOf(false) }

    val dateBackgroundColor = when {
        isSelected -> calendarColors.dateSelectedBackgroundColor
        isToday -> calendarColors.dateTodayBackgroundColor
        else -> Color.Transparent
    }

    val dateTextColor = when {
        isSelected -> calendarColors.dateSelectedTextColor
        isToday -> calendarColors.dateTodayTextColor
        else -> calendarColors.dateTextColor
    }

    Box(
        modifier = modifier
            .wrapContentSize()
            .aspectRatio(1f)
            .padding(4.dp)
            .clip(CircleShape)
            .background(
                color = dateBackgroundColor,
                shape = CircleShape
            )
            .clickable { onClickDate(date) },
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier.drawWithContent { if (readyToDraw) drawContent() },
            text = date.dayOfMonth.toString(),
            maxLines = 1,
            color = dateTextColor,
            style = autoTextStyle,
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

private fun getDates(date: LocalDate): Pair<Int, Int> {
    val numDays = date.month.length(date.isLeapYear)
    val firstDay = date.withDayOfMonth(1).dayOfWeek.value % 7

    return Pair(firstDay, numDays)
}