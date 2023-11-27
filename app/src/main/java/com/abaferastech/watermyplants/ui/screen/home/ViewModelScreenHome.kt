package com.abaferastech.watermyplants.ui.screen.home

import androidx.lifecycle.SavedStateHandle
import com.abaferastech.watermyplants.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ViewModelScreenHome @Inject constructor(
    savedStateHandle: SavedStateHandle,
) : BaseViewModel<HomeUiState, HomeScreenUiEffect>(HomeUiState()), HomeScreenInteraction {

    private val args: HomeScreenArgs = HomeScreenArgs(savedStateHandle = savedStateHandle)

    init {

    }

    override fun onClickBack() {
        TODO("Not yet implemented")
    }

    override fun getData() {

    }

}