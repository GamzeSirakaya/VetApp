package com.example.vetapp.view

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vetapp.R
import com.example.vetapp.adapter.PetListAdapter
import com.example.vetapp.model.PetList
import com.example.vetapp.network.VetAPI
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_user_pets.*


class UserPetsFragment : Fragment() {
    private val recyclerAdapter = PetListAdapter(arrayListOf())


    /*private val TAG: String = UserPetsFragment().javaClass.simpleName
    private val DEBUG: Boolean = true*/


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        petList()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //petList()

        return inflater.inflate(R.layout.fragment_user_pets, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecycler()
        recyclerAdapter.notifyDataSetChanged()


    }

    private fun setupRecycler() {
        petRecyclerView.layoutManager = LinearLayoutManager(context)
        petRecyclerView.adapter = recyclerAdapter


    }


    private fun petList() {
        VetAPI.getService().getPetList("124")
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(object : Observer<List<PetList>> {
                override fun onSubscribe(d: Disposable) {
                    Log.d("", "PetOnSubscribed")
                }

                override fun onNext(t: List<PetList>) {
                    Log.d("", "PetOnNext" + t.get(0).petCins)
                }

                override fun onError(e: Throwable) {
                    Log.d("", "PetOnError" + e.message)
                }

                override fun onComplete() {
                    Log.d("", "PetOnComplete")
                }
            })
    }

    /*  private fun Log(message: String) {
          if (DEBUG)
              Log.d(TAG, message)

      }*/

}


