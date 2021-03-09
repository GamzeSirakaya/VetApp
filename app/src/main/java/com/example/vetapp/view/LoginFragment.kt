package com.example.vetapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.vetapp.R
import com.example.vetapp.viewModel.LoginViewModel
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_register.*
import kotlinx.android.synthetic.main.fragment_register.register_text


class LoginFragment : Fragment() {
    val loginViewModel = LoginViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        action()
    }

    fun action() {
        login_text.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_loginFragment_to_registerFragment)

        }
        login_button.setOnClickListener {
            loginViewModel.userLogin(
                login_mail.editableText.toString(),
                login_password.editableText.toString()
            )

        }
    }


}