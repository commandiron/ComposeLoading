package com.commandiron.compose_loading

import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.InfiniteTransition
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.StartOffset
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp

@Composable
fun WanderingCubesAnim(
    modifier: Modifier = Modifier,
    size: DpSize = DpSize(36.dp, 36.dp),
    color: Color = MaterialTheme.colorScheme.surface,
    durationMillisPerFraction: Int = 600
) {
    val transition = rememberInfiniteTransition()

    val x1Multiplier by transition.offsetMultiplierTransition(
        initialValue = 0f,
        targetValue = 1f,
        durationMillisPerFraction = durationMillisPerFraction
    )
    val y1Multiplier by transition.offsetMultiplierTransition(
        initialValue = 0f,
        targetValue = 1f,
        durationMillisPerFraction = durationMillisPerFraction,
        offsetMillis = durationMillisPerFraction
    )
    val x2Multiplier by transition.offsetMultiplierTransition(
        initialValue = 1f,
        targetValue = 0f,
        durationMillisPerFraction = durationMillisPerFraction
    )
    val y2Multiplier by transition.offsetMultiplierTransition(
        initialValue = 1f,
        targetValue = 0f,
        durationMillisPerFraction = durationMillisPerFraction,
        offsetMillis = durationMillisPerFraction
    )

    val rectHeightMultiplier by transition.sizeMultiplierTransition(
        initialValue = 2f,
        targetValue = 1f,
        durationMillisPerFraction = durationMillisPerFraction
    )
    val rectWidthMultiplier by transition.sizeMultiplierTransition(
        initialValue = 2f,
        targetValue = 1f,
        durationMillisPerFraction = durationMillisPerFraction
    )

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ){
        Canvas(modifier = Modifier.size(size)){
            val height = this.size.height
            val width = this.size.width

            val rectHeight = height / 6
            val rectWidth = width / 6
            val rectSize = Size(
                width = rectHeight * rectHeightMultiplier,
                height = rectWidth * rectWidthMultiplier
            )

            val x1 = x1Multiplier * (width - rectSize.width)
            val y1 = y1Multiplier * (height - rectSize.height)
            drawRect(
                color = color,
                size = rectSize,
                topLeft = Offset(x1, y1)
            )

            val x2 = x2Multiplier * (width - rectSize.width)
            val y2 = y2Multiplier * (height - rectSize.height)
            drawRect(
                color = color,
                size = rectSize,
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