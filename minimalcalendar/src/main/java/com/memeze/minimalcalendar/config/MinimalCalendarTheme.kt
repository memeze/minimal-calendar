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

package com.memeze.minimalcalendar.config

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

object MinimalCalendarTheme {
    @Composable
    fun colors(
        defaultColor: Color = MaterialTheme.colors.primary,
        backgroundColor: Color = MaterialTheme.colors.background,
        headerBackgroundColor: Color = backgroundColor,
        headerDateTextColor: Color = MaterialTheme.colors.onBackground,
        headerTodayIconColor: Color = MaterialTheme.colors.onBackground,
        headerArrowIconColor: Color = MaterialTheme.colors.onBackground,
        headerSelectIconColor: Color = defaultColor,
        selectionBackgroundColor: Color = backgroundColor,
        selectionItemTextColor: Color = MaterialTheme.colors.onBackground,
        selectionItemSelectedBackgroundColor: Color = defaultColor.copy(.1f),
        selectionItemSelectedTextColor: Color = MaterialTheme.colors.onBackground,
        selectionButtonBackgroundColor: Color = defaultColor.copy(.5f),
        selectionButtonTextColor: Color = MaterialTheme.colors.onPrimary,
        weekBackgroundColor: Color = backgroundColor,
        weekTextColor: Color = MaterialTheme.colors.onBackground.copy(.3f),
        dateTextColor: Color = MaterialTheme.colors.onBackground,
        dateSelectedBackgroundColor: Color = defaultColor.copy(.5f),
        dateSelectedTextColor: Color = MaterialTheme.colors.onPrimary,
        dateTodayBackgroundColor: Color = defaultColor.copy(.1f),
        dateTodayTextColor: Color = MaterialTheme.colors.onSurface
    ): MinimalCalendarColors {
        return MinimalCalendarColors(
            defaultColor = defaultColor,
            backgroundColor = backgroundColor,
            headerBackgroundColor = headerBackgroundColor,
            headerDateTextColor = headerDateTextColor,
            headerTodayIconColor = headerTodayIconColor,
            headerArrowIconColor = headerArrowIconColor,
            headerSelectIconColor = headerSelectIconColor,
            selectionBackgroundColor = selectionBackgroundColor,
            selectionItemTextColor = selectionItemTextColor,
            selectionItemSelectedBackgroundColor = selectionItemSelectedBackgroundColor,
            selectionItemSelectedTextColor = selectionItemSelectedTextColor,
            selectionButtonBackgroundColor = selectionButtonBackgroundColor,
            selectionButtonTextColor = selectionButtonTextColor,
            weekBackgroundColor = weekBackgroundColor,
            weekTextColor = weekTextColor,
            dateTextColor = dateTextColor,
            dateSelectedTextColor = dateSelectedTextColor,
            dateSelectedBackgroundColor = dateSelectedBackgroundColor,
            dateTodayTextColor = dateTodayTextColor,
            dateTodayBackgroundColor = dateTodayBackgroundColor
        )
    }
}