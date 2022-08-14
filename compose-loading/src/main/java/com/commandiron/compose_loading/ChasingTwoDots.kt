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
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.commandiron.compose_loading.transition.EaseInOut
import com.commandiron.compose_loading.transition.fractionTransition
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun ChasingTwoDots(
    modifier: Modifier = Modifier,
    durationMillis: Int = 2000,
    durationBetweenDotsMillis: Int = 400,
    size: DpSize = DpSize(30.dp, 30.dp),
    color: Color = MaterialTheme.colorScheme.primary,
) {
    val transition = rememberInfiniteTransition()

    val dotPathMultiplier1 = transition.fractionTransition(
        initialValue = 0f,
        targetValue = 1f,
        fraction = 2,
        durationMillis = durationMillis,
        easing = LinearEasing
    )
    val dotPathMultiplier2 = transition.fractionTransition(
        initialValue = 0f,
        targetValue = 1f,
        fraction = 2,
        durationMillis = durationMillis,
        offsetMillis = durationBetweenDotsMillis,
        easing = LinearEasing
    )

    val circleRadiusMultiplier1 = transition.fractionTransition(
        initialValue = 0f,
        targetValue = 1f,
        durationMillis = durationMillis / 2,
        repeatMode = RepeatMode.Reverse,
        easing = EaseInOut
    )
    val circleRadiusMultiplier2 = transition.fractionTransition(
        initialValue = 0f,
        targetValue = 1f,
        durationMillis = durationMillis / 2,
        repeatMode = RepeatMode.Reverse,
        offsetMillis = durationMillis / 2,
        easing = EaseInOut
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