package com.example.domain.repos

import com.example.domain.models.User

interface IUserRepo {
    suspend fun searchUsers(query:String): List<User>
}