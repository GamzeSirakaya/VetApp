package com.example.vetapp.viewModel

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.vetapp.model.Answer
import com.example.vetapp.network.VetAPI
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class AnswerViewModel : ViewModel() {

    val answerViewModel = MutableLiveData<List<AnswerViewModel>>()


    fun getAnswer(mus_id: String) {
        VetAPI.getService().getAnswer(mus_id)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(object : Observer<List<Answer>> {
                override fun onSubscribe(d: Disposable) {
                    Log.d("ServiceOnSubscribed", "ServiceOnSubscribed")
                }

                override fun onNext(t: List<Answer>) {
                    Log.d("ServiceOnNext", "ServiceOnNext" + t[0].cevap)
                    if (t[0].tf) {
                       Log.i("Cevaplarım",t[0].toString())

                    } else {

                    }
                }

                override fun onError(e: Throwable) {
                    Log.d("ServiceOnError", "ServiceOnError" + e.message)
                }

                override fun onComplete() {
                    Log.d("ServiceOnComplete", "ServiceOnComplete")
                }

            })
    }
}