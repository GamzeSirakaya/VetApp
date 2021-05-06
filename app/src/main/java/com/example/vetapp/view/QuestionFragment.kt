package com.example.vetapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        questionViewModel.getQuestion("1", "30");
        observerLiveData()
        question_button.setOnClickListener {
            question.text.toString()
        }
    }

    fun observerLiveData() {
        questionViewModel.questiondata.observe(viewLifecycleOwner, Observer {

        })

}
}