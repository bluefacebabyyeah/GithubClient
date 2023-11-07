package com.example.domain.models

data class SpecificUserRepos (
    val name: String,
    val description: String,
    val lastDateCommit: String,
    val defaultFork: String,
    val countForks: String,
    val starsCount: String,
    val language: String
)