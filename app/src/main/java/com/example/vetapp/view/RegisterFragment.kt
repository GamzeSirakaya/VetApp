package com.example.vetapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.vetapp.R
import com.example.vetapp.databinding.FragmentRegisterBinding
import com.example.vetapp.modelss.UserRegister
import com.example.vetapp.viewModel.RegisterViewModel
import kotlinx.android.synthetic.main.fragment_register.*


class RegisterFragment : Fragment() {
    val registerViewModel = RegisterViewModel()
    private lateinit var dataBinding: FragmentRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_register, container, false)

        return dataBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        registerToUser()
        action()

    }

    fun registerToUser() {
        register_button.setOnClickListener {

            registerViewModel.userRegister(
                register_name.editableText.toString(),
                register_mail.editableText.toString(),
                register_password.editableText.toString()
            )


          message_text.visibility=View.VISIBLE
        }
    }

    fun action() {
        register_text.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_registerFragment_to_loginFragment)
        }
    }



}