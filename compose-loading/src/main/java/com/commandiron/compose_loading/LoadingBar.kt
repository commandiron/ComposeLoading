package com.commandiron.compose_loading

import androidx.annotation.FloatRange
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun LoadingBar(
    modifier: Modifier = Modifier,
    @FloatRange(from = 0.0, to = 1.0) progress: Float = 0.0f,
    fakeMillis: Int = 0,
    width: Dp = 200.dp,
    backgroundColor: Color = MaterialTheme.colorScheme.background,
    fillColor: Color = MaterialTheme.colorScheme.primary,
    borderColor: Color = MaterialTheme.colorScheme.onBackground
) {
    val loadingBarProgress = remember {
        Animatable(0f)
    }
    val canvasWidth = remember { mutableStateOf(0f)}
    LaunchedEffect(key1 = Unit){
        if(fakeMillis != 0){
            loadingBarProgress.animateTo(
                targetValue = canvasWidth.value,
                animationSpec = tween(
                    durationMillis = fakeMillis,
                    easing = LinearEasing
                )
            )
        }else{
            val progressCalc = progress * canvasWidth.value
            loadingBarProgress.animateTo(
                targetValue = progressCalc,
                animationSpec = tween(
                    durationMillis = 0,
                    easing = LinearEasing
                )
            )
        }
    }
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Surface(
            modifier = Modifier
                .height(width / 12)
                .width(width),
            color = backgroundColor,
            shape = RoundedCornerShape(width / 12),
            border = BorderStroke(width / 120, borderColor)
        ) {
            Canvas(
                modifier = Modifier.fillMaxSize(),
                onDraw = {
                    canvasWidth.value = size.width
                    val canvasHeight = size.height
                    drawRect(
                        color = fillColor,
                        topLeft = Offset(0f, 0f),
                        size = Size(loadingBarProgress.value, canvasHeight)
                    )
                }
            )
        }
    }
}
