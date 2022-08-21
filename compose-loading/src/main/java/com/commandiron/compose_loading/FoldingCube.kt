package com.commandiron.compose_loading

import androidx.annotation.IntRange
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp

@Composable
fun FoldingCube(
    modifier: Modifier = Modifier,
    size: DpSize = DpSize(24.dp, 24.dp),
    durationMillisPerFraction: Int = 400,
    color: Color = MaterialTheme.colorScheme.primary
) {
    val transition = rememberInfiniteTransition()

    val rotationY1 = transition.foldingCubeTransition(
        initialValue = 0f,
        targetValue = 180f,
        durationMillisPerFraction = durationMillisPerFraction,
    )
    val rotationX1 = transition.foldingCubeTransition(
        initialValue = 0f,
        targetValue = -180f,
        offsetMillis = durationMillisPerFraction,
        durationMillisPerFraction = durationMillisPerFraction,
    )
    val rectAlpha1 = transition.foldingCubeTransition(
        initialValue = 1f,
        targetValue = 0f,
        durationMillisPerFraction = durationMillisPerFraction
    )

    val rotationX2 = transition.foldingCubeTransition(
        initialValue = 0f,
        targetValue = -180f,
        offsetMillis = durationMillisPerFraction,
        durationMillisPerFraction = durationMillisPerFraction,
    )
    val rotationY2 = transition.foldingCubeTransition(
        initialValue = 0f,
        targetValue = -180f,
        offsetMillis = durationMillisPerFraction * 2,
        durationMillisPerFraction = durationMillisPerFraction,
    )
    val rectAlpha2 = transition.foldingCubeTransition(
        initialValue = 1f,
        targetValue = 0f,
        offsetMillis = durationMillisPerFraction,
        durationMillisPerFraction = durationMillisPerFraction
    )

    val rotationY3 = transition.foldingCubeTransition(
        initialValue = 0f,
        targetValue = -180f,
        offsetMillis = durationMillisPerFraction * 2,
        durationMillisPerFraction = durationMillisPerFraction,
    )
    val rotationX3 = transition.foldingCubeTransition(
        initialValue = 0f,
        targetValue = 180f,
        offsetMillis = durationMillisPerFraction * 3,
        durationMillisPerFraction = durationMillisPerFraction,
    )
    val rectAlpha3 = transition.foldingCubeTransition(
        initialValue = 1f,
        targetValue = 0f,
        offsetMillis = durationMillisPerFraction * 2,
        durationMillisPerFraction = durationMillisPerFraction
    )

    val rotationX4 = transition.foldingCubeTransition(
        initialValue = 0f,
        targetValue = 180f,
        offsetMillis = durationMillisPerFraction * 3,
        durationMillisPerFraction = durationMillisPerFraction,
    )
    val rotationY4 = transition.foldingCubeTransition(
        initialValue = 0f,
        targetValue = 180f,
        offsetMillis = durationMillisPerFraction * 4,
        durationMillisPerFraction = durationMillisPerFraction,
    )

    Box(
        modifier = modifier.rotate(45f),
        contentAlignment = Alignment.Center
    ) {
        Box(modifier = Modifier.size(size)) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .graphicsLayer {
                        rotationY = rotationY1.value
                        rotationX = rotationX1.value
                    },
                contentAlignment = Alignment.TopStart
            ) {
                Surface(
                    modifier = Modifier.size(size / 2),
                    color = color.copy(alpha = rectAlpha1.value),
                ) {

                }

            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .graphicsLayer {
                        rotationY = rotationY2.value
                        rotationX = rotationX2.value
                    },
                contentAlignment = Alignment.TopEnd
            ) {
                Surface(
                    modifier = Modifier.size(size / 2),
                    color = color.copy(alpha = rectAlpha2.value),
                ) {

                }

            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .graphicsLayer {
                        rotationY = rotationY3.value
                        rotationX = rotationX3.value
                    },
                contentAlignment = Alignment.BottomEnd
            ) {
                Surface(
                    modifier = Modifier.size(size / 2),
                    color = color.copy(alpha = rectAlpha3.value),
                ) {

                }

            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .graphicsLayer {
                        rotationX = rotationX4.value
                        rotationY = rotationY4.value
                    },
                contentAlignment = Alignment.BottomStart
            ) {
                Surface(
                    modifier = Modifier.size(size / 2),
                    color = color,
                ) {

                }

            }
        }
    }
}

@Composable
internal fun InfiniteTransition.foldingCubeTransition(
    initialValue: Float,
    targetValue: Float,
    durationMillisPerFraction: Int,
    offsetMillis: Int = 0,
    repeatMode: RepeatMode = RepeatMode.Restart,
    easing: Easing = FastOutSlowInEasing
): State<Float> {
    return animateFloat(
        initialValue = initialValue,
        targetValue = targetValue,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                this.durationMillis = durationMillisPerFraction * 3
                this.delayMillis = durationMillisPerFraction * 4
                initialValue at 0 with easing
                targetValue at durationMillisPerFraction with easing
                targetValue at durationMillisPerFraction * 2 with easing
                initialValue at durationMillisPerFraction * 3 with easing
            },
            repeatMode,
            StartOffset(offsetMillis)
        )
    )
}
