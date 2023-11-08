package com.example.githubclient.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.UserGithubRepositoryInfo
import com.example.domain.usecases.GetUserRepositoriesListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ReposViewModel @Inject constructor(
    private val getUserRepositoriesListUseCase: GetUserRepositoriesListUseCase
) :ViewModel() {
    val repos = MutableLiveData<List<UserGithubRepositoryInfo>>(emptyList())
    val loading = MutableLiveData<Boolean>()
    val error = MutableLiveData<String?>()

    fun getRepos(userName: String) {
        viewModelScope.launch {
            try {
                loading.value = true
                repos.value = getUserRepositoriesListUseCase(userName)!!
                if (repos.value.isNullOrEmpty()) {
                    error.value = "No repos found"
                    error.value = null
                }
            }
            catch (e: Exception) {
                error.value = e.message
                error.value = null
            }
            loading.value = false
        }
    }
}