package com.example.vetapp.view

import android.os.Bundle
import android.util.Log
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.vetapp.R
import com.example.vetapp.databinding.FragmentLoginBinding
import com.example.vetapp.modelss.UserLogin
import com.example.vetapp.viewModel.LoginViewModel
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_register.*
import kotlinx.android.synthetic.main.fragment_register.register_text
import java.util.Observer


class LoginFragment : Fragment() {
    val loginViewModel = LoginViewModel()
    private lateinit var dataBinding: FragmentLoginBinding
    private lateinit var userLogin: UserLogin
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment


        return inflater.inflate( R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        action()
        observerLiveData()
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

    fun observerLiveData() {
        loginViewModel.userLoginLiveData.observe(viewLifecycleOwner, androidx.lifecycle.Observer {it.let {
            userLogin -> userLogin
            Toast.makeText(context,it.text,Toast.LENGTH_LONG).show()
        }


        })


    }
}