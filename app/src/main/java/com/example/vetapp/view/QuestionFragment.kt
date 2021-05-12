package com.example.vetapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.example.vetapp.R
import com.example.vetapp.model.PetList
import com.example.vetapp.model.Question
import com.example.vetapp.viewModel.QuestionViewModel
import com.example.vetapp.viewModel.RegisterViewModel
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_soru_sor.*


class QuestionFragment : Fragment() {
    //innerclass
    private lateinit var questionViewModel: QuestionViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_soru_sor, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        questionViewModel = ViewModelProviders.of(this).get(QuestionViewModel::class.java)

        observerLiveData()
        question_button.setOnClickListener {
            questionViewModel.getQuestion("30", question.text.toString())


        }
    }

    private fun observerLiveData() {
        questionViewModel.questionData.observe(viewLifecycleOwner, Observer {
            it.let { Question ->
                Question
                Toast.makeText(context, it.text, Toast.LENGTH_LONG).show()
            }
        })

    }
}