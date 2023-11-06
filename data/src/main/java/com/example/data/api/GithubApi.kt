package com.example.data.api

import com.example.data.api.models.SearchUserDto
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubApi {
    @GET("/search/users?q={query}")
    suspend fun searchUsers(@Query("q") query: String):
            SearchUserDto

}