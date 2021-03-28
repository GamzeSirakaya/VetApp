package com.example.vetapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vetapp.R
import com.example.vetapp.adapter.PetListAdapter
import com.example.vetapp.viewModel.UserPetsViewModel
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

        // Inflate the layout for this fragment
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        petsViewModel=ViewModelProviders.of(this).get(UserPetsViewModel::class.java)
        petsViewModel.refreshData()
        setupRecycler()
        observeLiveData()
    }

    fun setupRecycler() {
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = recyclerAdapter
    }

    fun observeLiveData() {
        petsViewModel.petListLiveData.observe(viewLifecycleOwner, Observer {petList->petList?.let {
            recyclerAdapter.update(it)
        }

        })
    }

}

