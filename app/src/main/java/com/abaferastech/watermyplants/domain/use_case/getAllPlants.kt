package com.abaferastech.watermyplants.domain.use_case

import com.abaferastech.watermyplants.domain.model.Todo
import kotlinx.coroutines.flow.Flow

interface getAllPlants {
    suspend operator fun invoke() : Flow<List<Todo>>
}