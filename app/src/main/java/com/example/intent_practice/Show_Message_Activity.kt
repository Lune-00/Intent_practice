package com.example.intent_practice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_show_message2.*

class Show_Message_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_message2)

        val myIntent = intent.getStringExtra("message")
        showMessageTxt.text = myIntent

    }
}