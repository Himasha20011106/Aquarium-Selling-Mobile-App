package com.example.aquamarket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class BrandActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_brand)

        // Delayed execution of navigation to another activity after 3 seconds
        Handler().postDelayed({
            // Start the new activity
            startActivity(Intent(this, OnBoardingActivity1::class.java))

            // Close this activity
            finish()
        }, 1000)

    }
}