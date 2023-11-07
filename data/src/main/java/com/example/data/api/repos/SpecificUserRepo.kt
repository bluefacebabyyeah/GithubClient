package com.example.data.api.repos

import com.example.data.api.GithubApi
import com.example.data.api.models.RepoDto
import com.example.domain.models.SpecificUserRepos
import com.example.domain.repos.ISpecificUserRepo
import javax.inject.Inject

class SpecificUserRepo@Inject constructor(
    private val api: GithubApi
) : ISpecificUserRepo {
    override suspend fun getSpecificUserRepo(userName: String): List<SpecificUserRepos> {
        return api.getSpecificUserRepos(userName).mapToDomain(api)
    }
}