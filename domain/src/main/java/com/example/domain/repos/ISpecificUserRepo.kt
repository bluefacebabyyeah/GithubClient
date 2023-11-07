package com.example.domain.repos

import com.example.domain.models.SpecificUserRepos

interface ISpecificUserRepo {
    suspend fun getSpecificUserRepo(userName: String): List<SpecificUserRepos>
}