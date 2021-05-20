package com.example.vetapp.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.vetapp.model.PetList
import com.example.vetapp.network.VetAPI
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class PetListViewModel : ViewModel() {

    private val DEBUG = true
    private val TAG: String = PetListViewModel::class.java.simpleName
    val petList = MutableLiveData<List<PetList>>()

  fun petList() {
        VetAPI.getService().getPetList("124")
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(object : Observer<List<PetList>> {
                override fun onSubscribe(d: Disposable) {
                    Log("PetOnSubscribed")
                }

                override fun onNext(t: List<PetList>) {
                    Log("PetOnNext" + t[0].petCins)
                    petList.value = t

                }

                override fun onError(e: Throwable) {
                    Log("PetOnError" + e.message)
                }

                override fun onComplete() {
                    Log("PetOnComplete")
                }
            })
    }

    private fun Log(message: String) {
        if (DEBUG)
            android.util.Log.d(TAG, message)

    }
}