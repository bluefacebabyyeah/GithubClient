package com.example.data.api.models

import com.example.data.api.GithubApi
import com.example.domain.models.User as DomainUser

data class SearchUserDto(
    val incomplete_results: Boolean,
    val items: List<User>,
    val total_count: Int
) {
    suspend fun mapToDomain(api: GithubApi): List<DomainUser>{
        return items.map {
            it.mapToDomain(api)
        }
    }
    data class User(
        val avatar_url: String,
        val events_url: String,
        val followers_url: String,
        val following_url: String,
        val gists_url: String,
        val gravatar_id: String,
        val html_url: String,
        val id: Int,
        val login: String,
        val node_id: String,
        val organizations_url: String,
        val received_events_url: String,
        val repos_url: String,
        val score: Double,
        val site_admin: Boolean,
        val starred_url: String,
        val subscriptions_url: String,
        val type: String,
        val url: String
    ) {
        suspend fun mapToDomain(api: GithubApi): DomainUser{
            return DomainUser(
                login,
                avatar_url,
                0 // api.getFollowers(login).size
            )
        }
    }


}