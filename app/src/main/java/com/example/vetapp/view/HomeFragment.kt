package com.example.vetapp.view

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.vetapp.R
import com.example.vetapp.Utils.GetSharedPref
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {
    // lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /* if(sharedPreferences.getInt("id",0)==null&&
             sharedPreferences.getString("name",null)==null&&
             sharedPreferences.getString("mail",null)==null){
             Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_homeFragment)
         }*/
        action()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)



    }

    fun action() {
        petlerim.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_userPetsFragment)
        }
    }


}