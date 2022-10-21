package com.yasmin.solace_application.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import android.widget.Button
import com.yasmin.solace_application.R
import com.yasmin.solace_application.databinding.ActivitySignUpBinding

class HomeActivity : AppCompatActivity() {
    lateinit var btnChat:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        btnChat=findViewById(R.id.btnChat)
        btnChat.setOnClickListener {
            val intent=Intent(this,AppCompatActivity::class.java)
            startActivity(intent)
        }


}
}

