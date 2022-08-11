package com.commandiron.compose_loading

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlin.math.*

@Composable
fun CircleDotAnim(
    modifier: Modifier = Modifier,
    circleSize: Dp = 28.dp,
    color: Color = MaterialTheme.colorScheme.surface,
) {
    val circleAnim1 = remember {
        Animatable(0f)
    }
    var targetValue1 by remember { mutableStateOf(1.75f)}
    LaunchedEffect(key1 = Unit){
        delay(375)
        while (true){
            circleAnim1.animateTo(
                targetValue = targetValue1,
                animationSpec = tween(
                    durationMillis = 2750,
                    delayMillis = 0,
                    easing = FastOutSlowInEasing
                )
            )
            targetValue1 += 1.75f
        }
    }
    val circleAnim2 = remember {
        Animatable(0f)
    }
    var targetValue2 by remember { mutableStateOf(1.75f)}
    LaunchedEffect(key1 = Unit){
        delay(300)
        while (true){
            circleAnim2.animateTo(
                targetValue = targetValue2,
                animationSpec = tween(
                    durationMillis = 2750,
                    delayMillis = 0,
                    easing = FastOutSlowInEasing
                )
            )
            targetValue2 += 1.75f
        }
    }
    val circleAnim3 = remember {
        Animatable(0f)
    }
    var targetValue3 by remember { mutableStateOf(1.75f)}
    LaunchedEffect(key1 = Unit){
        delay(225)
        while (true){
            circleAnim3.animateTo(
                targetValue = targetValue3,
                animationSpec = tween(
                    durationMillis = 2750,
                    delayMillis = 0,
                    easing = FastOutSlowInEasing
                )
            )
            targetValue3 += 1.75f
        }
    }
    val circleAnim4 = remember {
        Animatable(0f)
    }
    var targetValue4 by remember { mutableStateOf(1.75f)}
    LaunchedEffect(key1 = Unit){
        delay(150)
        while (true){
            circleAnim4.animateTo(
                targetValue = targetValue4,
                animationSpec = tween(
                    durationMillis = 2750,
                    delayMillis = 0,
                    easing = FastOutSlowInEasing
                )
            )
            targetValue4 += 1.75f
        }
    }
    val circleAnim5 = remember {
        Animatable(0f)
    }
    var targetValue5 by remember { mutableStateOf(1.75f)}
    LaunchedEffect(key1 = Unit){
        delay(75)
        while (true){
            circleAnim5.animateTo(
                targetValue = targetValue5,
                animationSpec = tween(
                    durationMillis = 2750,
                    delayMillis = 0,
                    easing = FastOutSlowInEasing
                )
            )
            targetValue5 += 1.75f
        }
    }
    val circleAnim6 = remember {
        Animatable(0f)
    }
    var targetValue6 by remember { mutableStateOf(1.75f)}
    LaunchedEffect(key1 = Unit){
        while (true){
            circleAnim6.animateTo(
                targetValue = targetValue6,
                animationSpec = tween(
                    durationMillis = 2750,
                    delayMillis = 0,
                    easing = FastOutSlowInEasing
                )
            )
            targetValue6 += 1.75f
        }
    }

    Box(
        modifier = modifier.size(60.dp),
        contentAlignment = Alignment.Center
    ){
        Canvas(modifier = Modifier.size(circleSize)){

            val radius = (size.height / 2)

            val angleInDegrees1 = (circleAnim1.value * 360.0)
            val x1 = -(radius * sin(Math.toRadians(angleInDegrees1))).toFloat() + (size.width / 2)
            val y1 = (radius * cos(Math.toRadians(angleInDegrees1))).toFloat() + (size.height / 2)
            drawCircle(
                color = color,
                radius = 16f,
                center = Offset(x1,  y1)
            )
            val angleInDegrees2 = (circleAnim2.value * 360.0)
            val x2 = -(radius * sin(Math.toRadians(angleInDegrees2))).toFloat() + (size.width / 2)
            val y2 = (radius * cos(Math.toRadians(angleInDegrees2))).toFloat() + (size.height / 2)
            drawCircle(
                color = color,
                radius = 12f,
                center = Offset(x2,  y2)
            )
            val angleInDegrees3 = (circleAnim3.value * 360.0)
            val x3 = -(radius * sin(Math.toRadians(angleInDegrees3))).toFloat() + (size.width / 2)
            val y3 = (radius * cos(Math.toRadians(angleInDegrees3))).toFloat() + (size.height / 2)
            drawCircle(
                color = color,
                radius = 8f,
                center = Offset(x3,  y3)
            )
            val angleInDegrees4 = (circleAnim4.value * 360.0)
            val x4 = -(radius * sin(Math.toRadians(angleInDegrees4))).toFloat() + (size.width / 2)
            val y4 = (radius * cos(Math.toRadians(angleInDegrees4))).toFloat() + (size.height / 2)
            drawCircle(
                color = color,
                radius = 8f,
                center = Offset(x4,  y4)
            )
            val angleInDegrees5 = (circleAnim5.value * 360.0)
            val x5 = -(radius * sin(Math.toRadians(angleInDegrees5))).toFloat() + (size.width / 2)
            val y5 = (radius * cos(Math.toRadians(angleInDegrees5))).toFloat() + (size.height / 2)
            drawCircle(
                color = color,
                radius = 8f,
                center = Offset(x5,  y5)
            )
            val angleInDegrees6 = (circleAnim6.value * 360.0)
            val x6 = -(radius * sin(Math.toRadians(angleInDegrees6))).toFloat() + (size.width / 2)
            val y6 = (radius * cos(Math.toRadians(angleInDegrees6))).toFloat() + (size.height / 2)
            drawCircle(
                color = color,
                radius = 8f,
                center = Offset(x6,  y6)
            )
        }
    }
}