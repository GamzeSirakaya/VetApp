package com.example.vetapp.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.vetapp.model.Answer
import com.example.vetapp.model.Vaccine
import com.example.vetapp.network.VetAPI
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.*

class VaccineViewModel : ViewModel() {
    private val DEBUG = true
    private val TAG: String = VaccineViewModel::class.java.simpleName
    private var asiList: List<Vaccine>? = null
    private var dateList: List<Date>? = null

    val vaccineViewModelList = MutableLiveData<List<Vaccine>>()


    fun refreshData(mus_id: String) {
        getVaccine(mus_id)
    }

    fun getVaccine(mus_id: String) {
        VetAPI.getService().getAsiTakibi(mus_id)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(object : Observer<List<Vaccine>> {
                override fun onSubscribe(d: Disposable) {
                    Log("ServiceOnSubscribed")

                }

                override fun onNext(t: List<Vaccine>) {
                    Log("ServiceOnNext" + t[0].toString())
                    vaccineViewModelList.value=t

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