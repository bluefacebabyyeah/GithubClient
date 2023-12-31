package com.example.githubclient.di

import com.example.data.api.repos.UserGithubRepositoriesRepo
import com.example.data.api.repos.UserRepo
import com.example.domain.repos.IUserGithubRepositoriesRepo
import com.example.domain.repos.IUserRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindUserRepo(userRepo: UserRepo): IUserRepo
    @Binds
    abstract fun bindSpecificUserRepo(userGithubRepositoriesRepo: UserGithubRepositoriesRepo): IUserGithubRepositoriesRepo
}