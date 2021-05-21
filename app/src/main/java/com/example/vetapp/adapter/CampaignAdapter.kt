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
import com.example.vetapp.model.Campaign
import com.example.vetapp.model.PetList
import kotlinx.android.synthetic.main.campaign_card.view.*
import kotlinx.android.synthetic.main.recycler_item.view.*

class CampaignAdapter(var campaignList: ArrayList<Campaign>) :
    RecyclerView.Adapter<CampaignAdapter.PetViewHolder>() {

    class PetViewHolder(var view: View) : RecyclerView.ViewHolder(view) {


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PetViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(
            R.layout.campaign_card,
            parent,
            false
        )

        return PetViewHolder(view)
    }

    override fun getItemCount(): Int {
        return campaignList.size

    }

    override fun onBindViewHolder(holder: PetViewHolder, position: Int) {
        holder.itemView.apply {
            baslik.text = campaignList[position].baslik
            Glide.with(this).load(campaignList[position].resim).into(campaignImage)
            campaignText.text = campaignList[position].text
            /*    petTur.setText("Tür: " + petlist[position].petTur)
                petCins.setText("Cins: " + petlist[position].petCins)
                petisim.setText("isim: " + petlist[position].petIsim)
              */
        }
    }


    fun update(newList: List<Campaign>) {
        campaignList.clear()
        campaignList.addAll(newList)
        notifyDataSetChanged()

    }


}