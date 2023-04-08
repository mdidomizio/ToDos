package com.example.todolist

data class ToDos(
    val completed: Boolean,
    val id: Int,
    val title: String,
    val userId: Int
)
