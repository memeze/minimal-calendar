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

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.waitForUpOrCancellation
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.material.LocalContentAlpha
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.semantics.Role

@Composable
internal fun ScaleButton(
    modifier: Modifier = Modifier,
    pressScale: Float = .95f,
    enabled: Boolean = true,
    onClick: () -> Unit,
    content: @Composable BoxScope.() -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    var pressed by remember { mutableStateOf(false) }
    val scale = animateFloatAsState(if (pressed) pressScale else 1f)
    val alpha by animateFloatAsState(
        targetValue = if (pressed) .5f else 1f,
        animationSpec = tween(durationMillis = 150)
    )

    CompositionLocalProvider(LocalContentAlpha provides alpha) {
        Box(
            modifier = modifier
                .clickable(
                    onClick = onClick,
                    enabled = enabled,
                    role = Role.Button,
                    interactionSource = interactionSource,
                    indication = null
                )
                .scale(scale.value)
                .pointerInput(pressed) {
                    if (enabled) {
                        awaitPointerEventScope {
                            pressed = if (pressed) {
                                waitForUpOrCancellation()
                                false
                            } else {
                                awaitFirstDown(false)
                                true
                            }
                        }
                    }
                },
            contentAlignment = Alignment.Center,
            content = content
        )
    }
}