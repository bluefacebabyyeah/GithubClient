package com.example.data.api

import com.example.data.api.models.SearchUserDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubApi {
    @GET("/search/users")
    suspend fun searchUsers(@Query("q") query: String):
            SearchUserDto
    @GET("users/{login}/followers")
    suspend fun getFollowers(@Path("login") login:String): List<SearchUserDto.User>
}