package com.example.room.Data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [User::class], version = 4, exportSchema = false)
abstract class UserDataBase:RoomDatabase() {


   abstract fun userDao():UserDao

   companion object{

  @Volatile
  private var Instance:UserDataBase?=null

       fun getDataBase(context: Context):UserDataBase{
           val  tempInstance= Instance
           if(tempInstance!=null) {
               return tempInstance
           }
           synchronized(this){
               val instance= Room.databaseBuilder(
                   context.applicationContext,
                   UserDataBase::class.java,
                   "AllData").fallbackToDestructiveMigration().build()

               Instance=instance
               return instance


           }


            }

   }



}