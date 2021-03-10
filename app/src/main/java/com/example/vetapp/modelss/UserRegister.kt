package com.example.vetapp.modelss

import com.google.gson.annotations.SerializedName

data class UserRegister (
    @SerializedName("text")
    val text:String,
    @SerializedName("tf")
    val tf :String)