package com.example.vetapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.vetapp.R
import com.example.vetapp.model.Vaccine
import com.example.vetapp.viewModel.VaccineViewModel
import kotlinx.android.synthetic.main.fragment_vacciene.*
import java.text.DateFormat
import java.util.*

class VaccineFragment : Fragment() {
    private val calendar = Calendar.getInstance()
    private lateinit var vaccineViewModel: VaccineViewModel
    private var asiList: List<Vaccine>? = null
    private var dateList: List<Date>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_vacciene, container, false)
        calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            calendar.set(year, month, dayOfMonth)
            val dateFormatter = DateFormat.getDateInstance(DateFormat.MEDIUM)
            val formattedDate = dateFormatter.format(calendar.time)

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vaccineViewModel = ViewModelProviders.of(this).get(VaccineViewModel::class.java)
        vaccineViewModel.refreshData("124")

        asiList = java.util.ArrayList()
        dateList = java.util.ArrayList()
        observerLiveData()
    }

    private fun observerLiveData() {
        vaccineViewModel.vaccineViewModelList.observe(
            viewLifecycleOwner,
            androidx.lifecycle.Observer {
                asiList = it

                



            })
    }
}

