package com.example.aquamarket.bottom_fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.aquamarket.MainActivity
import com.example.aquamarket.ProfileviewActivity
import com.example.aquamarket.R
import com.example.aquamarket.SupportActivity
import com.example.aquamarket.signin_activity

class AccountFragment : Fragment() {

    lateinit var profile: View
    lateinit var support: View
    lateinit var logout: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        profile = view.findViewById(R.id.view1)

        profile.setOnClickListener {
            // Create an Intent to navigate to the SignInActivity
            val intent = Intent(requireContext(), ProfileviewActivity::class.java)

            // Start the SignInActivity
            startActivity(intent)
        }

        support = view.findViewById(R.id.view6)

        support.setOnClickListener {
            // Create an Intent to navigate to the SignInActivity
            val intent = Intent(requireContext(), SupportActivity::class.java)

            // Start the SignInActivity
            startActivity(intent)
        }

        logout = view.findViewById(R.id.logout)

        logout.setOnClickListener {
            // Create an Intent to navigate to the SignInActivity
            val intent = Intent(requireContext(), signin_activity::class.java)

            // Start the SignInActivity
            startActivity(intent)
        }

        return view
    }
}
