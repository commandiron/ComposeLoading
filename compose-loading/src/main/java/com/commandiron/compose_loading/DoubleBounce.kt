package com.commandiron.compose_loading

import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp

@Composable
fun DoubleBounce(
    modifier: Modifier = Modifier,
    size: DpSize = DpSize(30.dp, 30.dp),
    durationMillis: Int = 1000,
    color: Color = MaterialTheme.colorScheme.surface,
    shape: Shape = CircleShape
) {
    val transition = rememberInfiniteTransition()

    val sizeMultiplier1 by transition.fraction3Transition(
        durationMillis = durationMillis,
        repeatMode = RepeatMode.Reverse
    )

    val sizeMultiplier2 by transition.fraction3Transition2(
        durationMillis = durationMillis,
        repeatMode = RepeatMode.Reverse
    )
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ){
        Surface(
            modifier = Modifier.size(size * sizeMultiplier1),
            shape = shape,
            color = color.copy(alpha = 0.5f)
        ) {}
        Surface(
            modifier = Modifier.size(size * sizeMultiplier2),
            shape = shape,
            color = color
        ) {}
    }
}

@Composable
internal fun InfiniteTransition.fraction3Transition(
    durationMillis: Int,
    offsetMillis: Int = 0,
    repeatMode: RepeatMode = RepeatMode.Restart,
    easing: Easing = FastOutSlowInEasing
): State<Float> {
    return animateFloat(
        initialValue = 0.5f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                this.durationMillis = durationMillis
                0.5f at 0 with easing
                1f at durationMillis with easing
                0.5f at durationMillis * 2 with easing
            },
            repeatMode,
            StartOffset(offsetMillis)
        )
    )
}

@Composable
internal fun InfiniteTransition.fraction3Transition2(
    durationMillis: Int,
    offsetMillis: Int = 0,
    repeatMode: RepeatMode = RepeatMode.Restart,
    easing: Easing = FastOutSlowInEasing
): State<Float> {
    return animateFloat(
        initialValue = 0f,
        targetValue = 0.5f,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                this.durationMillis = durationMillis
                0.5f at 0 with easing
                0f at durationMillis with easing
                0.5f at durationMillis * 2 with easing
            },
            repeatMode,
            StartOffset(offsetMillis)
        )
    )
}