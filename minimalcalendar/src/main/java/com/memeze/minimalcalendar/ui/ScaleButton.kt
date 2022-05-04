package com.memeze.minimalcalendar.ui

import android.view.MotionEvent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentAlpha
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.input.pointer.pointerInteropFilter

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ScaleButton(
    modifier: Modifier = Modifier,
    pressScale: Float = .9f,
    enabled: Boolean = true,
    onClick: () -> Unit,
    content: @Composable BoxScope.() -> Unit
) {
    var pressed by remember { mutableStateOf(false) }
    val scale = animateFloatAsState(if (pressed) pressScale else 1f)

    CompositionLocalProvider(
        LocalContentAlpha provides if (pressed) ContentAlpha.medium else 1f,
    ) {
        Box(
            modifier = modifier
                .scale(scale.value)
                .pointerInteropFilter {
                    if (enabled) {
                        when (it.action) {
                            MotionEvent.ACTION_DOWN -> {
                                pressed = true
                            }
                            MotionEvent.ACTION_UP -> {
                                pressed = false
                                onClick()
                            }
                            MotionEvent.ACTION_CANCEL -> {
                                pressed = false
                            }
                        }
                    } else {
                        pressed = false
                    }
                    true
                },
            contentAlignment = Alignment.Center,
            content = content
        )
    }
}