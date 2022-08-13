package com.commandiron.compose_loading

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun Circle(
    modifier: Modifier = Modifier,
    size: Dp = 30.dp,
    durationMillis: Int = 1400,
    delayMillis: Int = 0,
    color: Color = MaterialTheme.colorScheme.surface,
    shape: Shape = CircleShape,
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ){
        Text(
            text = "Circle",
            style = MaterialTheme.typography.labelSmall,
            textAlign = TextAlign.Center
        )
    }
}