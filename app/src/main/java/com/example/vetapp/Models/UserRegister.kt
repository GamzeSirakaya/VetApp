package com.example.vetapp.Models

import com.google.gson.annotations.SerializedName

data class UserRegister (
    @SerializedName("text")
    val text:String,
    @SerializedName("tf")
    val tf :String)