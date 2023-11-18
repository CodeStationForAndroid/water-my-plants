package com.abaferastech.watermyplants.ui.screen.home

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.runtime.collectAsState
import com.abaferastech.watermyplants.ui.navigation.NavigationHandler


@Composable
fun ScreenHome(
    viewModelScreenHome: ViewModelScreenHome = hiltViewModel()
) {
    val state = viewModelScreenHome.state.collectAsState().value
    ScreenHomeContent(state = state, interaction = viewModelScreenHome)
    NavigationHandler(effects = viewModelScreenHome.effect) { effect, controller ->
        when (effect) {
            is HomeScreenUiEffect.NavigateUp -> {
                controller.popBackStack()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenHomeContent(
    state: HomeUiState,
    interaction: HomeScreenInteraction
) {

}


@Preview(device = "spec:width=360dp,height=800dp,orientation=portrait")
@Composable
fun HomeTester() {

}