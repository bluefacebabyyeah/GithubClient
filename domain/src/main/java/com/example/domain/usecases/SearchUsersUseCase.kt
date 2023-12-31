package com.example.domain.usecases

import com.example.domain.models.User
import com.example.domain.repos.IUserRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SearchUsersUseCase @Inject constructor(
    private val userRepo: IUserRepo
) {
    suspend fun search(query: String): List<User> {
        return withContext(Dispatchers.IO) {
            userRepo.searchUsers(query)
        }
    }
}