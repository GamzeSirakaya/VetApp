package com.example.vetapp.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.vetapp.model.Answer
import com.example.vetapp.network.VetAPI
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class AnswerViewModel : ViewModel() {
    private val DEBUG = true
    private val TAG: String = AnswerViewModel::class.java.simpleName

    val answerViewModel = MutableLiveData<List<Answer>>()


    fun refreshData(mus_id: String) {
        getAnswer(mus_id)
    }

    fun getAnswer(mus_id: String) {
        VetAPI.getService().getAnswer(mus_id)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(object : Observer<List<Answer>> {
                override fun onSubscribe(d: Disposable) {
                    Log("ServiceOnSubscribed")

                }

                override fun onNext(t: List<Answer>) {
                    Log("ServiceOnNext" + t[0].toString())
                    answerViewModel.value=t

                }

                override fun onError(e: Throwable) {
                    Log("ServiceOnError" + e.message)
                }

                override fun onComplete() {
                    Log("ServiceOnComplete")
                }

            })
    }

    private fun Log(message: String) {
        if (DEBUG)
            Log.d(TAG, message)


    }
}