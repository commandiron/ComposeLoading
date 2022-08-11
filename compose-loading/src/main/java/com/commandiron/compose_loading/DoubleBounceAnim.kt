package com.commandiron.compose_loading

import androidx.compose.animation.core.*
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun DoubleBounceAnim(
    modifier: Modifier = Modifier,
    maxSize: Dp = 32.dp,
    color: Color = MaterialTheme.colorScheme.surface,
    shape: Shape = CircleShape,
    delayMillis: Int = 500,
) {
    val surface1SizeAnim = remember {
        Animatable(maxSize.value / 2)
    }
    val surface2SizeAnim = remember {
        Animatable(0f)
    }
    LaunchedEffect(key1 = Unit){
        surface1SizeAnim.animateTo(
            targetValue = maxSize.value,
            animationSpec = infiniteRepeatable(
                tween(
                    durationMillis = delayMillis,
                    delayMillis = 0,
                    easing = FastOutSlowInEasing
                ),
                RepeatMode.Reverse
            )
        )
    }
    LaunchedEffect(key1 = Unit){
        delay(delayMillis.toLong())
        surface2SizeAnim.animateTo(
            targetValue = maxSize.value / 2,
            animationSpec = infiniteRepeatable(
                tween(
                    durationMillis = delayMillis,
                    delayMillis = 0,
                    easing = FastOutSlowInEasing
                ),
                RepeatMode.Reverse
            )
        )
    }
    Box(
        modifier = modifier.size(60.dp),
        contentAlignment = Alignment.Center
    ){
        Surface(
            modifier = Modifier.size(Dp(surface1SizeAnim.value)),
            shape = shape,
            color = color.copy(alpha = 0.5f)
        ) {}
        Surface(
            modifier = Modifier.size(Dp(surface2SizeAnim.value)),
            shape = shape,
            color = color
        ) {}
    }
}