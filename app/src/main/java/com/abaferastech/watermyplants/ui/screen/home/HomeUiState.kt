package com.abaferastech.watermyplants.ui.screen.home

import com.abaferastech.watermyplants.data.local.Plant
import com.abaferastech.watermyplants.ui.base.BaseUiState
import com.abaferastech.watermyplants.ui.base.ErrorUiState

data class HomeUiState(
    val isLoading: Boolean = true,
    val error: ErrorUiState = ErrorUiState(),
    val plants: List<Plant> = emptyList()
) : BaseUiState

fun Plant.toUiState(): HomeUiState {
    return HomeUiState(

    )
}