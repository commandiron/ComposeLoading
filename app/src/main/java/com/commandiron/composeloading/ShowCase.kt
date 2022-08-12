package com.commandiron.composeloading

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ShowCase(
    modifier: Modifier = Modifier,
    state: PagerState,
    onNext: () -> Unit,
    onBack: () -> Unit,
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        content()
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            if(state.currentPage != 0){
                IconButton(
                    onClick = onBack
                ) {
                    Icon(
                        modifier = Modifier.size(64.dp),
                        imageVector = Icons.Default.KeyboardArrowLeft,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onSurface
                    )
                }
            }else{
                Spacer(modifier = Modifier.width(0.dp))
            }
            if(state.currentPage != state.pageCount - 1){
                IconButton(
                    onClick = onNext
                ) {
                    Icon(
                        modifier = Modifier.size(64.dp),
                        imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onSurface
                    )
                }
            }
        }
    }
}