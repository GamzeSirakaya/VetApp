package com.example.vetapp.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.vetapp.model.Question
import com.example.vetapp.model.UserLogin
import com.example.vetapp.network.VetAPI
import android.util.Log
import com.example.vetapp.view.QuestionFragment

import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.SchedulerRunnableIntrospection
import io.reactivex.schedulers.Schedulers

class QuestionViewModel : ViewModel() {
    val questionData = MutableLiveData<Question>()



    fun getQuestion(id: String, soru: String) {

        VetAPI.getService().getQuestion(id, soru)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(object : Observer<Question> {
                override fun onSubscribe(d: Disposable) {
                    Log.d("ServiceOnSubscribed", "ServiceOnSubscribed")
                }

                override fun onNext(t: Question) {
                    Log.d("ServiceOnNext", "ServiceOnNext")
                }

                override fun onError(e: Throwable) {
                    Log.d("ServiceOnError", "ServiceOnError")
                }

                override fun onComplete() {
                    Log.d("ServiceOnComplete", "ServiceOnComplete")
                }

            })


    }


}


