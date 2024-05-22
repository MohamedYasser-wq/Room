package com.example.room.Data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {


    @Insert
    suspend fun AddUser(user: User)


    @Query("Select * From User_Table")
    fun Read_All_Users():LiveData<List<User>>







}