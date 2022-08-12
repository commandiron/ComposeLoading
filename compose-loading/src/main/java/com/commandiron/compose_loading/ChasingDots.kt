package com.commandiron.compose_loading

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun ChasingDots(
    modifier: Modifier = Modifier,
    size: DpSize = DpSize(24.dp, 24.dp),
    color: Color = MaterialTheme.colorScheme.surface,
    durationMillis: Int = 1800
) {
    val transition = rememberInfiniteTransition()

    val dotPathMultiplier1 = transition.chasingDotPathMultiplierTransition(
        durationMillis =  durationMillis
    )
    val dotPathMultiplier2 = transition.chasingDotPathMultiplierTransition2(
        durationMillis =  durationMillis
    )

    val circleRadiusMultiplier1 = transition.chasingDotRadiusMultiplierTransition(
        initialValue = 0f,
        targetValue = 1f,
        durationMillis = durationMillis / 2
    )
    val circleRadiusMultiplier2 = transition.chasingDotRadiusMultiplierTransition(
        initialValue = 0f,
        targetValue = 1f,
        durationMillis = durationMillis / 2,
        offsetMillis = durationMillis / 2
    )

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ){
        Canvas(modifier = Modifier.size(size)){

            val radius = (this.size.height / 2)
            val radiusCommon = this.size.height / 3

            val radius1 = circleRadiusMultiplier1.value * radiusCommon
            val angle1 = (dotPathMultiplier1.value * 360.0)
            val offsetX1 = -(radius * sin(Math.toRadians(angle1))).toFloat() + (this.size.width / 2)
            val offsetY1 = (radius * cos(Math.toRadians(angle1))).toFloat() + (this.size.height / 2)
            drawCircle(
                color = color,
                radius = radius1,
                center = Offset(offsetX1,  offsetY1)
            )

            val radius2 = circleRadiusMultiplier2.value * radiusCommon
            val angle2 = (dotPathMultiplier2.value * 360.0)
            val offsetX2 = -(radius * sin(Math.toRadians(angle2))).toFloat() + (this.size.width / 2)
            val offsetY2 = (radius * cos(Math.toRadians(angle2))).toFloat() + (this.size.height / 2)
            drawCircle(
                color = color,
                radius = radius2,
                center = Offset(offsetX2,  offsetY2)
            )
        }
    }
}

@Composable
internal fun InfiniteTransition.chasingDotPathMultiplierTransition(
    durationMillis: Int,
    offsetMillis: Int = 0,
    easing: Easing = LinearEasing
): State<Float> {
    return animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                this.durationMillis = durationMillis
                0f at 0 with easing
                1f at durationMillis with easing
            },
            RepeatMode.Restart,
            StartOffset(offsetMillis)
        )
    )
}

@Composable
internal fun InfiniteTransition.chasingDotPathMultiplierTransition2(
    durationMillis: Int,
    offsetMillis: Int = 0,
    easing: Easing = LinearEasing
): State<Float> {
    return animateFloat(
        initialValue = 0.5f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                this.durationMillis = durationMillis
                0.5f at 0 with easing
                1f at durationMillis / 2 with easing
                1.5f at durationMillis with easing
            },
            RepeatMode.Restart,
            StartOffset(offsetMillis)
        )
    )
}

@Composable
internal fun InfiniteTransition.chasingDotRadiusMultiplierTransition(
    initialValue: Float,
    targetValue: Float,
    durationMillis: Int,
    offsetMillis: Int = 0,
    easing: Easing = FastOutSlowInEasing
): State<Float> {
    return animateFloat(
        initialValue = initialValue,
        targetValue = targetValue,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                this.durationMillis = durationMillis * 2
                initialValue at 0 with easing
                targetValue at durationMillis with easing
                initialValue at durationMillis * 2 with easing
            },
            RepeatMode.Restart,
            StartOffset(offsetMillis = offsetMillis)
        )
    )
}