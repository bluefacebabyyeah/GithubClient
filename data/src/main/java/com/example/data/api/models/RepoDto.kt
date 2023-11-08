package com.example.data.api.models

import com.example.domain.models.UserGithubRepositoryInfo
import com.google.gson.annotations.SerializedName

data class RepoDto(
    @SerializedName("default_branch")
    val defaultBranch: String,
    val description: String?,
    @SerializedName("forks_count")
    val forksCount: Int,
    val language: String?,
    val name: String,
    @SerializedName("stargazers_count")
    val stargazersCount: Int,
    @SerializedName("updated_at")
    val updatedAt: String,
) {
    fun toDomain(): UserGithubRepositoryInfo {
        return UserGithubRepositoryInfo(
            name = name,
            description = description ?: "No description",
            lastDateCommit = updatedAt,
            defaultBranch = defaultBranch,
            countForks = forksCount,
            starsCount = stargazersCount,
            language = language ?: "No language"
        )
    }
}