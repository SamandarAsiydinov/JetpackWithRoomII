package com.example.jetpackwithroomii.database

import androidx.room.*

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(items: List<User>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLibrary(items: List<Library>)

    @Transaction
    @Query("SELECT * FROM User WHERE userId = :userId")
    fun getUserAndLibraries(userId: Int): List<UserAndLibrary>
}