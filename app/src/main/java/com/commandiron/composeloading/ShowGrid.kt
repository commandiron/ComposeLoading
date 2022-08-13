package com.commandiron.composeloading

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.commandiron.compose_loading.*
import com.commandiron.composeloading.ui.theme.*

@Composable
fun ShowGrid(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            RotatingPlane(
                modifier = Modifier
                    .size(60.dp)
                    .background(BurntOrange)
            )
            ChasingDots(
                modifier = Modifier
                    .size(60.dp)
                    .background(Charcoal)
            )
            DoubleBounce(
                modifier = Modifier
                    .size(60.dp)
                    .background(MountainMeadow)
            )
            Wave(
                modifier = Modifier
                    .size(60.dp)
                    .background(StarCommandBlue)
            )
        }
        Row {
            WanderingCubes(
                modifier = Modifier
                    .size(60.dp)
                    .background(BattleshipGrey)
            )
            Pulse(
                modifier = Modifier
                    .size(60.dp)
                    .background(MaximumYellowRed)
            )
            ChasingTwoDots(
                modifier = Modifier
                    .size(60.dp)
                    .background(BurntOrange)
            )
            ThreeBounce(
                modifier = Modifier
                    .size(60.dp)
                    .background(GOGreen)
            )
        }
        Row {
            Circle(
                modifier = Modifier
                    .size(60.dp)
                    .background(BurntOrange)
            )
            CubeGrid(
                modifier = Modifier
                    .size(60.dp)
                    .background(Charcoal)
            )
            FadingCircle(
                modifier = Modifier
                    .size(60.dp)
                    .background(MountainMeadow)
            )
            FoldingCube(
                modifier = Modifier
                    .size(60.dp)
                    .background(StarCommandBlue)
            )
        }
    }
}