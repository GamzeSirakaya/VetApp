package com.example.vetapp.viewModel

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.vetapp.model.Answer
import com.example.vetapp.model.AnswerRemove
import com.example.vetapp.network.VetAPI
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class AnswerRemoveViewModel : ViewModel() {

    val answerRemoveViewModel = MutableLiveData<List<AnswerRemoveViewModel>>()



}