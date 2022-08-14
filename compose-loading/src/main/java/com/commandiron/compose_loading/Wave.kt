package com.commandiron.compose_loading

import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.commandiron.compose_loading.transition.EaseInOut
import com.commandiron.compose_loading.transition.fractionTransition
import com.commandiron.compose_loading.transition.fractionTransitionDelayAtFirst

@Composable
fun Wave(
    modifier: Modifier = Modifier,
    size: Dp = 24.dp,
    durationMillis: Int = 1200,
    delayMillis: Int = 400,
    color: Color = MaterialTheme.colorScheme.surface,
    shape: Shape = Shapes.None,
) {
    val transition = rememberInfiniteTransition()

    val aspectRatio1 = transition.fractionTransitionDelayAtFirst(
        initialValue = 0.25f,
        targetValue = 0.1f,
        durationMillis = durationMillis / 5,
        delayMillis = delayMillis,
        repeatMode = RepeatMode.Reverse,
        easing = EaseInOut
    )
    val aspectRatio2 = transition.fractionTransitionDelayAtFirst(
        initialValue = 0.25f,
        targetValue = 0.1f,
        durationMillis = durationMillis / 5,
        delayMillis = delayMillis,
        offsetMillis = durationMillis / 12,
        repeatMode = RepeatMode.Reverse,
        easing = EaseInOut
    )
    val aspectRatio3 = transition.fractionTransitionDelayAtFirst(
        initialValue = 0.25f,
        targetValue = 0.1f,
        durationMillis = durationMillis / 5,
        delayMillis = delayMillis,
        offsetMillis = durationMillis / 12 * 2,
        repeatMode = RepeatMode.Reverse,
        easing = EaseInOut
    )
    val aspectRatio4 = transition.fractionTransitionDelayAtFirst(
        initialValue = 0.25f,
        targetValue = 0.1f,
        durationMillis = durationMillis / 5,
        delayMillis = delayMillis,
        offsetMillis = durationMillis / 12 * 3,
        repeatMode = RepeatMode.Reverse,
        easing = EaseInOut
    )
    val aspectRatio5 = transition.fractionTransitionDelayAtFirst(
        initialValue = 0.25f,
        targetValue = 0.1f,
        durationMillis = durationMillis / 5,
        delayMillis = delayMillis,
        offsetMillis = durationMillis / 12 * 4,
        repeatMode = RepeatMode.Reverse,
        easing = EaseInOut
    )
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Surface(
            modifier = Modifier
                .size(size / 6)
                .aspectRatio(aspectRatio1.value),
            color = color,
            shape = shape
        ) {}
        Spacer(modifier = Modifier.width(size / 12))
        Surface(
            modifier = Modifier
                .size(size / 6)
                .aspectRatio(aspectRatio2.value),
            color = color,
            shape = shape
        ) {}
        Spacer(modifier = Modifier.width(size/ 12))
        Surface(
            modifier = Modifier
                .size(size / 6)
                .aspectRatio(aspectRatio3.value),
            color = color,
            shape = shape
        ) {}
        Spacer(modifier = Modifier.width(size / 12))
        Surface(
            modifier = Modifier
                .size(size / 6)
                .aspectRatio(aspectRatio4.value),
            color = color,
            shape = shape
        ) {}
        Spacer(modifier = Modifier.width(size / 12))
        Surface(
            modifier = Modifier
                .size(size / 6)
                .aspectRatio(aspectRatio5.value),
            color = color,
            shape = shape
        ) {}
    }
}