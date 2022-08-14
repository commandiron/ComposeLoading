package com.commandiron.compose_loading.transition

import androidx.annotation.IntRange
import androidx.compose.animation.core.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State

@Composable
internal fun InfiniteTransition.fractionTransition(
    initialValue: Float,
    targetValue: Float,
    @IntRange(from = 1, to = 4) fraction: Int = 1,
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
                this.delayMillis = delayMillis
                initialValue at 0 with easing
                when(fraction){
                    1 ->{
                        targetValue at durationMillis with easing
                    }
                    2 ->{
                        targetValue / fraction at durationMillis / fraction with easing
                        targetValue at durationMillis with easing
                    }
                    3 ->{
                        targetValue / fraction at durationMillis / fraction with easing
                        targetValue / fraction * 2 at durationMillis / fraction * 2 with easing
                        targetValue at durationMillis with easing
                    }
                    4 ->{
                        targetValue / fraction at durationMillis / fraction with easing
                        targetValue / fraction * 2 at durationMillis / fraction * 2 with easing
                        targetValue / fraction * 3 at durationMillis / fraction * 3 with easing
                        targetValue at durationMillis with easing
                    }
                }
            },
            repeatMode,
            StartOffset(offsetMillis)
        )
    )
}

@Composable
internal fun InfiniteTransition.fractionTransitionDelayAtFirst(
    initialValue: Float,
    targetValue: Float,
    @IntRange(from = 1, to = 4) fraction: Int = 1,
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
                when(fraction){
                    1 ->{
                        initialValue at delayMillis with easing
                        targetValue at durationMillis + delayMillis with easing
                    }
                    2 ->{
                        initialValue at delayMillis with easing
                        targetValue / fraction at durationMillis / fraction with easing
                        targetValue at durationMillis + delayMillis with easing
                    }
                    3 ->{
                        initialValue at delayMillis with easing
                        targetValue / fraction at durationMillis / fraction with easing
                        targetValue / fraction * 2 at durationMillis / fraction * 2 with easing
                        targetValue at durationMillis + delayMillis with easing
                    }
                    4 ->{
                        initialValue at delayMillis with easing
                        targetValue / fraction at durationMillis / fraction with easing
                        targetValue / fraction * 2 at durationMillis / fraction * 2 with easing
                        targetValue / fraction * 3 at durationMillis / fraction * 3 with easing
                        targetValue at durationMillis + delayMillis with easing
                    }
                }
            },
            repeatMode,
            StartOffset(offsetMillis)
        )
    )
}

val EaseInOut = CubicBezierEasing(0.42f, 0f, 0.58f, 1f)