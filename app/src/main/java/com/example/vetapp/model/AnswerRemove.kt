package com.example.vetapp.model

import com.google.gson.annotations.SerializedName

data class AnswerRemove(
    @SerializedName("text")
    val text:String,
    @SerializedName("tf")
    val tf:Boolean

)
