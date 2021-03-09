package com.example.vetapp.viewModel

import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.vetapp.Models.UserRegister
import com.example.vetapp.network.VetAPI
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class RegisterViewModel {
    val userRegisterLiveData=MutableLiveData<UserRegister>() //innerclass
    private val compositeDisposable=CompositeDisposable() //Rxjava2 inner class
    private val vetAPI=VetAPI


    fun userRegister(userName: String, userMailAdres:String, userPassword:String){
        compositeDisposable.add(
            vetAPI.getService().getRegister(userName,userMailAdres,userPassword).
            subscribeOn(Schedulers.newThread()).
            observeOn(AndroidSchedulers.mainThread()).subscribeWith(object :DisposableSingleObserver<UserRegister>(){
                override fun onSuccess(t: UserRegister) {
                    if(t.tf.toBoolean()){

                        t.text
                        Log.d("text",t.text)
                        //başarılıysa giriş yapa git

                    }else{
                        t.text
                        Log.d("text",t.text)
                    }

                }

                override fun onError(e: Throwable) {
                    Log.d("Internet Error","İnternetiniz kontrol ediniz.")

                }
            })
        )

    }
}