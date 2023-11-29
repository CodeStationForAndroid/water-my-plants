package com.abaferastech.watermyplants.ui.screen.addscreen

import android.graphics.Bitmap
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.ui.graphics.asImageBitmap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abaferastech.watermyplants.data.local.InvalidPlantException
import com.abaferastech.watermyplants.data.local.LocalRepository
import com.abaferastech.watermyplants.data.local.Plant
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class AddViewModel @Inject constructor(
    private val repository: LocalRepository,
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

    fun setImage(image: Bitmap){
        _uiState.update { currentState ->
            currentState.copy(
                image = image
            )
        }
    }

    fun savePlant() {
        viewModelScope.launch(Dispatchers.IO){
            repository.insertPlantEntity(
                Plant(
                    name = _uiState.value.plantName,
                    color = _uiState.value.color,
                    isWatered = _uiState.value.isWatered,
                    image = _uiState.value.image.toString(),
                    dateToWater = _uiState.value.dateToWater
                )
            )

        }

    }
}