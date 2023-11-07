package com.example.domain.models

import java.io.Serializable

data class User(
    val userName: String,
    val imageUrl: String,
    val followersCount: Int
) : Serializable
