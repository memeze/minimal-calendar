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

object Constant {
    const val DATE_PATTERN = "MMM y"
    const val DAY_OF_WEEK_COUNT = 7
    const val DAY_ITEM_SIZE = 56
    const val WEEK_HEIGHT = 44
    const val WEEK_MAX_COUNT = 6
    const val CALENDAR_MAX_WIDTH = 600
    const val CALENDAR_MAX_HEIGHT = DAY_ITEM_SIZE * WEEK_MAX_COUNT
    const val SELECT_ITEM_HEIGHT = 44
    const val SELECT_LIST_HEIGHT = SELECT_ITEM_HEIGHT * 5
}