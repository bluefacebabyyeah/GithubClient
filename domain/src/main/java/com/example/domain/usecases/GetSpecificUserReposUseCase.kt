package com.example.domain.usecases

import com.example.domain.models.SpecificUserRepos
import com.example.domain.repos.ISpecificUserRepo
import com.example.domain.repos.IUserRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetSpecificUserReposUseCase @Inject constructor(
    private val specificUserRepos: ISpecificUserRepo
) {
    suspend fun getSpecificUserRepos(userName: String): List<SpecificUserRepos>{
        return withContext(Dispatchers.IO){
            specificUserRepos.getSpecificUserRepo(userName)
        }
    }
}