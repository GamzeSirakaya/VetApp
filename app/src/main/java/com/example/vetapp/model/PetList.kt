package com.example.vetapp.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class PetList(
    val petid: String,
    val petisim:String,
    val petresim:String,
    val petcins:String,
    val pettur:String,
    val tf:Boolean

)

