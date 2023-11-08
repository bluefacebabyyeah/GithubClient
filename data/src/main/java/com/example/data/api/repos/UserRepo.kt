package com.example.data.api.repos

import com.example.data.api.GithubApi
import com.example.domain.models.User
import com.example.domain.repos.IUserRepo
import javax.inject.Inject

class UserRepo @Inject constructor(
    private val api: GithubApi
): IUserRepo {
    override suspend fun searchUsers(query: String): List<User> {
        return api.searchUsers(query).toUserList(api)
    }
}