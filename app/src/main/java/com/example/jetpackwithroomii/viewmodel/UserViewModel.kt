package com.example.jetpackwithroomii.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.jetpackwithroomii.database.Library
import com.example.jetpackwithroomii.database.User
import com.example.jetpackwithroomii.database.UserAndLibrary
import com.example.jetpackwithroomii.database.UserDatabase
import com.example.jetpackwithroomii.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(
    application: Application
) : AndroidViewModel(application) {
    private val _readAllData = MutableLiveData<List<UserAndLibrary>>()
    val readAllData: LiveData<List<UserAndLibrary>> get() = _readAllData
    private val repository: UserRepository

    init {
        val userDao = UserDatabase.invoke(application).userDao()
        repository = UserRepository(userDao)
    }
    fun getUser(userId: Int) = viewModelScope.launch(Dispatchers.IO) {
        _readAllData.postValue(repository.getUserData(userId))
    }
    fun addUser(items: List<User>) = viewModelScope.launch(Dispatchers.IO) {
        repository.addUser(items)
    }
    fun addLibrary(items: List<Library>) = viewModelScope.launch(Dispatchers.IO) {
        repository.addLibrary(items)
    }
}