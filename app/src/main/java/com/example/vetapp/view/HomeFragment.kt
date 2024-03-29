package com.example.vetapp.view

import android.app.AlertDialog
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.vetapp.R
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {
    // lateinit var sharedPreferences: SharedPreferences

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /* if(sharedPreferences.getInt("id",0)==null&&
             sharedPreferences.getString("name",null)==null&&
             sharedPreferences.getString("mail",null)==null){
             Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_homeFragment)
         }*/

        soru_sor.setOnClickListener {
            openQuestion(it)
        }
        petCard.setOnClickListener {
            action(it)
        }
        cevap.setOnClickListener {
            answer(it)
        }
        campaignCard.setOnClickListener {
            campaignAction(it)

        }
        pet_asi_takibi.setOnClickListener {
            vaccineAction(it)
        }


    }

    private fun answer(view: View) {
        val action = HomeFragmentDirections.actionHomeFragmentToAnswerFragment()
        Navigation.findNavController(view).navigate(action)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)


    }
    private fun campaignAction(view: View) {
        val action =HomeFragmentDirections.actionHomeFragmentToCampaignFragment()
        Navigation.findNavController(view).navigate(action)

    }
    private fun vaccineAction(view: View) {
        val action = HomeFragmentDirections.actionHomeFragmentToVaccineFragment()
        Navigation.findNavController(view).navigate(action)

    }

    private fun action(view: View) {
        val action = HomeFragmentDirections.actionHomeFragmentToUserPetsFragment()
        Navigation.findNavController(view).navigate(action)

    }

    private fun openQuestion(view: View) {
        val action = HomeFragmentDirections.actionHomeFragmentToQuestionFragment()
        Navigation.findNavController(view).navigate(action)


    }

}