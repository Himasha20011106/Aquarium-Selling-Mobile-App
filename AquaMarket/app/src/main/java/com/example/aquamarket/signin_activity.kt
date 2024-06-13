package com.example.aquamarket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class signin_activity : AppCompatActivity() {

    lateinit var signinBtn2: Button
    lateinit var signupBtn1: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        signinBtn2 = findViewById(R.id.signinBtn2)
        signupBtn1 = findViewById(R.id.signupBtn1)

        signinBtn2.setOnClickListener {
            // Create an Intent to navigate to the SignInActivity
            val intent = Intent(this, MainActivity::class.java)

            // Start the SignInActivity
            startActivity(intent)

            finish()

            Toast.makeText(this, "Redirecting to Home Page", Toast.LENGTH_SHORT).show()
        }

        signupBtn1.setOnClickListener {
            // Create an Intent to navigate to the SignInActivity
            val intent = Intent(this, SignupActivity::class.java)

            // Start the SignInActivity
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in, R.anim.slide_in)

            finish()
        }

    }
}