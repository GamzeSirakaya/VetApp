package com.example.vetapp.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vetapp.R
import com.example.vetapp.adapter.PetListAdapter
import com.example.vetapp.viewModel.UserPetsViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_user_pets.*


class UserPetsFragment : Fragment() {
    private lateinit var petsViewModel: UserPetsViewModel
    private val recyclerAdapter = PetListAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_user_pets, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        petsViewModel = ViewModelProviders.of(this).get(UserPetsViewModel::class.java)
        petsViewModel.refreshData()
        setupRecycler()
        observeLiveData()


    }

    fun setupRecycler() {
        petRecyclerView.layoutManager = LinearLayoutManager(context)
        petRecyclerView.adapter = recyclerAdapter


    }

    fun observeLiveData() {
        petsViewModel.petListLiveData.observe(viewLifecycleOwner, Observer {
            if (it.get(0).tf) {
               val petlist= it
                recyclerAdapter.update(petlist)
                Toast.makeText(
                    context,
                    "Sistemde Kayıtlı "+petlist.size+" bulunmamaktadır.",
                    Toast.LENGTH_LONG
                )
            } else {
                Toast.makeText(
                    context,
                    "Sistemde Kayıtlı petiniz bulunmamaktadır.",
                    Toast.LENGTH_LONG
                )

            }



        })
    }


}


