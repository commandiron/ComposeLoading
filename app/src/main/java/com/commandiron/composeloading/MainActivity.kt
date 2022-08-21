package com.commandiron.composeloading

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.commandiron.compose_loading.*
import com.commandiron.composeloading.ui.theme.*
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLoadingTheme {
                ShowScreen()
            }
        }
    }
}

@Composable
fun ShowScreen() {
    val state = rememberPagerState()
    val scope = rememberCoroutineScope()
    ShowCase(
        modifier = Modifier.fillMaxSize(),
        state = state,
        onNext = {
            scope.launch {
                state.animateScrollToPage(state.currentPage + 1)
            }
        },
        onBack = {
            scope.launch {
                state.animateScrollToPage(state.currentPage - 1)
            }
        }
    ) {
        HorizontalPager(state = state, count = 16) {
            when(currentPage){
                0 -> { ShowGrid() }

                1 -> {
                    RotatingPlane(
                            modifier = Modifier
                                .background(BurntOrange)
                                .fillMaxSize(),
                            size = DpSize(60.dp, 60.dp
                        )
                    )
                }

                2 -> {
                    ChasingDots(
                        modifier = Modifier
                            .background(Charcoal)
                            .fillMaxSize(),
                        size = 60.dp
                    )
                }

                3 -> {
                    DoubleBounce(
                        modifier = Modifier
                            .background(MountainMeadow)
                            .fillMaxSize(),
                        size = DpSize(60.dp, 60.dp)
                    )
                }

                4 -> {
                    Wave(
                        modifier = Modifier
                            .background(StarCommandBlue)
                            .fillMaxSize(),
                        size = 60.dp
                    )
                }

                5 -> {
                    WanderingCubes(
                        modifier = Modifier
                            .background(BattleshipGrey)
                            .fillMaxSize(),
                        size = DpSize(60.dp, 60.dp)
                    )
                }

                6 -> {
                    Pulse(
                        modifier = Modifier
                            .background(MaximumYellowRed)
                            .fillMaxSize(),
                        size = DpSize(60.dp, 60.dp)
                    )
                }

                7 -> {
                    ChasingTwoDots(
                        modifier = Modifier
                            .background(BurntOrange)
                            .fillMaxSize(),
                        size = DpSize(60.dp, 60.dp)
                    )
                }

                8 -> {
                    ThreeBounce(
                        modifier = Modifier
                            .background(GOGreen)
                            .fillMaxSize(),
                        size = DpSize(60.dp, 60.dp)
                    )
                }

                9 -> {
                    Circle(
                        modifier = Modifier
                            .background(BurntOrange)
                            .fillMaxSize(),
                        size = 60.dp
                    )
                }

                10 -> {
                    CubeGrid(
                        modifier = Modifier
                            .background(Charcoal)
                            .fillMaxSize(),
                        size = DpSize(60.dp, 60.dp)
                    )
                }

                11 -> {
                    FadingCircle(
                        modifier = Modifier
                            .background(MountainMeadow)
                            .fillMaxSize(),
                        size = 60.dp
                    )
                }

                12 -> {
                    FoldingCube(
                        modifier = Modifier
                            .background(StarCommandBlue)
                            .fillMaxSize(),
                        size = DpSize(60.dp, 60.dp)
                    )
                }

                13 -> {
                    InstaSpinner(Modifier.background(BattleshipGrey).fillMaxSize())
                }

                14 -> {
                    LoadingBar(
                        modifier = Modifier
                            .background(MaximumYellowRed)
                            .fillMaxSize(),
                        fakeMillis = 10000,
                        fillColor = Bluetiful
                    )
                }

                15 -> {
                    LoadingDots(Modifier.background(GOGreen).fillMaxSize(),"Loading")
                }
            }
        }
    }
    BackHandler(enabled = state.currentPage != 0) {
        scope.launch {
            state.animateScrollToPage(state.currentPage - 1)
        }
    }
}
