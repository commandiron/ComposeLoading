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

@Composable
fun WanderingCubes(
    modifier: Modifier = Modifier,
    durationMillis: Int = 1800,
    size: DpSize = DpSize(30.dp, 30.dp),
    color: Color = MaterialTheme.colorScheme.surface,
) {
    val transition = rememberInfiniteTransition()

    val durationPerFraction = durationMillis / 4

    val x1Multiplier = transition.wanderingCubesTransition(
        initialValue = 1f,
        targetValue = 0f,
        durationMillisPerFraction = durationPerFraction
    )
    val y1Multiplier = transition.wanderingCubesTransition(
        initialValue = 1f,
        targetValue = 0f,
        durationMillisPerFraction = durationPerFraction,
        offsetMillis = durationPerFraction
    )
    val x2Multiplier = transition.wanderingCubesTransition(
        initialValue = 0f,
        targetValue = 1f,
        durationMillisPerFraction = durationPerFraction,
    )
    val y2Multiplier = transition.wanderingCubesTransition(
        initialValue = 0f,
        targetValue = 1f,
        durationMillisPerFraction = durationPerFraction,
        offsetMillis = durationPerFraction
    )
    val rectHeightMultiplier = transition.wanderingCubesTransition(
        initialValue = 2f,
        targetValue = 1f,
        durationMillisPerFraction = durationPerFraction / 2
    )
    val rectWidthMultiplier = transition.wanderingCubesTransition(
        initialValue = 2f,
        targetValue = 1f,
        durationMillisPerFraction = durationPerFraction / 2
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
                size = rectSize,
                topLeft = Offset(x2,y2)
            )
        }
    }
}

@Composable
internal fun InfiniteTransition.wanderingCubesTransition(
    initialValue: Float,
    targetValue: Float,
    durationMillisPerFraction: Int,
    offsetMillis: Int = 0,
    easing: Easing = EaseInOut
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