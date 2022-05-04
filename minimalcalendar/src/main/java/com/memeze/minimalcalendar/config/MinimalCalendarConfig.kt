package com.memeze.minimalcalendar.config

import java.util.*

/**
 * @param yearRange
 * @param locale
 */
data class MinimalCalendarConfig(
    val yearRange: IntRange = IntRange(1900, 2100),
    val locale: Locale = Locale.getDefault()
)
