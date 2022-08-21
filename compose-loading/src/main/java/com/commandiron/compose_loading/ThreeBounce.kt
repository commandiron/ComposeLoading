package com.commandiron.compose_loading

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.layout.*
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
fun ThreeBounce(
    modifier: Modifier = Modifier,
    durationMillis: Int = 1400,
    delayBetweenDotsMillis: Int = 160,
    size: DpSize = DpSize(40.dp, 40.dp),
    color: Color = MaterialTheme.colorScheme.primary,
    shape: Shape = CircleShape
) {
    val transition = rememberInfiniteTransition()

    val sizeMultiplier1 = transition.fractionTransition(
        initialValue = 0f,
        targetValue = 1f,
        fraction = 1,
        durationMillis = durationMillis / 2,
        repeatMode = RepeatMode.Reverse
    )
    val sizeMultiplier2 = transition.fractionTransition(
        initialValue = 0f,
        targetValue = 1f,
        fraction = 1,
        durationMillis = durationMillis / 2,
        offsetMillis = delayBetweenDotsMillis,
        repeatMode = RepeatMode.Reverse
    )
    val sizeMultiplier3 = transition.fractionTransition(
        initialValue = 0f,
        targetValue = 1f,
        fraction = 1,
        durationMillis = durationMillis / 2,
        offsetMillis = delayBetweenDotsMillis * 2,
        repeatMode = RepeatMode.Reverse
    )

    Row(
        modifier = modifier.size(size),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(modifier = Modifier.size(size * 3 / 11), contentAlignment = Alignment.Center) {
            Surface(
                modifier = Modifier.size(size * 3 / 11 * sizeMultiplier1.value),
                shape = shape,
                color = color
            ) {}
        }
        Spacer(modifier = Modifier.width(size.width / 1 / 11))
        Box(modifier = Modifier.size(size * 3 / 11), contentAlignment = Alignment.Center) {
            Surface(
                modifier = Modifier.size(size * 3 / 11 * sizeMultiplier2.value),
                shape = shape,
                color = color
            ) {}
        }
        Spacer(modifier = Modifier.width(size.width / 1 / 11))
        Box(modifier = Modifier.size(size * 3 / 11), contentAlignment = Alignment.Center) {
            Surface(
                modifier = Modifier.size(size * 3 / 11 * sizeMultiplier3.value),
                shape = shape,
                color = color
            ) {}
        }
    }
}