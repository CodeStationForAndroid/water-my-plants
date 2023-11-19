package com.abaferastech.watermyplants.data

import com.abaferastech.watermyplants.domain.model.TodoDetails

data class TodoDetailsDto(val id: Int, val description: String) {
}

fun TodoDetailsDto.toDomain(): TodoDetails {
    return TodoDetails(id = id, description = description)
}