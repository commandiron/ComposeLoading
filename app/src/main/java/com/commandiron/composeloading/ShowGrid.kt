package com.commandiron.composeloading

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
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
            RotatingPlane(
                modifier = Modifier
                    .size(gridSize)
                    .background(BurntOrange)
            )
            ChasingDots(
                modifier = Modifier
                    .size(gridSize)
                    .background(Charcoal)
            )
            DoubleBounce(
                modifier = Modifier
                    .size(gridSize)
                    .background(MountainMeadow)
            )
            Wave(
                modifier = Modifier
                    .size(gridSize)
                    .background(StarCommandBlue)
            )
        }
        Row {
            WanderingCubes(
                modifier = Modifier
                    .size(gridSize)
                    .background(BattleshipGrey)
            )
            Pulse(
                modifier = Modifier
                    .size(gridSize)
                    .background(MaximumYellowRed)
            )
            ChasingTwoDots(
                modifier = Modifier
                    .size(gridSize)
                    .background(BurntOrange)
            )
            ThreeBounce(
                modifier = Modifier
                    .size(gridSize)
                    .background(GOGreen)
            )
        }
        Row {
            Circle(
                modifier = Modifier
                    .size(gridSize)
                    .background(BurntOrange)
            )
            CubeGrid(
                modifier = Modifier
                    .size(gridSize)
                    .background(Charcoal)
            )
            FadingCircle(
                modifier = Modifier
                    .size(gridSize)
                    .background(MountainMeadow)
            )
            FoldingCube(
                modifier = Modifier
                    .size(gridSize)
                    .background(StarCommandBlue)
            )
        }
        Row {
            InstaSpinner(
                modifier = Modifier
                    .size(gridSize)
                    .background(BattleshipGrey)
            )
            LoadingBar(
                modifier = Modifier
                    .size(gridSize * 2, gridSize)
                    .background(MaximumYellowRed),
                width = gridSize,
                fakeMillis = 10000,
                fillColor = Bluetiful
            )
            LoadingDots(
                modifier = Modifier
                    .size(gridSize)
                    .background(GOGreen),
                style = MaterialTheme.typography.titleLarge
            )
        }
    }
}