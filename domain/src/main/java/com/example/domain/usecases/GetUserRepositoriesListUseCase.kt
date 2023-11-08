package com.example.domain.usecases

import com.example.domain.models.UserGithubRepositoryInfo
import com.example.domain.repos.IUserGithubRepositoriesRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetUserRepositoriesListUseCase @Inject constructor(
    private val specificUserRepos: IUserGithubRepositoriesRepo
) {
    suspend operator fun invoke(userName: String): List<UserGithubRepositoryInfo> {
        return withContext(Dispatchers.IO) {
            specificUserRepos.getRepositoriesByUserName(userName)
        }
    }
}