package com.abaferastech.watermyplants.ui.screen.home

import com.abaferastech.watermyplants.ui.base.BaseUiState
import com.abaferastech.watermyplants.ui.base.ErrorUiState

data class HomeUiState(
    val isLoading: Boolean = true,
    val error: ErrorUiState = ErrorUiState()
) : BaseUiState