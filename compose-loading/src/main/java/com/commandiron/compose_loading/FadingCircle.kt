package com.commandiron.compose_loading

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign

@Composable
fun FadingCircle(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ){
        Text(
            text = "Fading Circle",
            style = MaterialTheme.typography.labelSmall,
            textAlign = TextAlign.Center
        )
    }
}