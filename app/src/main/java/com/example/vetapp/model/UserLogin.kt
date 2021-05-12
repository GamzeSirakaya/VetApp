package com.example.vetapp.model

import com.google.gson.annotations.SerializedName

data class UserLogin (
    @SerializedName("id")
    val id:Int,
    @SerializedName("kadi")
    var kadi:String,
    @SerializedName("mailAdres")
    var mailAdres:String,
    @SerializedName("parola")
    var parola:String,
    @SerializedName("tf")
    var tf:String,
    @SerializedName("text")
    var text:String
        )