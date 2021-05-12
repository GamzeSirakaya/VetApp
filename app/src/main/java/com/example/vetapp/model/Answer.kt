package com.example.vetapp.model

import com.google.gson.annotations.SerializedName

data class Answer (

    @SerializedName("soru") val soru : String,
    @SerializedName("soruid") val soruId : Int,
    @SerializedName("cevap") val cevap : String,
    @SerializedName("cevapid") val cevapId : Int,
    @SerializedName("tf") val tf : Boolean
)