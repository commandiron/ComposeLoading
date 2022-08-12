package com.commandiron.composeloading

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.commandiron.compose_loading.*
import com.commandiron.composeloading.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLoadingTheme {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row {
                        RotatingPlane(
                            modifier = Modifier
                                .size(60.dp)
                                .background(BurntOrange),
                            color = Color.White
                        )
                        ChasingDots(
                            modifier = Modifier
                                .size(60.dp)
                                .background(Charcoal),
                            color = Color.White,
                        )
                        DoubleBounce(
                            modifier = Modifier
                                .size(60.dp)
                                .background(MountainMeadow),
                            color = Color.White
                        )
                        Wave(
                            modifier = Modifier
                                .size(60.dp)
                                .background(StarCommandBlue),
                            color = Color.White
                        )
                    }
                    Row {
                        WanderingCubes(
                            modifier = Modifier
                                .size(60.dp)
                                .background(BattleshipGrey),
                            color = Color.White
                        )
                        Pulse(
                            modifier = Modifier
                                .size(60.dp)
                                .background(MaximumYellowRed),
                            color = Color.White
                        )
                        ChasingTwoDots(
                            modifier = Modifier
                                .size(60.dp)
                                .background(BurntOrange),
                            color = Color.White
                        )
                        ThreeBounce(
                            modifier = Modifier
                                .size(60.dp)
                                .background(GOGreen),
                            color = Color.White
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
                    Spacer(modifier = Modifier.height(16.dp))
                    LoadingBar(fillColor = Bluetiful)
                    Spacer(modifier = Modifier.height(8.dp))
                    LoadingDotText("Loading")
                }
            }
        }
    }
}
