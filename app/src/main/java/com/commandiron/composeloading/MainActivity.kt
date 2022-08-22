package com.commandiron.composeloading

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(BurntOrange),
                        contentAlignment = Alignment.Center
                    ) {
                        RotatingPlane()
                    }
                }

                2 -> {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Charcoal),
                        contentAlignment = Alignment.Center
                    ) {
                        ChasingDots()
                    }
                }

                3 -> {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(MountainMeadow),
                        contentAlignment = Alignment.Center
                    ) {
                        DoubleBounce()
                    }
                }

                4 -> {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(StarCommandBlue),
                        contentAlignment = Alignment.Center
                    ) {
                        Wave()
                    }
                }

                5 -> {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(BattleshipGrey),
                        contentAlignment = Alignment.Center
                    ) {
                        WanderingCubes()
                    }
                }

                6 -> {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(MaximumYellowRed),
                        contentAlignment = Alignment.Center
                    ) {
                        Pulse()
                    }
                }

                7 -> {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(BurntOrange),
                        contentAlignment = Alignment.Center
                    ) {
                        ChasingTwoDots()
                    }
                }

                8 -> {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(GOGreen),
                        contentAlignment = Alignment.Center
                    ) {
                        ThreeBounce()
                    }
                }

                9 -> {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(BurntOrange),
                        contentAlignment = Alignment.Center
                    ) {
                        Circle()
                    }
                }

                10 -> {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Charcoal),
                        contentAlignment = Alignment.Center
                    ) {
                        CubeGrid()
                    }
                }

                11 -> {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(MountainMeadow),
                        contentAlignment = Alignment.Center
                    ) {
                        FadingCircle()
                    }
                }

                12 -> {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(StarCommandBlue),
                        contentAlignment = Alignment.Center
                    ) {
                        FoldingCube()
                    }
                }

                13 -> {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(BattleshipGrey),
                        contentAlignment = Alignment.Center
                    ) {
                        InstaSpinner()
                    }
                }

                14 -> {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(MaximumYellowRed),
                        contentAlignment = Alignment.Center
                    ) {
                        LoadingBar(fakeMillis = 10000, fillColor = Bluetiful)
                    }
                }

                15 -> {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(GOGreen),
                        contentAlignment = Alignment.Center
                    ) {
                        LoadingDots(text = "Loading")
                    }
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
