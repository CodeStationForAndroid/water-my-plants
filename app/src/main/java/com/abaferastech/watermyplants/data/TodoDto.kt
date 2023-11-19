package com.abaferastech.watermyplants.data

import com.abaferastech.watermyplants.domain.model.Todo

data class TodoDto(val id: Int, val description: String)
fun TodoDto.toDomain(): Todo {
    return Todo(id = id, description = description)
}