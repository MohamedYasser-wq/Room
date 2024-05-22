package com.example.room.Data

import androidx.lifecycle.LiveData

class UserRepository(private  val userDao: UserDao) {

    val ReadAllUser:LiveData<List<User>> = userDao.Read_All_Users()

    suspend fun AddUser(user: User){
        userDao.AddUser(user)

    }

}