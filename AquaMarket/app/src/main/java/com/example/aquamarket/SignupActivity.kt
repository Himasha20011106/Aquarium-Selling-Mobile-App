package com.example.aquamarket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SignupActivity : AppCompatActivity() {

    lateinit var signupBtn2: Button
    lateinit var signinBtn1: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        signupBtn2 = findViewById(R.id.signupBtn2)
        signinBtn1 = findViewById(R.id.signinBtn1)

        signupBtn2.setOnClickListener {
            // Create an Intent to navigate to the SignInActivity
            val intent = Intent(this, signin_activity::class.java)

            // Start the SignInActivity
            startActivity(intent)

            finish()
        }

        signinBtn1.setOnClickListener {
            // Create an Intent to navigate to the SignInActivity
            val intent = Intent(this, signin_activity::class.java)

            // Start the SignInActivity
            startActivity(intent)
            overridePendingTransition(R.anim.slide_out, R.anim.slide_out)

            finish()
        }

    }
}