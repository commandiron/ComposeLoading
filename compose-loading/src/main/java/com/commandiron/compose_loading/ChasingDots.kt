package com.commandiron.compose_loading

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.commandiron.compose_loading.transition.EaseInOut
import com.commandiron.compose_loading.transition.fractionTransition
import kotlin.math.*

@Composable
fun ChasingDots(
    modifier: Modifier = Modifier,
    durationMillis: Int = 2000,
    delayBetweenDotsMillis: Int = 50,
    size: Dp = 40.dp,
    color: Color = MaterialTheme.colorScheme.primary,
    circleRatio: Float = 0.25f
) {
    val transition = rememberInfiniteTransition()

    val pathAngleMultiplier1 = transition.fractionTransition(
        initialValue = 0f,
        targetValue = 7f,
        fraction = 4,
        durationMillis = durationMillis * 4,
        easing = EaseInOut
    )
    val pathAngleMultiplier2 = transition.fractionTransition(
        initialValue = 0f,
        targetValue = 7f,
        fraction = 4,
        durationMillis = durationMillis * 4,
        offsetMillis = delayBetweenDotsMillis,
        easing = EaseInOut
    )
    val pathAngleMultiplier3 = transition.fractionTransition(
        initialValue = 0f,
        targetValue = 7f,
        fraction = 4,
        durationMillis = durationMillis * 4,
        offsetMillis = delayBetweenDotsMillis * 2,
        easing = EaseInOut
    )
    val pathAngleMultiplier4 = transition.fractionTransition(
        initialValue = 0f,
        targetValue = 7f,
        fraction = 4,
        durationMillis = durationMillis * 4,
        offsetMillis = delayBetweenDotsMillis * 3,
        easing = EaseInOut
    )
    val pathAngleMultiplier5 = transition.fractionTransition(
        initialValue = 0f,
        targetValue = 7f,
        fraction = 4,
        durationMillis = durationMillis * 4,
        offsetMillis = delayBetweenDotsMillis * 4,
        easing = EaseInOut
    )
    val pathAngleMultiplier6 = transition.fractionTransition(
        initialValue = 0f,
        targetValue = 7f,
        fraction = 4,
        durationMillis = durationMillis * 4,
        offsetMillis = delayBetweenDotsMillis * 5,
        easing = EaseInOut
    )
    val circleRadiusMultiplier3 = transition.fractionTransition(
        initialValue = 0.512f,
        targetValue = circleRatio,
        durationMillis = durationMillis / 2,
        repeatMode = RepeatMode.Reverse,
        easing = LinearEasing
    )
    val circleRadiusMultiplier4 = transition.fractionTransition(
        initialValue = 0.64f,
        targetValue = circleRatio,
        durationMillis = durationMillis / 2,
        repeatMode = RepeatMode.Reverse,
        easing = LinearEasing
    )
    val circleRadiusMultiplier5 = transition.fractionTransition(
        initialValue = 0.8f,
        targetValue = circleRatio,
        durationMillis = durationMillis / 2,
        repeatMode = RepeatMode.Reverse,
        easing = LinearEasing
    )
    val circleRadiusMultiplier6 = transition.fractionTransition(
        initialValue = 1f,
        targetValue = circleRatio,
        durationMillis = durationMillis / 2,
        repeatMode = RepeatMode.Reverse,
        easing = LinearEasing
    )
    Canvas(modifier = modifier.size(size)){

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