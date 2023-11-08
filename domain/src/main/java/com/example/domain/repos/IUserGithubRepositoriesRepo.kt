package com.example.domain.repos

import com.example.domain.models.UserGithubRepositoryInfo

interface IUserGithubRepositoriesRepo {
    suspend fun getRepositoriesByUserName(userName: String): List<UserGithubRepositoryInfo>
}