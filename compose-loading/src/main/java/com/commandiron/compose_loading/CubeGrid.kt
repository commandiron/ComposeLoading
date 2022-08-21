package com.commandiron.compose_loading

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.commandiron.compose_loading.transition.EaseInOut
import com.commandiron.compose_loading.transition.fractionTransition

@Composable
fun CubeGrid(
    modifier: Modifier = Modifier,
    size: DpSize = DpSize(24.dp, 24.dp),
    durationMillis: Int = 1000,
    color: Color = MaterialTheme.colorScheme.primary,
) {
    val transition = rememberInfiniteTransition()

    val durationPerFraction = durationMillis / 2

    val rectSizeMultiplier1 = transition.fractionTransition(
        initialValue = 1f,
        targetValue = 0f,
        durationMillis = durationPerFraction,
        delayMillis = durationMillis / 4,
        repeatMode = RepeatMode.Reverse,
        easing = EaseInOut
    )
    val rectSizeMultiplier2 = transition.fractionTransition(
        initialValue = 1f,
        targetValue = 0f,
        durationMillis = durationPerFraction,
        offsetMillis = durationPerFraction / 4,
        delayMillis = durationMillis / 4,
        repeatMode = RepeatMode.Reverse,
        easing = EaseInOut
    )
    val rectSizeMultiplier3 = transition.fractionTransition(
        initialValue = 1f,
        targetValue = 0f,
        durationMillis = durationPerFraction,
        offsetMillis = durationPerFraction / 4 * 2,
        delayMillis = durationMillis / 4,
        repeatMode = RepeatMode.Reverse,
        easing = EaseInOut
    )
    val rectSizeMultiplier4 = transition.fractionTransition(
        initialValue = 1f,
        targetValue = 0f,
        durationMillis = durationPerFraction,
        offsetMillis = durationPerFraction / 4 * 3,
        delayMillis = durationMillis / 4,
        repeatMode = RepeatMode.Reverse,
        easing = EaseInOut
    )
    val rectSizeMultiplier5 = transition.fractionTransition(
        initialValue = 1f,
        targetValue = 0f,
        durationMillis = durationPerFraction,
        offsetMillis = durationPerFraction / 4 * 4,
        delayMillis = durationMillis / 4,
        repeatMode = RepeatMode.Reverse,
        easing = EaseInOut
    )

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Row {
            Box(modifier = Modifier.size(size / 3), contentAlignment = Alignment.Center) {
                Surface(
                    modifier = Modifier.size(size / 3 * rectSizeMultiplier3.value),
                    color = color
                ) {

                }
            }
            Box(modifier = Modifier.size(size / 3), contentAlignment = Alignment.Center) {
                Surface(
                    modifier = Modifier.size(size / 3 * rectSizeMultiplier4.value),
                    color = color
                ) {

                }
            }
            Box(modifier = Modifier.size(size / 3), contentAlignment = Alignment.Center) {
                Surface(
                    modifier = Modifier.size(size / 3 * rectSizeMultiplier5.value),
                    color = color
                ) {

                }
            }
        }
        Row {
            Box(modifier = Modifier.size(size / 3), contentAlignment = Alignment.Center) {
                Surface(
                    modifier = Modifier.size(size / 3 * rectSizeMultiplier2.value),
                    color = color
                ) {

                }
            }
            Box(modifier = Modifier.size(size / 3), contentAlignment = Alignment.Center) {
                Surface(
                    modifier = Modifier.size(size / 3 * rectSizeMultiplier3.value),
                    color = color
                ) {

                }
            }
            Box(modifier = Modifier.size(size / 3), contentAlignment = Alignment.Center) {
                Surface(
                    modifier = Modifier.size(size / 3 * rectSizeMultiplier4.value),
                    color = color
                ) {

                }
            }
        }
        Row {
            Box(modifier = Modifier.size(size / 3), contentAlignment = Alignment.Center) {
                Surface(
                    modifier = Modifier.size(size / 3 * rectSizeMultiplier1.value),
                    color = color
                ) {

                }
            }
            Box(modifier = Modifier.size(size / 3), contentAlignment = Alignment.Center) {
                Surface(
                    modifier = Modifier.size(size / 3 * rectSizeMultiplier2.value),
                    color = color
                ) {

                }
            }
            Box(modifier = Modifier.size(size / 3), contentAlignment = Alignment.Center) {
                Surface(
                    modifier = Modifier.size(size / 3 * rectSizeMultiplier3.value),
                    color = color
                ) {

                }
            }
        }
    }
//    Box(
//        modifier = modifier,
//        contentAlignment = Alignment.Center
//    ){
//        Canvas(modifier = Modifier.size(size)){
//            val width = this.size.width
//            val height = this.size.height
//
//            val rectSize = Size(
//                width = width / 3,
//                height = height / 3
//            )
//
//            val offsetRect = (center + Offset(- width / 2,  - height / 2))
//            drawRect(
//                color = color,
//                size = rectSize,
//                topLeft = offsetRect
//            )
//            drawRect(
//                color = color,
//                size = rectSize,
//                topLeft = offsetRect + Offset(rectSize.width, 0f)
//            )
//            drawRect(
//                color = color,
//                size = rectSize,
//                topLeft = offsetRect + Offset(rectSize.width * 2, 0f)
//            )
//            drawRect(
//                color = color,
//                size = rectSize,
//                topLeft = offsetRect + Offset(0f, rectSize.height)
//            )
//            drawRect(
//                color = color,
//                size = rectSize,
//                topLeft = offsetRect + Offset(rectSize.width, rectSize.height)
//            )
//            drawRect(
//                color = color,
//                size = rectSize,
//                topLeft = offsetRect + Offset(rectSize.width * 2, rectSize.height)
//            )
//            drawRect(
//                color = color,
//                size = rectSize,
//                topLeft = offsetRect + Offset(0f, rectSize.height * 2)
//            )
//            drawRect(
//                color = color,
//                size = rectSize,
//                topLeft = offsetRect + Offset(rectSize.width, rectSize.height * 2)
//            )
//            drawRect(
//                color = color,
//                size = rectSize,
//                topLeft = offsetRect + Offset(rectSize.width * 2, rectSize.height * 2)
//            )
//            drawLine(
//                color = color,
//                start = offsetRect + Offset(rectSize.width, 0f),
//                end = offsetRect + Offset(rectSize.width, rectSize.height * 3),
//                strokeWidth = rectSize.width / 10
//            )
//            drawLine(
//                color = color,
//                start = offsetRect + Offset(rectSize.width * 2, 0f),
//                end = offsetRect + Offset(rectSize.width * 2, rectSize.height * 3),
//                strokeWidth = rectSize.width / 10
//            )
//
//            drawLine(
//                color = color,
//                start = offsetRect + Offset( 0f, rectSize.height),
//                end = offsetRect + Offset(rectSize.width * 3, rectSize.height),
//                strokeWidth = rectSize.width / 10
//            )
//            drawLine(
//                color = color,
//                start = offsetRect + Offset( 0f, rectSize.height * 2),
//                end = offsetRect + Offset(rectSize.width * 3, rectSize.height * 2),
//                strokeWidth = rectSize.width / 10
//            )
//        }
//    }
}