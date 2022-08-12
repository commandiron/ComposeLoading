package com.commandiron.compose_loading

import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun RotatingPlaneAnim(
    modifier: Modifier = Modifier,
    size: DpSize = DpSize(32.dp, 32.dp),
    color: Color = MaterialTheme.colorScheme.surface,
    shape: Shape = Shapes.None,
    durationMillis: Int = 600,
    content: @Composable BoxScope. () -> Unit = {}
) {
    val rotationYAnim = remember {
        Animatable(0f)
    }
    val rotationXAnim = remember {
        Animatable(0f)
    }
    LaunchedEffect(key1 = Unit){
        rotationYAnim.animateTo(
            targetValue = 180f,
            animationSpec = infiniteRepeatable(
                tween(
                    durationMillis = durationMillis,
                    delayMillis = durationMillis,
                    easing = LinearEasing
                ),
                RepeatMode.Restart
            )
        )
    }
    LaunchedEffect(key1 = Unit){
        delay(durationMillis.toLong())
        rotationXAnim.animateTo(
            targetValue = 180f,
            animationSpec = infiniteRepeatable(
                tween(
                    durationMillis = durationMillis,
                    delayMillis = durationMillis,
                    easing = LinearEasing
                ),
                RepeatMode.Restart
            )
        )
    }
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ){
        Surface(
            modifier = Modifier
                .size(size)
                .graphicsLayer {
                    rotationY = rotationYAnim.value
                    rotationX = rotationXAnim.value
                },
            color = color,
            shape = shape
        ) {
            content()
        }
    }
}