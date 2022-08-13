package com.commandiron.compose_loading.transition

import androidx.compose.animation.core.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State

@Composable
internal fun InfiniteTransition.fractionTransition(
    initialValue: Float,
    targetValue: Float,
    durationMillis: Int,
    delayMillis: Int = 0,
    offsetMillis: Int = 0,
    repeatMode: RepeatMode = RepeatMode.Restart,
    easing: Easing = FastOutSlowInEasing
): State<Float> {
    return animateFloat(
        initialValue = initialValue,
        targetValue = targetValue,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                this.durationMillis = durationMillis + delayMillis
                initialValue at 0 with easing
                initialValue at delayMillis with easing
                targetValue at durationMillis + delayMillis with easing
            },
            repeatMode,
            StartOffset(offsetMillis)
        )
    )
}

@Composable
internal fun InfiniteTransition.fraction4Transition(
    initialValue: Float,
    targetValue: Float,
    durationMillis: Int,
    delayMillis: Int = 0,
    offsetMillis: Int = 0,
    repeatMode: RepeatMode = RepeatMode.Restart,
    easing: Easing = FastOutSlowInEasing
): State<Float> {
    return animateFloat(
        initialValue = initialValue,
        targetValue = targetValue,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                this.durationMillis = durationMillis + delayMillis
                initialValue at 0 with easing
                initialValue at delayMillis with easing
                targetValue / 4 at durationMillis / 4 + delayMillis with easing
                targetValue / 4 * 2 at durationMillis / 4 * 2 + delayMillis with easing
                targetValue / 4 * 3 at durationMillis / 4 * 3 + delayMillis with easing
                targetValue / 4 * 4 at durationMillis / 4 * 4 + delayMillis with easing
            },
            repeatMode,
            StartOffset(offsetMillis)
        )
    )
}