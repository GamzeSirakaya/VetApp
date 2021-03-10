package com.example.vetapp.modelss

import com.google.gson.annotations.SerializedName

data class UserLogin (
    @SerializedName("id")
    val id:Int,
    @SerializedName("kadi")
    val kadi:String,
    @SerializedName("mailAdres")
    val mailAdres:String,
    @SerializedName("parola")
    val parola:String,
    @SerializedName("tf")
    val tf:String,
    @SerializedName("text")
    val text:String
        )