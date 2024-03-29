package com.example.vetapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.example.vetapp.R
import com.example.vetapp.viewModel.RegisterViewModel
import kotlinx.android.synthetic.main.fragment_register.*


class RegisterFragment : Fragment() {

    private lateinit var registerViewModel: RegisterViewModel

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
        registerViewModel = ViewModelProviders.of(this).get(RegisterViewModel::class.java)
        registerToUser()
        action()
        observerLiveData()
        delete()


    }

   private fun registerToUser() {
        register_button.setOnClickListener {

            registerViewModel.userRegister(
                register_name.editableText.toString(),
                register_mail.editableText.toString(),
                register_password.editableText.toString()
            )


        }
    }

    private fun delete() {
        register_name.setText("")
        register_mail.setText("")
        register_password.setText("")
    }

    private fun action() {
        register_text.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_registerFragment_to_loginFragment)
        }
    }

    private fun observerLiveData() {
        registerViewModel.userRegisterLiveData.observe(
            viewLifecycleOwner,
            androidx.lifecycle.Observer {
                it.let { userRegister ->
                    userRegister
                    Toast.makeText(context, it.text, Toast.LENGTH_LONG).show()
                }


            })


    }


}