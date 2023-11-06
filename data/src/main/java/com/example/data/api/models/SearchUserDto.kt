package com.example.data.api.models

data class SearchUserDto(
    val incomplete_results: Boolean,
    val items: List<UserDto>,
    val total_count: Int
)