package com.commandiron.compose_loading

import androidx.compose.animation.core.*
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun WaveAnim(
    modifier: Modifier = Modifier,
    size: Dp = 4.dp,
    color: Color = MaterialTheme.colorScheme.surface,
    delayMillis: Int = 250,
) {
    val aspectRatioAnim1 = remember {
        Animatable(0.25f)
    }
    val aspectRatioAnim2 = remember {
        Animatable(0.25f)
    }
    val aspectRatioAnim3 = remember {
        Animatable(0.25f)
    }
    val aspectRatioAnim4 = remember {
        Animatable(0.25f)
    }
    val aspectRatioAnim5 = remember {
        Animatable(0.25f)
    }
    LaunchedEffect(key1 = Unit){
        aspectRatioAnim1.animateTo(
            targetValue = 0.10f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = delayMillis,
                    delayMillis = delayMillis * 2,
                    easing = FastOutSlowInEasing
                ),
                repeatMode = RepeatMode.Reverse
            )
        )
    }
    LaunchedEffect(key1 = Unit){
        delay(delayMillis.toLong() / 3)
        aspectRatioAnim2.animateTo(
            targetValue = 0.10f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = delayMillis,
                    delayMillis = delayMillis * 2,
                    easing = FastOutSlowInEasing
                ),
                repeatMode = RepeatMode.Reverse
            )
        )
    }
    LaunchedEffect(key1 = Unit){
        delay(delayMillis.toLong() / 3 + delayMillis.toLong() / 3)
        aspectRatioAnim3.animateTo(
            targetValue = 0.10f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = delayMillis,
                    delayMillis = delayMillis * 2,
                    easing = FastOutSlowInEasing
                ),
                repeatMode = RepeatMode.Reverse
            )
        )
    }
    LaunchedEffect(key1 = Unit){
        delay(delayMillis.toLong())
        aspectRatioAnim4.animateTo(
            targetValue = 0.10f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = delayMillis,
                    delayMillis = delayMillis * 2,
                    easing = FastOutSlowInEasing
                ),
                repeatMode = RepeatMode.Reverse
            )
        )
    }
    LaunchedEffect(key1 = Unit){
        delay(delayMillis.toLong() + delayMillis.toLong() / 3)
        aspectRatioAnim5.animateTo(
            targetValue = 0.10f,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = delayMillis,
                    delayMillis = delayMillis * 2,
                    easing = FastOutSlowInEasing
                ),
                repeatMode = RepeatMode.Reverse
            )
        )
    }
    Row(
        modifier = modifier.size(60.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Surface(
            modifier = Modifier
                .size(size)
                .aspectRatio(aspectRatioAnim1.value),
            color = color
        ) {}
        Spacer(modifier = Modifier.width(size / 3))
        Surface(
            modifier = Modifier
                .size(size)
                .aspectRatio(aspectRatioAnim2.value),
            color = color
        ) {}
        Spacer(modifier = Modifier.width(size / 3))
        Surface(
            modifier = Modifier
                .size(size)
                .aspectRatio(aspectRatioAnim3.value),
            color = color
        ) {}
        Spacer(modifier = Modifier.width(size / 3))
        Surface(
            modifier = Modifier
                .size(size)
                .aspectRatio(aspectRatioAnim4.value),
            color = color
        ) {}
        Spacer(modifier = Modifier.width(size / 3))
        Surface(
            modifier = Modifier
                .size(size)
                .aspectRatio(aspectRatioAnim5.value),
            color = color
        ) {}
    }
}