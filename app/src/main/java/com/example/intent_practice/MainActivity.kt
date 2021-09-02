package com.example.intent_practice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_nickname.*

class MainActivity : AppCompatActivity() {

    val REQUEST_FOR_NICKNAME = 1005

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toOtherActivity.setOnClickListener {

            val myIntent = Intent(this, Other_Activity::class.java)
            startActivity(myIntent)

        }

        sendMessageBtn.setOnClickListener {

            val myintent = Intent(this, Show_Message_Activity::class.java)
            myintent.putExtra("message", message.text.toString())
            startActivity(myintent)

        }

        changeNickname.setOnClickListener {

            val nicknameIntent = Intent(this, Nickname_Activity::class.java)
            startActivityForResult(nicknameIntent, REQUEST_FOR_NICKNAME)

        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == REQUEST_FOR_NICKNAME) {

            if(resultCode == RESULT_OK){

               val newNickname = data?.getStringExtra("nickname")
                nickName.text = newNickname

            }



        }

    }

}