package com.commandiron.compose_loading

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun LoadingBar(
    modifier: Modifier = Modifier,
    progress: Float = 0.3f,
    fakeDurationMillis: Int = 10000,
    thickness: Dp = 16.dp,
    width: Dp = 200.dp,
    backgroundColor: Color = MaterialTheme.colorScheme.background,
    fillColor: Color = MaterialTheme.colorScheme.surface,
    borderColor: Color = Color.Black
) {
    val loadingBarProgress = remember {
        Animatable(0f)
    }
    var canvasWidth by remember { mutableStateOf(0f)}
    LaunchedEffect(key1 = Unit){
        if(fakeDurationMillis != 0){
            loadingBarProgress.animateTo(
                targetValue = canvasWidth,
                animationSpec = tween(
                    durationMillis = fakeDurationMillis,
                    easing = LinearEasing
                )
            )
        }else{
            val progressCalc = progress * canvasWidth
            loadingBarProgress.animateTo(
                targetValue = progressCalc,
                animationSpec = tween(
                    durationMillis = 0,
                    easing = LinearEasing
                )
            )
        }
    }
    Surface(
        modifier = modifier
            .height(thickness)
            .width(width),
        color = backgroundColor,
        shape = RoundedCornerShape(thickness),
        border = BorderStroke(thickness / 10, borderColor)
    ) {
        Canvas(
            modifier = Modifier.fillMaxSize(),
            onDraw = {
                canvasWidth = size.width
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
