package com.commandiron.compose_loading

import androidx.compose.animation.core.*
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
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun Circle(
    modifier: Modifier = Modifier,
    size: Dp = 40.dp,
    durationMillis: Int = 1200,
    color: Color = MaterialTheme.colorScheme.primary,
    circleSizeRatio: Float = 1.0f
) {
    val transition = rememberInfiniteTransition()

    val durationPerFraction = durationMillis / 2

    val circleSizeMultiplier1 = transition.fractionTransition(
        initialValue = 0f,
        targetValue = 1f,
        durationMillis = durationPerFraction,
        offsetMillis = durationPerFraction / 6 * 1,
        repeatMode = RepeatMode.Reverse,
        easing = EaseInOut
    )
    val circleSizeMultiplier2 = transition.fractionTransition(
        initialValue = 0f,
        targetValue = 1f,
        durationMillis = durationPerFraction,
        offsetMillis = durationPerFraction / 6 * 2,
        repeatMode = RepeatMode.Reverse,
        easing = EaseInOut
    )
    val circleSizeMultiplier3 = transition.fractionTransition(
        initialValue = 0f,
        targetValue = 1f,
        durationMillis = durationPerFraction,
        offsetMillis = durationPerFraction / 6 * 3,
        repeatMode = RepeatMode.Reverse,
        easing = EaseInOut
    )
    val circleSizeMultiplier4 = transition.fractionTransition(
        initialValue = 0f,
        targetValue = 1f,
        durationMillis = durationPerFraction,
        offsetMillis = durationPerFraction / 6 * 4,
        repeatMode = RepeatMode.Reverse,
        easing = EaseInOut
    )
    val circleSizeMultiplier5 = transition.fractionTransition(
        initialValue = 0f,
        targetValue = 1f,
        durationMillis = durationPerFraction,
        offsetMillis = durationPerFraction / 6 * 5,
        repeatMode = RepeatMode.Reverse,
        easing = EaseInOut
    )
    val circleSizeMultiplier6 = transition.fractionTransition(
        initialValue = 0f,
        targetValue = 1f,
        durationMillis = durationPerFraction,
        offsetMillis = durationPerFraction / 6 * 6,
        repeatMode = RepeatMode.Reverse,
        easing = EaseInOut
    )
    val circleSizeMultiplier7 = transition.fractionTransition(
        initialValue = 0f,
        targetValue = 1f,
        durationMillis = durationMillis / 2,
        offsetMillis = durationPerFraction / 6 * 7,
        repeatMode = RepeatMode.Reverse,
        easing = EaseInOut
    )
    val circleSizeMultiplier8 = transition.fractionTransition(
        initialValue = 0f,
        targetValue = 1f,
        durationMillis = durationMillis / 2,
        offsetMillis = durationPerFraction / 6 * 8,
        repeatMode = RepeatMode.Reverse,
        easing = EaseInOut
    )
    val circleSizeMultiplier9 = transition.fractionTransition(
        initialValue = 0f,
        targetValue = 1f,
        durationMillis = durationMillis / 2,
        offsetMillis = durationPerFraction / 6 * 9,
        repeatMode = RepeatMode.Reverse,
        easing = EaseInOut
    )
    val circleSizeMultiplier10 = transition.fractionTransition(
        initialValue = 0f,
        targetValue = 1f,
        durationMillis = durationMillis / 2,
        offsetMillis = durationPerFraction / 6 * 10,
        repeatMode = RepeatMode.Reverse,
        easing = EaseInOut
    )
    val circleSizeMultiplier11 = transition.fractionTransition(
        initialValue = 0f,
        targetValue = 1f,
        durationMillis = durationMillis / 2,
        offsetMillis = durationPerFraction / 6 * 11,
        repeatMode = RepeatMode.Reverse,
        easing = EaseInOut
    )
    val circleSizeMultiplier12 = transition.fractionTransition(
        initialValue = 0f,
        targetValue = 1f,
        durationMillis = durationMillis / 2,
        offsetMillis = durationPerFraction / 6 * 12,
        repeatMode = RepeatMode.Reverse,
        easing = EaseInOut
    )

    Canvas(modifier = modifier.size(size)){
        val pathRadius = (this.size.height / 2)
        val radius1 = this.size.height / 12 * circleSizeRatio * circleSizeMultiplier1.value
        val radius2 = this.size.height / 12 * circleSizeRatio * circleSizeMultiplier2.value
        val radius3 = this.size.height / 12 * circleSizeRatio * circleSizeMultiplier3.value
        val radius4 = this.size.height / 12 * circleSizeRatio * circleSizeMultiplier4.value
        val radius5 = this.size.height / 12 * circleSizeRatio * circleSizeMultiplier5.value
        val radius6 = this.size.height / 12 * circleSizeRatio * circleSizeMultiplier6.value
        val radius7 = this.size.height / 12 * circleSizeRatio * circleSizeMultiplier7.value
        val radius8 = this.size.height / 12 * circleSizeRatio * circleSizeMultiplier8.value
        val radius9 = this.size.height / 12 * circleSizeRatio * circleSizeMultiplier9.value
        val radius10 = this.size.height / 12 * circleSizeRatio * circleSizeMultiplier10.value
        val radius11 = this.size.height / 12 * circleSizeRatio * circleSizeMultiplier11.value
        val radius12 = this.size.height / 12 * circleSizeRatio * circleSizeMultiplier12.value

        for(i in 0 until 12){
            val angle = i / 12.toDouble() * 360.0
            val offsetX = -(pathRadius * sin(Math.toRadians(angle))).toFloat() + pathRadius
            val offsetY = (pathRadius * cos(Math.toRadians(angle))).toFloat() + pathRadius
            drawCircle(
                color = color,
                radius = when(i){
                    0 -> radius1
                    1 -> radius2
                    2 -> radius3
                    3 -> radius4
                    4 -> radius5
                    5 -> radius6
                    6 -> radius7
                    7 -> radius8
                    8 -> radius9
                    9 -> radius10
                    10 -> radius11
                    11 -> radius12
                    else -> radius1
                },
                center = Offset(offsetX,  offsetY)
            )
        }
    }
}