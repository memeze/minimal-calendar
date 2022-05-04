package com.memeze.minimalcalendar.config

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

object MinimalCalendarTheme {
    @Composable
    fun colors(
        defaultColor: Color = MaterialTheme.colors.onBackground,
        backgroundColor: Color = MaterialTheme.colors.background,
        headerBackgroundColor: Color = backgroundColor,
        headerDateTextColor: Color = defaultColor,
        headerTodayIconColor: Color = defaultColor,
        headerArrowIconColor: Color = defaultColor,
        headerSelectIconColor: Color = MaterialTheme.colors.primary,
        selectionBackgroundColor: Color = backgroundColor,
        selectionItemTextColor: Color = defaultColor,
        selectionItemSelectedBackgroundColor: Color = MaterialTheme.colors.primary.copy(.1f),
        selectionItemSelectedTextColor: Color = defaultColor,
        selectionButtonBackgroundColor: Color = MaterialTheme.colors.primary.copy(.5f),
        selectionButtonTextColor: Color = MaterialTheme.colors.onPrimary,
        weekBackgroundColor: Color = backgroundColor,
        weekTextColor: Color = defaultColor.copy(.3f),
        dateTextColor: Color = defaultColor,
        selectedBackgroundColor: Color = MaterialTheme.colors.primary.copy(.5f),
        selectedTextColor: Color = MaterialTheme.colors.onPrimary,
        todayBackgroundColor: Color = MaterialTheme.colors.primary.copy(.1f),
        todayTextColor: Color = MaterialTheme.colors.onSurface,
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
            selectedTextColor = selectedTextColor,
            todayTextColor = todayTextColor,
            selectedBackgroundColor = selectedBackgroundColor,
            todayBackgroundColor = todayBackgroundColor
        )
    }
}