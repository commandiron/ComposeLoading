package com.commandiron.compose_loading

import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
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

    val sizeMultiplier by transition.fractionTransition(
        initialValue = 0f,
        targetValue = 1f,
        durationMillis = durationMillis
    )
    val alphaMultiplier by transition.fractionTransition(
        initialValue = 1f,
        targetValue = 0f,
        durationMillis = durationMillis
    )

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ){
        Surface(
            modifier = Modifier.size(maxSize * sizeMultiplier),
            shape = shape,
            color = color.copy(alpha = alphaMultiplier)
        ) {}
    }
}

@Composable
internal fun InfiniteTransition.fraction3Transition(
    initialValue: Float,
    targetValue: Float,
    durationMillis: Int,
    offsetMillis: Int = 0,
    easing: Easing = FastOutSlowInEasing
): State<Float> {
    return animateFloat(
        initialValue = initialValue,
        targetValue = targetValue,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                this.durationMillis = durationMillis
                initialValue at 0 with easing
                targetValue at durationMillis / 2 with easing
                initialValue at durationMillis with easing
            },
            RepeatMode.Restart,
            StartOffset(offsetMillis)
        )
    )
}