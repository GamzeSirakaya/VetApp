package com.example.vetapp.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.vetapp.R
import com.example.vetapp.databinding.RecyclerItemBinding
import com.example.vetapp.model.PetList

class PetListAdapter(val petlist: ArrayList<PetList>) :
    RecyclerView.Adapter<PetListAdapter.PetViewHolder>() {

    class PetViewHolder(var view: RecyclerItemBinding) : RecyclerView.ViewHolder(view.root) {


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PetViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<RecyclerItemBinding>(
            inflater,
            R.layout.recycler_item,
            parent,
            false
        )
        return PetViewHolder(view)
    }
    override fun getItemCount(): Int {
        return petlist.size

    }
    override fun onBindViewHolder(holder: PetViewHolder, position: Int) {
        holder.view.petlistt=petlist[position]
        holder.view.executePendingBindings()
    }



    fun update(newList: List<PetList>) {
        petlist.clear()
        petlist.addAll(newList)
        notifyDataSetChanged()

    }


}