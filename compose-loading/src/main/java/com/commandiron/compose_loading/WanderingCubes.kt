package com.commandiron.compose_loading

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.commandiron.compose_loading.transition.EaseInOut
import com.commandiron.compose_loading.transition.fractionTransition
import com.commandiron.compose_loading.transition.fractionTransitionDelayAtFirst

@Composable
fun WanderingCubes(
    modifier: Modifier = Modifier,
    size: DpSize = DpSize(30.dp, 30.dp),
    durationMillis: Int = 1800,
    color: Color = MaterialTheme.colorScheme.surface,
) {
    val transition = rememberInfiniteTransition()

    val durationPerFraction = durationMillis / 4

    val x1Multiplier = transition.fractionTransition(
        initialValue = 0f,
        targetValue = 1f,
        durationMillis = durationPerFraction,
        delayMillis = durationMillis / 8,
        repeatMode = RepeatMode.Reverse,
        easing = EaseInOut
    )
    val y1Multiplier = transition.fractionTransition(
        initialValue = 0f,
        targetValue = 1f,
        durationMillis = durationPerFraction,
        delayMillis = durationMillis / 8,
        offsetMillis = durationPerFraction,
        repeatMode = RepeatMode.Reverse,
        easing = EaseInOut
    )
    val x2Multiplier = transition.fractionTransition(
        initialValue = 1f,
        targetValue = 0f,
        durationMillis = durationPerFraction,
        delayMillis = durationMillis / 8,
        repeatMode = RepeatMode.Reverse,
        easing = EaseInOut
    )
    val y2Multiplier = transition.fractionTransition(
        initialValue = 1f,
        targetValue = 0f,
        durationMillis = durationPerFraction,
        delayMillis = durationMillis / 8,
        offsetMillis = durationPerFraction,
        repeatMode = RepeatMode.Reverse,
        easing = EaseInOut
    )

    val rectHeightMultiplier = transition.fractionTransitionDelayAtFirst(
        initialValue = 1f,
        targetValue = 2f,
        durationMillis = durationPerFraction,
        delayMillis = durationPerFraction / 2,
        repeatMode = RepeatMode.Reverse,
        easing = LinearEasing
    )
    val rectWidthMultiplier = transition.fractionTransitionDelayAtFirst(
        initialValue = 1f,
        targetValue = 2f,
        durationMillis = durationPerFraction,
        delayMillis = durationPerFraction / 2,
        repeatMode = RepeatMode.Reverse,
        easing = LinearEasing
    )

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ){
        Canvas(modifier = Modifier.size(size)){
            val width = this.size.width
            val height = this.size.height

            val rectWidth = width / 6
            val rectHeight = height / 6
            val rectSize = Size(
                width = rectWidth * rectWidthMultiplier.value,
                height = rectHeight * rectHeightMultiplier.value
            )

            val effectiveWidth = width - rectSize.width
            val effectiveHeight = height - rectSize.height

            val x1 = x1Multiplier.value * effectiveWidth
            val y1 = y1Multiplier.value * effectiveHeight
            drawRect(
                color = color,
                size = rectSize,
                topLeft = Offset(x1, y1)
            )

            val x2 = x2Multiplier.value * effectiveWidth
            val y2 = y2Multiplier.value * effectiveHeight
            drawRect(
                color = color,
                size = Size(rectWidth, rectHeight),
                topLeft = Offset(x2,y2)
            )
        }
    }
}

@Composable
internal fun InfiniteTransition.offsetMultiplierTransition(
    initialValue: Float,
    targetValue: Float,
    durationMillisPerFraction: Int,
    offsetMillis: Int = 0,
    easing: Easing = FastOutSlowInEasing
): State<Float> {
    return animateFloat(
        initialValue = initialValue,
        targetValue = targetValue,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                this.durationMillis = durationMillisPerFraction * 4
                initialValue at 0 with easing
                targetValue at durationMillisPerFraction with easing
                targetValue at durationMillisPerFraction * 2 with easing
                initialValue at durationMillisPerFraction * 3 with easing
                initialValue at durationMillisPerFraction * 4 with easing
            },
            RepeatMode.Restart,
            StartOffset(offsetMillis)
        )
    )
}

@Composable
internal fun InfiniteTransition.sizeMultiplierTransition(
    initialValue: Float,
    targetValue: Float,
    durationMillisPerFraction: Int,
    offsetMillis: Int = 0,
    easing: Easing = FastOutSlowInEasing
): State<Float> {
    return animateFloat(
        initialValue = initialValue,
        targetValue = targetValue,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                this.durationMillis = durationMillisPerFraction * 4
                initialValue at 0 with easing
                targetValue at durationMillisPerFraction with easing
                initialValue at durationMillisPerFraction * 2 with easing
                targetValue at durationMillisPerFraction * 3 with easing
                initialValue at durationMillisPerFraction * 4 with easing
            },
            RepeatMode.Restart,
            StartOffset(offsetMillis)
        )
    )
}