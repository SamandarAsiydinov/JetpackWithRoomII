package com.example.jetpackwithroomii.repository

import androidx.lifecycle.LiveData
import com.example.jetpackwithroomii.database.Library
import com.example.jetpackwithroomii.database.User
import com.example.jetpackwithroomii.database.UserAndLibrary
import com.example.jetpackwithroomii.database.UserDao

class UserRepository(
    private val userDao: UserDao
) {
    var readAllData: LiveData<List<UserAndLibrary>>? = null

    suspend fun addUser(items: List<User>) {
        userDao.insertUser(items)
    }

    suspend fun addLibrary(items: List<Library>) {
        userDao.insertLibrary(items)
    }

    fun getUserData(userId: Int): List<UserAndLibrary> {
        return userDao.getUserAndLibraries(userId)
    }
}