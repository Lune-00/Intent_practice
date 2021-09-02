package com.example.intent_practice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_nickname.*

class Nickname_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nickname)

        inputNicknameBtn.setOnClickListener {

            val nickname = inputNickname.text.toString()

            val resultIntent = Intent()
            resultIntent.putExtra("nickname", nickname)
            setResult(RESULT_OK, resultIntent)
            finish()


        }

    }
}