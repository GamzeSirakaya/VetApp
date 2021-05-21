package com.example.vetapp.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.vetapp.R
import com.example.vetapp.databinding.RecyclerItemBinding
import com.example.vetapp.model.PetList
import kotlinx.android.synthetic.main.recycler_item.view.*

class PetListAdapter(var petlist: ArrayList<PetList>) :
    RecyclerView.Adapter<PetListAdapter.PetViewHolder>() {

    class PetViewHolder(var view: View) : RecyclerView.ViewHolder(view) {


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PetViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(
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
        holder.itemView.apply {
            petTur.setText("Tür: " + petlist[position].petTur)
            petCins.setText("Cins: " + petlist[position].petCins)
            petisim.setText("isim: " + petlist[position].petIsim)
            Glide.with(this).load(petlist[position].petResim).into(petResim)
        }
    }


    fun update(newList: List<PetList>) {
        petlist.clear()
        petlist.addAll(newList)
        notifyDataSetChanged()

    }


}