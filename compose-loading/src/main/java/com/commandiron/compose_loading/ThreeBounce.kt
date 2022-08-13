package com.commandiron.compose_loading

import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun ThreeBounce(
    modifier: Modifier = Modifier,
    size: Dp = 30.dp,
    color: Color = MaterialTheme.colorScheme.surface,
    shape: Shape = CircleShape,
    durationMillis: Int = 1400,
    delayBetweenDots: Int = 160
) {
    val transition = rememberInfiniteTransition()

    val sizeMultiplier1 by transition.fraction3Transition(
        initialValue = 0f,
        targetValue = 1f,
        durationMillis = durationMillis,
    )
    val sizeMultiplier2 by transition.fraction3Transition(
        initialValue = 0f,
        targetValue = 1f,
        durationMillis = durationMillis,
        offsetMillis = delayBetweenDots
    )
    val sizeMultiplier3 by transition.fraction3Transition(
        initialValue = 0f,
        targetValue = 1f,
        durationMillis = durationMillis,
        offsetMillis = delayBetweenDots * 2
    )

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ){
        Row() {
            Box(modifier = Modifier.size(size / 3), contentAlignment = Alignment.Center) {
                Surface(
                    modifier = Modifier.size(size / 3 * sizeMultiplier1),
                    shape = shape,
                    color = color
                ) {}
            }
            Spacer(modifier = Modifier.width(size / 3 / 4))
            Box(modifier = Modifier.size(size / 3), contentAlignment = Alignment.Center) {
                Surface(
                    modifier = Modifier.size(size / 3 * sizeMultiplier2),
                    shape = shape,
                    color = color
                ) {}
            }
            Spacer(modifier = Modifier.width(size / 3 / 4))
            Box(modifier = Modifier.size(size / 3), contentAlignment = Alignment.Center) {
                Surface(
                    modifier = Modifier.size(size / 3 * sizeMultiplier3),
                    shape = shape,
                    color = color
                ) {}
            }
        }
    }
}