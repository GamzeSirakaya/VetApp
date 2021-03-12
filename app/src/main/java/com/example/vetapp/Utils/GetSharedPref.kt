package com.example.vetapp.Utils

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import androidx.fragment.app.Fragment
import com.example.vetapp.view.LoginFragment
import com.example.vetapp.view.MainActivity


object GetSharedPref {
    lateinit var sharedPreferences: SharedPreferences
    fun init(activity: Activity) {

        sharedPreferences = activity.getSharedPreferences("pref", Context.MODE_PRIVATE)
    }

    fun save(id: Int, name: String, mail: String) {
        sharedPreferences.edit().putInt("id", id).apply()
        sharedPreferences.edit().putString("name", name).apply()
        sharedPreferences.edit().putString("mail", mail).apply()

    }



}