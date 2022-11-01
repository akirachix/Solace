package com.yasmin.solace_application.models

import com.google.gson.annotations.SerializedName

data class
RegisterRequest(
    @SerializedName("full_name")var name: String,
    var email:String,
    var password:String,
)
