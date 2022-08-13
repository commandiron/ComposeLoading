package com.commandiron.composeloading

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.commandiron.compose_loading.*
import com.commandiron.composeloading.ui.theme.*
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
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
        HorizontalPager(state = state, count = 15) {
            when(currentPage){
                0 -> { ShowGrid() }

                1 -> { RotatingPlane(Modifier.background(BurntOrange).fillMaxSize()) }

                2 -> { ChasingDots(Modifier.background(Charcoal).fillMaxSize()) }

                3 -> { DoubleBounce(Modifier.background(MountainMeadow).fillMaxSize()) }

                4 -> { Wave(Modifier.background(StarCommandBlue).fillMaxSize()) }

                5 -> { WanderingCubes( Modifier.background(BattleshipGrey).fillMaxSize()) }

                6 -> { Pulse(Modifier.background(MaximumYellowRed).fillMaxSize()) }

                7 -> { ChasingTwoDots(Modifier.background(BurntOrange).fillMaxSize()) }

                8 -> { ThreeBounce(Modifier.background(GOGreen).fillMaxSize()) }

                9 -> { Circle(Modifier.background(BurntOrange).fillMaxSize()) }

                10 -> { CubeGrid(Modifier.background(Charcoal).fillMaxSize()) }

                11 -> { FadingCircle(Modifier.background(MountainMeadow).fillMaxSize()) }

                12 -> { FoldingCube(Modifier.background(StarCommandBlue).fillMaxSize()) }

                13 -> { LoadingBar(fakeMillis = 10000) }

                14 -> { LoadingDots("Loading") }
            }
        }
    }
    BackHandler(enabled = state.currentPage != 0) {
        scope.launch {
            state.animateScrollToPage(state.currentPage - 1)
        }
    }
}