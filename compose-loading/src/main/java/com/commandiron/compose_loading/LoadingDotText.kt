package com.commandiron.compose_loading

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import kotlinx.coroutines.delay

@Composable
fun LoadingDotText(
    text: String? = null,
    style: TextStyle = LocalTextStyle.current,
    dotCount: Int = 3,
    delayBetweenDots: Long = 500,
) {
    var dotText by remember { mutableStateOf("")}
    LaunchedEffect(key1 = Unit){
        while (true){
            for(i in 0 until dotCount){
                delay(delayBetweenDots)
                dotText += "."
            }
            delay(delayBetweenDots)
            dotText = ""
        }
    }
    Row {
        if(text != null){
            Text(
                modifier = Modifier.alignByBaseline(),
                text = dotText,
                color = LocalContentColor.current.copy(alpha = 0f),
                style = style
            )
            Text(
                text = text,
                style = style
            )
            Text(
                modifier = Modifier.alignByBaseline(),
                text = dotText,
                style = style
            )
        }else{
            Text(text = dotText)
        }
    }
}