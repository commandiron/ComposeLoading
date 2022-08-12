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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlin.math.*

@Composable
fun CircleDotAnim(
    modifier: Modifier = Modifier,
    size: Dp = 24.dp,
    color: Color = MaterialTheme.colorScheme.surface,
    circleRatio: Float = 0.35f,
    delayBetweenDotsMillis: Int = 75,
    durationMillis: Int = 2700
) {
    val transition = rememberInfiniteTransition()

    val circleAnimation1 = transition.circleDotPathTransition(
        durationMillis = durationMillis
    )
    val circleAnimation2 = transition.circleDotPathTransition(
        durationMillis = durationMillis,
        offsetMillis = delayBetweenDotsMillis
    )
    val circleAnimation3 = transition.circleDotPathTransition(
        durationMillis = durationMillis,
        offsetMillis = delayBetweenDotsMillis * 2
    )
    val circleAnimation4 = transition.circleDotPathTransition(
        durationMillis = durationMillis,
        offsetMillis = delayBetweenDotsMillis * 3
    )
    val circleAnimation5 = transition.circleDotPathTransition(
        durationMillis = durationMillis,
        offsetMillis = delayBetweenDotsMillis * 4
    )
    val circleAnimation6 = transition.circleDotPathTransition(
        durationMillis = durationMillis,
        offsetMillis = delayBetweenDotsMillis * 5
    )
    val circleRadiusMultiplier3 = transition.radiusMultiplierTransition(
        initialValue = 0.512f,
        targetValue = 0.35f,
        durationMillis = durationMillis / 2,
        offsetMillis = delayBetweenDotsMillis * 3
    )
    val circleRadiusMultiplier4 = transition.radiusMultiplierTransition(
        initialValue = 0.64f,
        targetValue = 0.35f,
        durationMillis = durationMillis / 2,
        offsetMillis = delayBetweenDotsMillis * 2
    )
    val circleRadiusMultiplier5 = transition.radiusMultiplierTransition(
        initialValue = 0.8f,
        targetValue = 0.35f,
        durationMillis = durationMillis / 2,
        offsetMillis = delayBetweenDotsMillis
    )
    val circleRadiusMultiplier6 = transition.radiusMultiplierTransition(
        initialValue = 1f,
        targetValue = 0.35f,
        durationMillis = durationMillis / 2,
    )
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ){
        Canvas(modifier = Modifier.size(size)){

            val radius = (this.size.height / 2)
            val radiusCommon = this.size.height / 5 * circleRatio


            val angle1 = (circleAnimation1.value * 360.0)
            val offsetX1 = -(radius * sin(Math.toRadians(angle1))).toFloat() + (this.size.width / 2)
            val offsetY1 = (radius * cos(Math.toRadians(angle1))).toFloat() + (this.size.height / 2)
            drawCircle(
                color = color,
                radius = radiusCommon,
                center = Offset(offsetX1,  offsetY1)
            )

            val angle2 = (circleAnimation2.value * 360.0)
            val offsetX2 = -(radius * sin(Math.toRadians(angle2))).toFloat() + (this.size.width / 2)
            val offsetY2 = (radius * cos(Math.toRadians(angle2))).toFloat() + (this.size.height / 2)
            drawCircle(
                color = color,
                radius = radiusCommon,
                center = Offset(offsetX2,  offsetY2)
            )

            val radius3 = circleRadiusMultiplier3.value * this.size.height / 5
            val angle3 = (circleAnimation3.value * 360.0)
            val offsetX3 = -(radius * sin(Math.toRadians(angle3))).toFloat() + (this.size.width / 2)
            val offsetY3 = (radius * cos(Math.toRadians(angle3))).toFloat() + (this.size.height / 2)
            drawCircle(
                color = color,
                radius = radius3,
                center = Offset(offsetX3,  offsetY3)
            )

            val radius4 = circleRadiusMultiplier4.value * this.size.height / 5
            val angle4 = (circleAnimation4.value * 360.0)
            val offsetX4 = -(radius * sin(Math.toRadians(angle4))).toFloat() + (this.size.width / 2)
            val offsetY4 = (radius * cos(Math.toRadians(angle4))).toFloat() + (this.size.height / 2)
            drawCircle(
                color = color,
                radius = radius4,
                center = Offset(offsetX4,  offsetY4)
            )

            val radius5 = circleRadiusMultiplier5.value * this.size.height / 5
            val angle5 = (circleAnimation5.value * 360.0)
            val offsetX5 = -(radius * sin(Math.toRadians(angle5))).toFloat() + (this.size.width / 2)
            val offsetY5 = (radius * cos(Math.toRadians(angle5))).toFloat() + (this.size.height / 2)
            drawCircle(
                color = color,
                radius = radius5,
                center = Offset(offsetX5,  offsetY5)
            )

            val radius6 = circleRadiusMultiplier6.value * this.size.height / 5
            val angle6 = (circleAnimation6.value * 360.0)
            val offsetX6 = -(radius * sin(Math.toRadians(angle6))).toFloat() + (this.size.width / 2)
            val offsetY6 = (radius * cos(Math.toRadians(angle6))).toFloat() + (this.size.height / 2)
            drawCircle(
                color = color,
                radius = radius6,
                center = Offset(offsetX6,  offsetY6)
            )
        }
    }
}

@Composable
internal fun InfiniteTransition.circleDotPathTransition(
    durationMillis: Int,
    offsetMillis: Int = 0,
    easing: Easing = FastOutSlowInEasing
): State<Float> {
    return animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                this.durationMillis = durationMillis * 4
                0f at 0 with easing
                1.75f at durationMillis with easing
                3.5f at durationMillis * 2 with easing
                5.25f at durationMillis * 3 with easing
                7f at durationMillis * 4 with easing
            },
            RepeatMode.Restart,
            StartOffset(offsetMillis)
        )
    )
}

@Composable
internal fun InfiniteTransition.radiusMultiplierTransition(
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
                this.durationMillis = durationMillis * 8
                initialValue at 0 with easing
                targetValue at durationMillis with easing
                initialValue at durationMillis * 2 with easing
                targetValue at durationMillis * 3 with easing
                initialValue at durationMillis * 4 with easing
                targetValue at durationMillis * 5 with easing
                initialValue at durationMillis * 6 with easing
                targetValue at durationMillis * 7 with easing
                initialValue at durationMillis * 8 with easing
            },
            RepeatMode.Restart,
            StartOffset(offsetMillis = offsetMillis)
        )
    )
}