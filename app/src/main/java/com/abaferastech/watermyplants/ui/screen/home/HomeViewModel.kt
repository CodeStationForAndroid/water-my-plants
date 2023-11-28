package com.abaferastech.watermyplants.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abaferastech.watermyplants.data.local.Plant
import com.abaferastech.watermyplants.data.local.LocalRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

data class HomeState(
    var plants: List<Plant> = emptyList(),
)

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: LocalRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeState())
    val uiState: StateFlow<HomeState> = _uiState.asStateFlow()


    init {

            loadPlants()
    }


    private fun loadPlants(){
        repository.getPlantEntities().onEach { plants ->
            _uiState.value = uiState.value.copy(
                plants = plants
            )
        }
            .launchIn(viewModelScope)
    }

    fun deletePlant(plant: Plant){
        viewModelScope.launch {
            repository.deletePlantEntity(plant)
        }
    }


}