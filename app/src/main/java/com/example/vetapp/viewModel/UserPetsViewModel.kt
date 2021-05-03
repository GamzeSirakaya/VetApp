package com.example.vetapp.viewModel


import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.vetapp.model.PetList
import com.example.vetapp.network.VetAPI
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class UserPetsViewModel:ViewModel() {
    val petListLiveData = MutableLiveData<List<PetList>>() //innerclass
    private val compositeDisposable = CompositeDisposable() //Rxjava2 inner class
    private val vetAPI = VetAPI

    fun refreshData(){
        getPets("124")
    }

    fun getPets(mus_id: String) {
        compositeDisposable.add(
            vetAPI.getService().getPetList(mus_id)
                .subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<PetList>>() {
                    override fun onSuccess(t: List<PetList>) {
                      Log.d("basarili", t.toString())

                    }

                    override fun onError(e: Throwable) {
                        Log.d("Internet Error", "İnternetiniz kontrol ediniz.")

                    }


                })
        )

    }
}

