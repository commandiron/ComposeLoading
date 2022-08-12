package com.commandiron.composeloading

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.commandiron.compose_loading.*
import com.commandiron.composeloading.ui.theme.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

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
                        RotatingPlaneAnim(
                            modifier = Modifier
                                .size(60.dp)
                                .background(BurntOrange),
                            color = Color.White
                        )
                        CircleDotAnim(
                            modifier = Modifier
                                .size(60.dp)
                                .background(Charcoal),
                            color = Color.White,
                        )
                        DoubleBounceAnim(
                            modifier = Modifier
                                .size(60.dp)
                                .background(MountainMeadow),
                            color = Color.White
                        )
                        WaveAnim(
                            modifier = Modifier
                                .size(60.dp)
                                .background(StarCommandBlue),
                            color = Color.White
                        )
                    }
                    Row {
                        WanderingCubesAnim(
                            modifier = Modifier
                                .size(60.dp)
                                .background(BattleshipGrey),
                            color = Color.White
                        )
                        Pulse(
                            modifier = Modifier
                                .size(60.dp)
                                .background(MaximumYellowRed)
                        )
                        ChasingDots(
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
                    Spacer(modifier = Modifier.height(16.dp))
                    LoadingBar(fillColor = Bluetiful)
                    Spacer(modifier = Modifier.height(8.dp))
                    LoadingDotText("Loading")
                }
            }
        }
    }
}
