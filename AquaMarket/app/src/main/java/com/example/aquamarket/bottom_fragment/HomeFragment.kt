package com.example.aquamarket.bottom_fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.example.aquamarket.MainActivity
import com.example.aquamarket.ProfileviewActivity
import com.example.aquamarket.R
import com.example.aquamarket.adapters.ImageAdapter
import com.example.aquamarket.models.ImageItem
import java.util.UUID


class HomeFragment : Fragment() {

    private lateinit var viewpager2: ViewPager2
    private lateinit var slideDot: LinearLayout
    private lateinit var pageChangeListner: ViewPager2.OnPageChangeCallback
    private lateinit var viewprofile: View
    private val params = LinearLayout.LayoutParams(
        LinearLayout.LayoutParams.WRAP_CONTENT,
        LinearLayout.LayoutParams.WRAP_CONTENT
    ).apply {
        setMargins(8, 0, 8, 0)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.home_vertical_scrollview, container, false)


        viewprofile = view.findViewById(R.id.view_profile)

        viewprofile.setOnClickListener {
            // Create an Intent to navigate to the SignInActivity
            val intent = Intent(requireContext(), ProfileviewActivity::class.java)

            // Start the SignInActivity
            startActivity(intent)

        }


        // Initialize ViewPager2
        viewpager2 = view.findViewById(R.id.viewPager)

        // Create list of images
        val imageList = arrayListOf(
            ImageItem(
                UUID.randomUUID().toString(),
                "android.resource://" + requireActivity().packageName + "/" + R.drawable.imageslider1
            ),
            ImageItem(
                UUID.randomUUID().toString(),
                "android.resource://" + requireActivity().packageName + "/" + R.drawable.imageslider2
            ),
            ImageItem(
                UUID.randomUUID().toString(),
                "android.resource://" + requireActivity().packageName + "/" + R.drawable.onboarding3
            ),
            ImageItem(
                UUID.randomUUID().toString(),
                "android.resource://" + requireActivity().packageName + "/" + R.drawable.imageslider4
            ),
            ImageItem(
                UUID.randomUUID().toString(),
                "android.resource://" + requireActivity().packageName + "/" + R.drawable.imageslider5
            )
        )


        // Set up adapter for ViewPager2
        val imageAdapter = ImageAdapter()
        viewpager2.adapter = imageAdapter
        imageAdapter.submitList(imageList)

        // Initialize dot indicators LinearLayout
        slideDot = view.findViewById(R.id.slideDot)

        // Create and add dot indicators programmatically
        val dotsImage = Array(imageList.size) { ImageView(requireContext()) }
        dotsImage.forEach {
            it.setImageResource(R.drawable.non_active_dot)
            slideDot.addView(it, params)
        }
        // default first dot selected
        dotsImage[0].setImageResource(R.drawable.active_dot)

        // Set up page change listener for ViewPager2
        pageChangeListner = object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                dotsImage.forEachIndexed { index, imageView ->
                    imageView.setImageResource(if (position == index) R.drawable.active_dot else R.drawable.non_active_dot)
                }
                super.onPageSelected(position)
            }
        }
        viewpager2.registerOnPageChangeCallback(pageChangeListner)

        return view
    }
}