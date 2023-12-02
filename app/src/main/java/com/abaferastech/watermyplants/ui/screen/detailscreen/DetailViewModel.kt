package com.abaferastech.watermyplants.ui.screen.detailscreen

import android.graphics.Color
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abaferastech.watermyplants.data.local.LocalRepository
import com.abaferastech.watermyplants.data.local.Plant
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class DetailScreenState(
    var plant: Plant? = null
    )
@HiltViewModel
class DetailViewModel@Inject constructor(
    private val repository: LocalRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel(){

    private val _uiState = MutableStateFlow(DetailScreenState())
    val uiState: StateFlow<DetailScreenState> = _uiState.asStateFlow()

    private var currentPlantId: Int? = null

    init {
        savedStateHandle.get<Int>("plantId")?.let { plantId ->
            if(plantId != -1) {
                CoroutineScope(Dispatchers.IO).launch {
                    repository.getPlantEntityById(plantId)?.also { plant ->
                        currentPlantId = plant.id
                        _uiState.value = uiState.value.copy(
                            plant = plant
                        )

                    }
                }
            }else {
                _uiState.value.copy(
                    plant = null
                )
            }
        }

    }
}