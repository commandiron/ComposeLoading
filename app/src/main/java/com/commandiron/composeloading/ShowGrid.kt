package com.commandiron.composeloading

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.commandiron.compose_loading.*
import com.commandiron.composeloading.ui.theme.*

@Composable
fun ShowGrid(
    modifier: Modifier = Modifier,
    gridSize: Dp = 60.dp
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            Box(
                modifier = Modifier
                    .size(gridSize)
                    .background(BurntOrange),
                contentAlignment = Alignment.Center
            ) {
                RotatingPlane(size = DpSize(gridSize / 2, gridSize / 2))
            }
            Box(
                modifier = Modifier
                    .size(gridSize)
                    .background(Charcoal),
                contentAlignment = Alignment.Center
            ) {
                ChasingDots(size = gridSize / 2)
            }
            Box(
                modifier = Modifier
                    .size(gridSize)
                    .background(MountainMeadow),
                contentAlignment = Alignment.Center
            ) {
                DoubleBounce(size = DpSize(gridSize / 2, gridSize / 2))
            }
            Box(
                modifier = Modifier
                    .size(gridSize)
                    .background(StarCommandBlue),
                contentAlignment = Alignment.Center
            ) {
                Wave(size = gridSize / 2)
            }
        }
        Row {
            Box(
                modifier = Modifier
                    .size(gridSize)
                    .background(BattleshipGrey),
                contentAlignment = Alignment.Center
            ) {
                WanderingCubes(size = DpSize(gridSize / 2, gridSize / 2))
            }
            Box(
                modifier = Modifier
                    .size(gridSize)
                    .background(MaximumYellowRed),
                contentAlignment = Alignment.Center
            ) {
                Pulse(size = DpSize(gridSize / 2, gridSize / 2))
            }
            Box(
                modifier = Modifier
                    .size(gridSize)
                    .background(BurntOrange),
                contentAlignment = Alignment.Center
            ) {
                ChasingTwoDots(size = DpSize(gridSize / 2, gridSize / 2))
            }
            Box(
                modifier = Modifier
                    .size(gridSize)
                    .background(GOGreen),
                contentAlignment = Alignment.Center
            ) {
                ThreeBounce(size = DpSize(gridSize / 2, gridSize / 2))
            }
        }
        Row {
            Box(
                modifier = Modifier
                    .size(gridSize)
                    .background(BurntOrange),
                contentAlignment = Alignment.Center
            ) {
                Circle(size = gridSize / 2)
            }
            Box(
                modifier = Modifier
                    .size(gridSize)
                    .background(Charcoal),
                contentAlignment = Alignment.Center
            ) {
                CubeGrid(size = DpSize(gridSize / 2, gridSize / 2))
            }
            Box(
                modifier = Modifier
                    .size(gridSize)
                    .background(MountainMeadow),
                contentAlignment = Alignment.Center
            ) {
                FadingCircle(size = gridSize / 2)
            }
            Box(
                modifier = Modifier
                    .size(gridSize)
                    .background(StarCommandBlue),
                contentAlignment = Alignment.Center
            ) {
                FoldingCube(size = DpSize(gridSize / 2, gridSize / 2))
            }
        }
        Row {
            Box(
                modifier = Modifier
                    .size(gridSize)
                    .background(BattleshipGrey),
                contentAlignment = Alignment.Center
            ) {
                InstaSpinner()
            }
            Box(
                modifier = Modifier
                    .size(gridSize * 2, gridSize)
                    .background(MaximumYellowRed),
                contentAlignment = Alignment.Center
            ) {
                LoadingBar(width = gridSize, fakeMillis = 10000, fillColor = Bluetiful)
            }
            Box(
                modifier = Modifier
                    .size(gridSize)
                    .background(GOGreen),
                contentAlignment = Alignment.Center
            ) {
                LoadingDots()
            }
        }
    }
}