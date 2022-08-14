package com.commandiron.compose_loading

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import kotlinx.coroutines.delay

@Composable
fun LoadingDots(
    modifier: Modifier = Modifier,
    text: String? = null,
    style: TextStyle = LocalTextStyle.current,
    color: Color = LocalContentColor.current,
    dotCount: Int = 3,
    delayBetweenDots: Long = 500,
) {
    val dotText = remember { mutableStateOf("")}
    LaunchedEffect(key1 = Unit){
        while (true){
            for(i in 0 until dotCount){
                delay(delayBetweenDots)
                dotText.value += "."
            }
            delay(delayBetweenDots)
            dotText.value = ""
        }
    }
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if(text != null){
            Text(
                text = dotText.value,
                color = color.copy(alpha = 0f),
                style = style
            )
            Text(
                text = text,
                style = style,
                color = color
            )
            Text(
                text = dotText.value,
                style = style,
                color = color
            )
        }else{
            Text(
                text = dotText.value,
                style = style,
                color = color
            )
        }
    }
}