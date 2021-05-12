package com.example.vetapp.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class PetList(
    @SerializedName("petid")
    var petId: String,
    @SerializedName("petisim")
    var petIsim: String,
    @SerializedName("petresim")
    var petResim: String,
    @SerializedName("petcins")
    var petCins: String,
    @SerializedName("pettur")
    var petTur: String,
    @SerializedName("tf")
    var tf: Boolean

)

