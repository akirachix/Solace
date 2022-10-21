package com.yasmin.solace_application.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.yasmin.solace_application.R

//class ProfileFragment : AppCompatActivity() {
//    override fun onCreate(
//        inflater: LayoutInflater, container:ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        return  inflater.inflate(R.layout.activity_profilefragment,container,false)
//    }
//}
class ProfileFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//         Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_profilefragment, container, false)
    }
}