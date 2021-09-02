package com.example.intent_practice

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_nickname.*

class MainActivity : AppCompatActivity() {

    val REQUEST_FOR_NICKNAME = 1005

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        smsBtn.setOnClickListener {

            val inputPhoneNum = phoneNumEdt.text.toString()
            val myUri = Uri.parse("smsto:${inputPhoneNum}")
            val myIntent = Intent(Intent.ACTION_SENDTO, myUri)
            myIntent.putExtra("sms_body", "미리 내용 입력")
            startActivity(myIntent)

        }

        callBtn.setOnClickListener {

            val inputPhoneNum = phoneNumEdt.text.toString()

            val myUri = Uri.parse("tel:${inputPhoneNum}")

            val myIntent = Intent(Intent.ACTION_CALL, myUri)

            startActivity(myIntent)

        }


//        DIAL 액션 에제

        dialBtn.setOnClickListener {

//            phoneNumEdt에 입력한 전화번호를 받아서 > 해당 번호에 전화 연결

            val inputPhoneNum = phoneNumEdt.text.toString()

            val myUri = Uri.parse("tel:${inputPhoneNum}")

            val myIntent = Intent(Intent.ACTION_DIAL, myUri)

            startActivity(myIntent)
        }

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