package com.abaferastech.watermyplants.ui.screen.addscreen

import android.media.Image
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.abaferastech.watermyplants.data.local.LocalRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class AddViewModel @Inject constructor(
    private val repository: LocalRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {


    private val _uiState = MutableStateFlow(AddScreenState())
    val uiState: StateFlow<AddScreenState> = _uiState.asStateFlow()

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    sealed class UiEvent {
        data class ShowSnackBar(val message: String): UiEvent()
        object SavePlant: UiEvent()
    }

    fun setPlantName(plantName: String) {
        _uiState.update { currentState ->
            currentState.copy(
                plantName = plantName
            )
        }
    }

    fun setDate(date: LocalDate) {
        _uiState.update { currentState ->
            currentState.copy(
                dateToWater = date,
            )
        }
    }

    fun setImage(image: Image){

    }

    fun savePlant() {


    }
}