package com.example.vetapp.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.vetapp.R
import com.example.vetapp.viewModel.RegisterViewModel
import kotlinx.android.synthetic.main.fragment_register.*


class RegisterFragment : Fragment() {
    val registerViewModel = RegisterViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        registerToUser()
        action()
       // delete()
    }
    fun registerToUser() {
        register_button.setOnClickListener {
            registerViewModel.userRegister(register_name.editableText.toString(),
                register_mail.editableText.toString(),
                register_password.editableText.toString()
            )
        }
    }
    fun action(){
        register_text.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_registerFragment_to_loginFragment)
        }
    }
   /* fun delete(){
        register_name.delete,
        register_mail.delete,
        register_password.delete

    }*/


}