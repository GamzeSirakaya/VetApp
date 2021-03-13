package com.example.vetapp.viewModel

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.vetapp.Utils.GetSharedPref
import com.example.vetapp.modelss.UserLogin
import com.example.vetapp.network.VetAPI
import com.example.vetapp.view.LoginFragment
import com.example.vetapp.view.MainActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class LoginViewModel {
    val userLoginLiveData = MutableLiveData<UserLogin>() //innerclass
    private val compositeDisposable = CompositeDisposable() //Rxjava2 inner class
    private val vetAPI = VetAPI

    fun userLogin( mailadres: String, password: String) {
        compositeDisposable.add(
            vetAPI.getService().getLogin(mailadres, password).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<UserLogin>() {
                    override fun onSuccess(t: UserLogin) {
                        userLoginLiveData.value = t

                       // GetSharedPref.save(t.id,t.kadi,t.mailAdres)
                    }

                    override fun onError(e: Throwable) {
                        Log.d("internet Error", "İnternet Bağlantınızı kontrol ediniz")

                    }
                }
                ))
    }
}