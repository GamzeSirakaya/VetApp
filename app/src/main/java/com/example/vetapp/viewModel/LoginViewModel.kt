package com.example.vetapp.viewModel

import android.content.Intent
import android.util.Log
import com.example.vetapp.Models.UserLogin
import com.example.vetapp.network.VetAPI
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class LoginViewModel {
    private val compositeDisposable = CompositeDisposable() //Rxjava2 inner class
    private val vetAPI = VetAPI

    fun userLogin(mailadres: String, password: String) {
        compositeDisposable.add(
            vetAPI.getService().getLogin(mailadres, password).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<UserLogin>() {
                    override fun onSuccess(t: UserLogin) {
                        if (t.tf.toBoolean()) {
                            t.text
                            Log.d("text",t.text)

                        } else {
                            t.text
                            Log.d("text",t.text)
                        }

                    }

                    override fun onError(e: Throwable) {
                        Log.d("internet Error", "İnternet Bağlantınızı kontrol ediniz")

                    }
                }
                ))
    }
}