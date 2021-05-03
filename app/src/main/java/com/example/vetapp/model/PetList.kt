package com.example.vetapp.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class PetList(
    var petid: String,
    var petisim:String,
    var petresim:String,
    var petcins:String,
    var pettur:String,
    var tf:Boolean

)

