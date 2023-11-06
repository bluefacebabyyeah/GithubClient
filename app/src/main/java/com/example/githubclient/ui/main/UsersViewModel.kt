package com.example.githubclient.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.User
import com.example.domain.usecases.SearchUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(
    private val searchUserUseCase: SearchUserUseCase

) :ViewModel() {
    val users = MutableLiveData<List<User>>(emptyList())
    fun searchUser(query: String){
        viewModelScope.launch {
            users.value = searchUserUseCase.searchUser(query)
        }
    }
}