package com.example.vetapp.view

import android.os.Bundle
import android.provider.SyncStateContract
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vetapp.R
import com.example.vetapp.adapter.AnswerAdapter
import com.example.vetapp.model.Answer
import com.example.vetapp.viewModel.AnswerViewModel
import kotlinx.android.synthetic.main.fragment_answer.*
import java.util.ArrayList

class AnswerFragment : Fragment() {
    private lateinit var answerViewModel: AnswerViewModel
    private val answerAdapter = AnswerAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_answer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        answerViewModel = ViewModelProviders.of(this).get(AnswerViewModel::class.java)
        answerViewModel.getAnswer("30")
        setupRecycler()
        observerLiveData()


    }

    private fun observerLiveData() {
        answerViewModel.answerViewModel.observe(viewLifecycleOwner, Observer {
            it.let {
                answerRecycler.visibility = View.VISIBLE
            }
        })
    }

    private fun setupRecycler() {

        answerRecycler.layoutManager = LinearLayoutManager(context)
        answerRecycler.adapter = answerAdapter


    }
}