package com.example.vetapp.view

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vetapp.R
import com.example.vetapp.adapter.CampaignAdapter
import com.example.vetapp.adapter.PetListAdapter
import com.example.vetapp.model.Answer
import com.example.vetapp.model.PetList
import com.example.vetapp.network.VetAPI
import com.example.vetapp.viewModel.AnswerViewModel
import com.example.vetapp.viewModel.CampaignViewModel
import com.example.vetapp.viewModel.PetListViewModel
import com.example.vetapp.viewModel.QuestionViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_campaign.*
import kotlinx.android.synthetic.main.fragment_user_pets.*


class CampaignFragment : Fragment() {
    private lateinit var campaignViewModel: CampaignViewModel
    private val recyclerAdapter = CampaignAdapter(arrayListOf())

    /*private val TAG: String = UserPetsFragment().javaClass.simpleName
    private val DEBUG: Boolean = true*/


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_campaign, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        campaignViewModel = ViewModelProviders.of(this).get(CampaignViewModel::class.java)
        campaignViewModel.campaignList()
        setupRecycler()
        observer()


    }

    private fun setupRecycler() {
        campaignRecycler.layoutManager = LinearLayoutManager(context)
        campaignRecycler.adapter = recyclerAdapter


    }

    private fun observer() {
        campaignViewModel.campaignList.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            recyclerAdapter.update(it)
        })

    }


}


