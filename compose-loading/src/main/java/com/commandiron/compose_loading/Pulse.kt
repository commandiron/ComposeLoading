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
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.commandiron.compose_loading.transition.fractionTransition

@Composable
fun Pulse(
    modifier: Modifier = Modifier,
    durationMillis: Int = 1000,
    delayMillis: Int = 0,
    size: DpSize = DpSize(40.dp, 40.dp),
    color: Color = MaterialTheme.colorScheme.primary,
    shape: Shape = CircleShape,
) {
    val transition = rememberInfiniteTransition()

    val sizeMultiplier = transition.fractionTransition(
        initialValue = 0f,
        targetValue = 1f,
        durationMillis = durationMillis,
        delayMillis = delayMillis
    )
    val alphaMultiplier = transition.fractionTransition(
        initialValue = 1f,
        targetValue = 0f,
        durationMillis = durationMillis,
        delayMillis = delayMillis
    )

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ){
        Surface(
            modifier = Modifier.size(size * sizeMultiplier.value),
            shape = shape,
            color = color.copy(alpha = alphaMultiplier.value)
        ) {}
    }
}