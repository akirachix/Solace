package com.yasmin.solace_application.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yasmin.solace_application.R

class ProfileFragment : AppCompatActivity() {
    override fun onCreate(
        inflater: LayoutInflater, container:ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return  inflater.inflate(R.layout.activity_profilefragment,container,false)
    }
}