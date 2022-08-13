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
import com.commandiron.compose_loading.transition.fraction4Transition
import kotlin.math.*

@Composable
fun ChasingDots(
    modifier: Modifier = Modifier,
    size: Dp = 30.dp,
    durationMillis: Int = 2500,
    delayBetweenDotsMillis: Int = 50,
    circleRatio: Float = 0.25f,
    color: Color = MaterialTheme.colorScheme.surface
) {
    val transition = rememberInfiniteTransition()

    val pathAngleMultiplier1 = transition.fraction4Transition(
        initialValue = 0f,
        targetValue = 7f,
        durationMillis = durationMillis * 4
    )
    val pathAngleMultiplier2 = transition.fraction4Transition(
        initialValue = 0f,
        targetValue = 7f,
        durationMillis = durationMillis * 4,
        offsetMillis = delayBetweenDotsMillis
    )
    val pathAngleMultiplier3 = transition.fraction4Transition(
        initialValue = 0f,
        targetValue = 7f,
        durationMillis = durationMillis * 4,
        offsetMillis = delayBetweenDotsMillis * 2
    )
    val pathAngleMultiplier4 = transition.fraction4Transition(
        initialValue = 0f,
        targetValue = 7f,
        durationMillis = durationMillis * 4,
        offsetMillis = delayBetweenDotsMillis * 3
    )
    val pathAngleMultiplier5 = transition.fraction4Transition(
        initialValue = 0f,
        targetValue = 7f,
        durationMillis = durationMillis * 4,
        offsetMillis = delayBetweenDotsMillis * 4
    )
    val pathAngleMultiplier6 = transition.fraction4Transition(
        initialValue = 0f,
        targetValue = 7f,
        durationMillis = durationMillis * 4,
        offsetMillis = delayBetweenDotsMillis * 5
    )

    val circleRadiusMultiplier3 = transition.chasingDotsRadiusMultiplierTransition(
        initialValue = 0.512f,
        targetValue = circleRatio,
        durationMillis = durationMillis / 2,
        offsetMillis = delayBetweenDotsMillis * 3
    )
    val circleRadiusMultiplier4 = transition.chasingDotsRadiusMultiplierTransition(
        initialValue = 0.64f,
        targetValue = circleRatio,
        durationMillis = durationMillis / 2,
        offsetMillis = delayBetweenDotsMillis * 2
    )
    val circleRadiusMultiplier5 = transition.chasingDotsRadiusMultiplierTransition(
        initialValue = 0.8f,
        targetValue = circleRatio,
        durationMillis = durationMillis / 2,
        offsetMillis = delayBetweenDotsMillis
    )
    val circleRadiusMultiplier6 = transition.chasingDotsRadiusMultiplierTransition(
        initialValue = 1f,
        targetValue = circleRatio,
        durationMillis = durationMillis / 2,
    )
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ){
        Canvas(modifier = Modifier.size(size)){

            val pathRadius = (this.size.height / 2)
            val radius = this.size.height / 5
            val radiusCommon = radius * circleRatio

            val angle1 = (pathAngleMultiplier1.value * 360.0)
            val offsetX1 = -(pathRadius * sin(Math.toRadians(angle1))).toFloat() + (this.size.width / 2)
            val offsetY1 = (pathRadius * cos(Math.toRadians(angle1))).toFloat() + (this.size.height / 2)
            drawCircle(
                color = color,
                radius = radiusCommon,
                center = Offset(offsetX1,  offsetY1)
            )

            val angle2 = (pathAngleMultiplier2.value * 360.0)
            val offsetX2 = -(pathRadius * sin(Math.toRadians(angle2))).toFloat() + (this.size.width / 2)
            val offsetY2 = (pathRadius * cos(Math.toRadians(angle2))).toFloat() + (this.size.height / 2)
            drawCircle(
                color = color,
                radius = radiusCommon,
                center = Offset(offsetX2,  offsetY2)
            )

            val radius3 = circleRadiusMultiplier3.value * radius
            val angle3 = (pathAngleMultiplier3.value * 360.0)
            val offsetX3 = -(pathRadius * sin(Math.toRadians(angle3))).toFloat() + (this.size.width / 2)
            val offsetY3 = (pathRadius * cos(Math.toRadians(angle3))).toFloat() + (this.size.height / 2)
            drawCircle(
                color = color,
                radius = radius3,
                center = Offset(offsetX3,  offsetY3)
            )

            val radius4 = circleRadiusMultiplier4.value * radius
            val angle4 = (pathAngleMultiplier4.value * 360.0)
            val offsetX4 = -(pathRadius * sin(Math.toRadians(angle4))).toFloat() + (this.size.width / 2)
            val offsetY4 = (pathRadius * cos(Math.toRadians(angle4))).toFloat() + (this.size.height / 2)
            drawCircle(
                color = color,
                radius = radius4,
                center = Offset(offsetX4,  offsetY4)
            )

            val radius5 = circleRadiusMultiplier5.value * radius
            val angle5 = (pathAngleMultiplier5.value * 360.0)
            val offsetX5 = -(pathRadius * sin(Math.toRadians(angle5))).toFloat() + (this.size.width / 2)
            val offsetY5 = (pathRadius * cos(Math.toRadians(angle5))).toFloat() + (this.size.height / 2)
            drawCircle(
                color = color,
                radius = radius5,
                center = Offset(offsetX5,  offsetY5)
            )

            val radius6 = circleRadiusMultiplier6.value * radius
            val angle6 = (pathAngleMultiplier6.value * 360.0)
            val offsetX6 = -(pathRadius * sin(Math.toRadians(angle6))).toFloat() + (this.size.width / 2)
            val offsetY6 = (pathRadius * cos(Math.toRadians(angle6))).toFloat() + (this.size.height / 2)
            drawCircle(
                color = color,
                radius = radius6,
                center = Offset(offsetX6,  offsetY6)
            )
        }
    }
}

@Composable
internal fun InfiniteTransition.chasingDotsRadiusMultiplierTransition(
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