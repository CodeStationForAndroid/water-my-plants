package com.abaferastech.watermyplants.ui.screen.home

import com.abaferastech.watermyplants.ui.base.BaseUiEffect

sealed class HomeScreenUiEffect() : BaseUiEffect {
    data object NavigateUp : HomeScreenUiEffect()
}