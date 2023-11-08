package com.example.domain.models

data class UserGithubRepositoryInfo(
    val name: String,
    val description: String,
    val lastDateCommit: String,
    val defaultBranch: String,
    val countForks: Int,
    val starsCount: Int,
    val language: String
)