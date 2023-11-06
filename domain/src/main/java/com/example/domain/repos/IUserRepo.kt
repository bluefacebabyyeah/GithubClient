package com.example.domain.repos

interface IUserRepo {
    fun searchUsers(query:String): List<User>
}