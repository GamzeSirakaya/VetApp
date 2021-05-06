package com.example.vetapp.view

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.example.vetapp.R
import com.example.vetapp.viewModel.LoginViewModel
import kotlinx.android.synthetic.main.fragment_login.*


class LoginFragment : Fragment() {
    lateinit var sharedPreferences: SharedPreferences
   private lateinit var loginViewModel: LoginViewModel


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
        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)

        observerLiveData()
        action()
        delete()

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
            Navigation.findNavController(it).navigate(R.id.action_loginFragment_to_homeFragment)


        }
    }

    fun delete() {
        login_mail.setText("")
        login_password.setText("")
    }

    fun observerLiveData() {
        loginViewModel.userLoginLiveData.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            it.let { userLogin ->
                userLogin
                Toast.makeText(context, it.text, Toast.LENGTH_LONG).show()
                /*this@LoginFragment.context?.let { GetSharedPref.init(it) }
                GetSharedPref.save(login_mail.editableText.toString(),login_password.editableText.toString())

                if (sharedPreferences.getString(
                        "pass",
                        ""
                    ) == null &&
                    sharedPreferences.getString("mail","") == null
                ) {
                    Log.i("sdfghjkl","fghjklş")
                    view?.let { it1 ->  }
                }*/

            }


        })


    }


}

