package com.example.aquamarket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class SupportActivity : AppCompatActivity() {

    lateinit var arrow: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_support)

        arrow = findViewById(R.id.arrow)

        arrow.setOnClickListener {
            // Create an Intent to navigate to the SignInActivity
            val intent = Intent(this, MainActivity::class.java)

            // Start the SignInActivity
            startActivity(intent)

            finish()

        }

    }
}