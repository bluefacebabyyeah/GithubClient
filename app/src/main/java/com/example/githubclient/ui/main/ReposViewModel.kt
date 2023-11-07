package com.example.githubclient.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.SpecificUserRepos
import com.example.domain.models.User
import com.example.domain.usecases.GetSpecificUserReposUseCase
import com.example.domain.usecases.SearchUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ReposViewModel @Inject constructor(
    private val getSpecificUserReposUseCase: GetSpecificUserReposUseCase

) :ViewModel() {
    val repos = MutableLiveData<List<SpecificUserRepos>>(emptyList())
    fun getRepo(userName: String){
        viewModelScope.launch {
            repos.value = getSpecificUserReposUseCase.getSpecificUserRepos(userName)
        }
    }
}