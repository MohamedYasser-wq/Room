package com.example.room.Shared

import android.content.Context
import android.content.SharedPreferences


object SharedPrefs {
    private const val PREFS_NAME = "user_data"
    private lateinit var sharedPreferences: SharedPreferences

    fun init(context: Context) {
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }
    ///////////////////////////////////////////////

    fun setUserid (id : String){
       val shared= sharedPreferences.edit()
        shared.putString("USER_id", id)
            shared.apply()

    }
    fun getUserid(): String? {
        return sharedPreferences.getString("USER_id", "" )
    }

    ////////////////////////////////////////////////

    fun setUserName (Name : String){
        val shared= sharedPreferences.edit()
        shared.putString("USER_Name", Name)
        shared.apply()

    }
    fun getUserName(): String? {
        return sharedPreferences.getString("USER_Name", "" )
    }

    //////////////////////////////////////////////////
    fun setUserphone(phone : String){
        val shared= sharedPreferences.edit()
        shared.putString("USER_phone", phone)
        shared.apply()

    }
    fun getUserphone(): String? {
        return sharedPreferences.getString("USER_phone", "" )
    }
    //////////////////////////////////////////

    fun setUserEmail(email : String){
        val shared= sharedPreferences.edit()
        shared.putString("USER_Email", email)
        shared.apply()
    }
    fun getUserEmail(): String? {
        return sharedPreferences.getString("USER_Email", "" )
    }
    ///////////////////////////////////////////


    fun setUserPass(pass : String){
        val shared= sharedPreferences.edit()
        shared.putString("USER_Pass", pass)
        shared.apply()
    }
    fun getUserPass(): String? {
        return sharedPreferences.getString("USER_Pass", "" )
    }


}