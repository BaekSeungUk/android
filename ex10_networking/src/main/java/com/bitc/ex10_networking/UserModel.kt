package com.bitc.ex10_networking

import android.graphics.Bitmap
import com.google.gson.annotations.SerializedName

// DTO같은 클래스
data class UserModel(
    var id: String,
    @SerializedName("first_name")
    var firstName: String,
    var last_name: String,
    var avatar: String,
    var email: String
)
