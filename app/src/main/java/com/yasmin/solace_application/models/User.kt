package com.yasmin.solace_application.models

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("full_name")var Name: String,
    @SerializedName("user_id")var userId:String,
    @SerializedName("email")var email:String,
)
