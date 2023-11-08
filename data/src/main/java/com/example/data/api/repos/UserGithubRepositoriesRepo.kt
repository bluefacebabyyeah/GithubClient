package com.example.data.api.repos

import com.example.data.api.GithubApi
import com.example.domain.models.UserGithubRepositoryInfo
import com.example.domain.repos.IUserGithubRepositoriesRepo
import javax.inject.Inject

class UserGithubRepositoriesRepo @Inject constructor(
    private val api: GithubApi,
): IUserGithubRepositoriesRepo {
    override suspend fun getRepositoriesByUserName(userName: String): List<UserGithubRepositoryInfo> {
        return api.getSpecificUserRepos(userName).map { it.toDomain() }
    }
}