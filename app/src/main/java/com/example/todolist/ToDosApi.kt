package com.example.todolist

import retrofit2.Response
import retrofit2.http.GET

interface ToDosApi {

    @GET("/todos")
    suspend fun getTodos(): Response<List<ToDos>>
}