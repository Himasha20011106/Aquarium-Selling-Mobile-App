package com.example.aquamarket

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator

class OnBoardingActivity1 : AppCompatActivity() {

    private val onBoardingPageChangeCallback = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)

            when (position) {
                0 -> {
                    skipBtn.text = "SKIP >>>"
                    skipBtn.visible()
                    nextBtn.visible()
                    imageView3.invisible()
                    imageView2.invisible()
                    imageView1.visible()
                    getStarted.gone()
                }
                1 -> {
                    skipBtn.text = "SKIP >>>"
                    skipBtn.visible()
                    nextBtn.visible()
                    imageView3.invisible()
                    imageView2.visible()
                    imageView1.invisible()
                    getStarted.gone()
                }
                2 -> {
                    skipBtn.text = "SKIP >>>"
                    skipBtn.gone()
                    getStarted.visible()
                    imageView3.visible()
                    imageView2.invisible()
                    imageView1.invisible()
                    nextBtn.gone()
                }
                else -> {
                    skipBtn.text = "SKIP >>>"
                    skipBtn.visible()
                    nextBtn.visible()
                }
            }
        }
    }

    private val pagerList = arrayListOf(
        Page("Find Fantastic Aquarium\n" +
                "At The Best Price ",
            R.drawable.icon,
            "You can choose any type of aquarium \n" +
                    "you want at one place for a fantastic\n" +
                    "price.",
            "#FFFFFFFF"),
        Page("Create your ideal aquatic space \n" + "with us",
            R.drawable.onboarding2,
            "You can choose any type of aquarium \n" +
                    "you want at one place for a fantastic\n" +
                    "price.",
            "#FFFFFFFF"),
        Page("Convenient Doorstep \n" +
                "Aquarium Setup Delivery",
            R.drawable.icon,
            "Enjoy hassle-free delivery right to your\n" +
                    "doorstep for a convenient aquarium \n" +
                    "setup experience.",
            "#FFFFFFFF"),
    )

    lateinit var onBoardingViewPager2: ViewPager2
    lateinit var imageView3: ImageView
    lateinit var imageView2: ImageView
    lateinit var imageView1: ImageView
    lateinit var skipBtn: Button
    lateinit var nextBtn: Button
    lateinit var getStarted: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding1)

        onBoardingViewPager2 = findViewById(R.id.onBoardingViewPager2)
        skipBtn = findViewById(R.id.skipBtn)
        nextBtn = findViewById(R.id.nextBtn)
        getStarted = findViewById(R.id.additionalButton)
        imageView3 = findViewById(R.id.onboarding3Img)
        imageView2 = findViewById(R.id.onboarding2Img)
        imageView1 = findViewById(R.id.onboarding1Img)

        onBoardingViewPager2.apply {
            adapter = OnBoardingAdapter(this@OnBoardingActivity1, pagerList)
            registerOnPageChangeCallback(onBoardingPageChangeCallback)
            (getChildAt(0) as RecyclerView).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
        }


        val additionalButton = findViewById<Button>(R.id.additionalButton)
        additionalButton.setOnClickListener {
            val intent = Intent(this@OnBoardingActivity1,SignupActivity ::class.java)
            startActivity(intent)

            Toast.makeText(this@OnBoardingActivity1, "Redirecting to registration!", Toast.LENGTH_SHORT).show()
        }

        val tabLayout = findViewById<com.google.android.material.tabs.TabLayout>(R.id.tabLayout)
        TabLayoutMediator(tabLayout, onBoardingViewPager2) { tab, position -> }.attach()


        skipBtn.setOnClickListener {
            signupScreenIntent()
        }

        nextBtn.setOnClickListener {
            if (onBoardingViewPager2.currentItem >= 0) {
                onBoardingViewPager2.currentItem += 1
            }
        }
    }

    override fun onDestroy() {
        onBoardingViewPager2.unregisterOnPageChangeCallback(onBoardingPageChangeCallback)
        super.onDestroy()
    }

    private fun signupScreenIntent() {
        val signupIntent = Intent(this, SignupActivity::class.java)
        startActivity(signupIntent)
    }


}
