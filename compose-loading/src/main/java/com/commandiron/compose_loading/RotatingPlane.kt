package com.commandiron.compose_loading

import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.commandiron.compose_loading.transition.fractionTransition

@Composable
fun RotatingPlane(
    modifier: Modifier = Modifier,
    size: DpSize = DpSize(30.dp, 30.dp),
    durationMillis: Int = 1200,
    delayMillis: Int = 0,
    color: Color = MaterialTheme.colorScheme.surface,
    shape: Shape = Shapes.None,
    contentOnPlane: @Composable BoxScope. () -> Unit = {}
) {
    val transition = rememberInfiniteTransition()

    val rotationYValue = transition.fractionTransition(
        initialValue = 0f,
        targetValue = 180f,
        durationMillis = durationMillis / 2,
        delayMillis = durationMillis / 2 + delayMillis,
        repeatMode = RepeatMode.Reverse
    )

    val rotationXValue = transition.fractionTransition(
        initialValue = 0f,
        targetValue = 180f,
        durationMillis = durationMillis / 2,
        delayMillis = durationMillis / 2 + delayMillis,
        offsetMillis = durationMillis / 2 + delayMillis,
        repeatMode = RepeatMode.Reverse
    )

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ){
        Surface(
            modifier = Modifier
                .size(size)
                .graphicsLayer {
                    rotationY = rotationYValue.value
                    rotationX = rotationXValue.value
                },
            color = color,
            shape = shape
        ) {
            contentOnPlane()
        }
    }
}