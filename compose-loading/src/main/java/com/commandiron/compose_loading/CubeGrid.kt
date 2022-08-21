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
    size: DpSize = DpSize(40.dp, 40.dp),
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
}