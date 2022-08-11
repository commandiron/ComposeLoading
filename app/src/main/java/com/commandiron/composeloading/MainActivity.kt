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
                        RotatingPlaneAnim(
                            modifier = Modifier.background(BurntOrange),
                            color = Color.White
                        )
                        CircleDotAnim(
                            modifier = Modifier.background(Charcoal),
                            color = Color.White,
                        )
                        DoubleBounceAnim(
                            modifier = Modifier.background(MountainMeadow),
                            color = Color.White
                        )
                        WaveAnim(
                            modifier = Modifier.background(StarCommandBlue),
                            color = Color.White
                        )
                    }
                    Row {
                        WanderingCubesAnim(
                            modifier = Modifier.background(BattleshipGrey),
                        )
                        WaveAnim(
                            modifier = Modifier.background(StarCommandBlue),
                            color = Color.White
                        )
                        CircleDotAnim(
                            modifier = Modifier.background(Charcoal),
                            color = Color.White,
                        )
                        DoubleBounceAnim(
                            modifier = Modifier.background(MountainMeadow),
                            color = Color.White
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
