package com.commandiron.compose_loading

import androidx.annotation.IntRange
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
import com.commandiron.compose_loading.transition.EaseInOut
import com.commandiron.compose_loading.transition.fractionTransition
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun FadingCircle(
    modifier: Modifier = Modifier,
    size: Dp = 24.dp,
    durationMillis: Int = 1200,
    color: Color = MaterialTheme.colorScheme.primary,
    circleSizeRatio: Float = 1.0f
) {
    val transition = rememberInfiniteTransition()

    val durationPerFraction = durationMillis / 2

    val circleAlpha1 = transition.fractionTransition(
        initialValue = 1f,
        targetValue = 0f,
        durationMillis = durationPerFraction,
        delayMillis = durationPerFraction,
        offsetMillis = durationPerFraction / 6 * 1,
        easing = EaseInOut
    )
    val circleAlpha2 = transition.fractionTransition(
        initialValue = 1f,
        targetValue = 0f,
        durationMillis = durationPerFraction,
        delayMillis = durationPerFraction,
        offsetMillis = durationPerFraction / 6 * 2,
        easing = EaseInOut
    )
    val circleAlpha3 = transition.fractionTransition(
        initialValue = 1f,
        targetValue = 0f,
        durationMillis = durationPerFraction,
        delayMillis = durationPerFraction,
        offsetMillis = durationPerFraction / 6 * 3,
        easing = EaseInOut
    )
    val circleAlpha4 = transition.fractionTransition(
        initialValue = 1f,
        targetValue = 0f,
        durationMillis = durationPerFraction,
        delayMillis = durationPerFraction,
        offsetMillis = durationPerFraction / 6 * 4,
        easing = EaseInOut
    )
    val circleAlpha5 = transition.fractionTransition(
        initialValue = 1f,
        targetValue = 0f,
        durationMillis = durationPerFraction,
        delayMillis = durationPerFraction,
        offsetMillis = durationPerFraction / 6 * 5,
        easing = EaseInOut
    )
    val circleAlpha6 = transition.fractionTransition(
        initialValue = 1f,
        targetValue = 0f,
        durationMillis = durationPerFraction,
        delayMillis = durationPerFraction,
        offsetMillis = durationPerFraction / 6 * 6,
        easing = EaseInOut
    )
    val circleAlpha7 = transition.fractionTransition(
        initialValue = 1f,
        targetValue = 0f,
        durationMillis = durationPerFraction,
        delayMillis = durationPerFraction,
        offsetMillis = durationPerFraction / 6 * 7,
        easing = EaseInOut
    )
    val circleAlpha8 = transition.fractionTransition(
        initialValue = 1f,
        targetValue = 0f,
        durationMillis = durationPerFraction,
        delayMillis = durationPerFraction,
        offsetMillis = durationPerFraction / 6 * 8,
        easing = EaseInOut
    )
    val circleAlpha9 = transition.fractionTransition(
        initialValue = 1f,
        targetValue = 0f,
        durationMillis = durationPerFraction,
        delayMillis = durationPerFraction,
        offsetMillis = durationPerFraction / 6 * 9,
        easing = EaseInOut
    )
    val circleAlpha10 = transition.fractionTransition(
        initialValue = 1f,
        targetValue = 0f,
        durationMillis = durationPerFraction,
        delayMillis = durationPerFraction,
        offsetMillis = durationPerFraction / 6 * 10,
        easing = EaseInOut
    )
    val circleAlpha11 = transition.fractionTransition(
        initialValue = 1f,
        targetValue = 0f,
        durationMillis = durationPerFraction,
        delayMillis = durationPerFraction,
        offsetMillis = durationPerFraction / 6 * 11,
        easing = EaseInOut
    )
    val circleAlpha12 = transition.fractionTransition(
        initialValue = 1f,
        targetValue = 0f,
        durationMillis = durationPerFraction,
        delayMillis = durationPerFraction,
        offsetMillis = durationPerFraction / 6 * 12,
        easing = EaseInOut
    )

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.size(size)) {
            val pathRadius = (this.size.height / 2)

            val radius = this.size.height / 12 * circleSizeRatio

            for(i in 0 until 12){
                val angle = i / 12.toDouble() * 360.0
                val offsetX = -(pathRadius * sin(Math.toRadians(angle))).toFloat() + pathRadius
                val offsetY = (pathRadius * cos(Math.toRadians(angle))).toFloat() + pathRadius

                drawCircle(
                    color = color,
                    radius = radius,
                    center = Offset(offsetX,  offsetY),
                    alpha = when(i){
                        0 -> circleAlpha1.value
                        1 -> circleAlpha2.value
                        2 -> circleAlpha3.value
                        3 -> circleAlpha4.value
                        4 -> circleAlpha5.value
                        5 -> circleAlpha6.value
                        6 -> circleAlpha7.value
                        7 -> circleAlpha8.value
                        8 -> circleAlpha9.value
                        9 -> circleAlpha10.value
                        10 -> circleAlpha11.value
                        11 -> circleAlpha12.value
                        else -> circleAlpha1.value
                    }
                )
            }
        }
    }
}