package com.example.vetapp.Utils

import android.app.Activity
import android.app.PendingIntent.getActivity
import android.content.Context
import android.content.SharedPreferences
import androidx.fragment.app.Fragment
import com.example.vetapp.view.LoginFragment
import com.example.vetapp.view.MainActivity


object GetSharedPref {
    lateinit var sharedPreferences: SharedPreferences
    fun init(context: Context) {

        sharedPreferences = context.getSharedPreferences("pref", Context.MODE_PRIVATE)
    }

    fun save(pass: String, mail: String) {
        val editor = sharedPreferences.edit()
        editor.putString("pass", pass).apply()
        editor.putString("mail", mail).apply()
        editor.commit()

    }


}