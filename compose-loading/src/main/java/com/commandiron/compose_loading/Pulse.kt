package com.commandiron.compose_loading

import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.commandiron.compose_loading.transition.fractionTransition

@Composable
fun Pulse(
    modifier: Modifier = Modifier,
    maxSize: Dp = 30.dp,
    color: Color = MaterialTheme.colorScheme.surface,
    shape: Shape = CircleShape,
    durationMillis: Int = 1000
) {
    val transition = rememberInfiniteTransition()

    val sizeMultiplier = transition.fractionTransition(
        initialValue = 0f,
        targetValue = 1f,
        durationMillis = durationMillis
    )
    val alphaMultiplier = transition.fractionTransition(
        initialValue = 1f,
        targetValue = 0f,
        durationMillis = durationMillis
    )

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ){
        Surface(
            modifier = Modifier.size(maxSize * sizeMultiplier.value),
            shape = shape,
            color = color.copy(alpha = alphaMultiplier.value)
        ) {}
    }
}