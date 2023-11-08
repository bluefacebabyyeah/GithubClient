package com.example.data.api.models

import com.example.data.api.GithubApi
import com.google.gson.annotations.SerializedName
import com.example.domain.models.User as DomainUser

data class SearchUserDto(
    @SerializedName("incomplete_results")
    val incompleteResults: Boolean,
    val items: List<User>,
    @SerializedName("total_count")
    val totalCount: Int
) {
    suspend fun toUserList(api: GithubApi): List<DomainUser>{
        return items.map {
            it.toDomain(api)
        }
    }

    data class User(
        @SerializedName("avatar_url")
        val avatarUrl: String,
        val login: String,
    ) {
        suspend fun toDomain(api: GithubApi): DomainUser {
            return DomainUser(
                userName = login,
                imageUrl = avatarUrl,
                followersCount = api.getFollowers(login).size
            )
        }
    }


}