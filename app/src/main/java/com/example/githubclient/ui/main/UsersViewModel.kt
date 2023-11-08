package com.example.githubclient.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.User
import com.example.domain.usecases.SearchUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(
    private val searchUsersUseCase: SearchUsersUseCase
): ViewModel() {
    val users = MutableLiveData<List<User>>(emptyList())
    val loading = MutableLiveData<Boolean>()
    val error = MutableLiveData<String?>()

    fun searchUsers(query: String) {
        viewModelScope.launch {
            loading.value = true
            try {
                users.value = searchUsersUseCase.search(query)
                if (users.value.isNullOrEmpty()) {
                    error.value = "No users found"
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