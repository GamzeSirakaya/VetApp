package com.example.vetapp.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.vetapp.R
import com.example.vetapp.viewModel.RegisterViewModel
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    val registerViewModel = RegisterViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        registerToUser()
    }

    fun registerToUser() {
        register_button.setOnClickListener {
            registerViewModel.userRegister(register_name.editableText.toString(),
                register_mail.editableText.toString(),
                register_password.editableText.toString())
        }
    }

}