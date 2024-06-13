package com.example.aquamarket

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.MenuItem
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.aquamarket.adapters.ImageAdapter
import com.example.aquamarket.bottom_fragment.AccountFragment
import com.example.aquamarket.bottom_fragment.CartFragment
import com.example.aquamarket.bottom_fragment.CategoryFragment
import com.example.aquamarket.bottom_fragment.HomeFragment
import com.example.aquamarket.models.ImageItem
import com.example.aquamarket.nav_fragment.SettingFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.UUID

class MainActivity : AppCompatActivity() {

    private lateinit var viewpager2: ViewPager2
    private lateinit var adapter: ImageSliderAdapter
    private lateinit var slideDot: LinearLayout
    private lateinit var pageChangeListner: ViewPager2.OnPageChangeCallback
    private lateinit var toggle: ActionBarDrawerToggle


    //private lateinit var drawerLayout: DrawerLayout
    private lateinit var bottomNavigationView: BottomNavigationView

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            bottomNavigationView = findViewById(R.id.bottomNavigationView)

            bottomNavigationView.setOnItemReselectedListener { menuItem ->
                when(menuItem.itemId){
                    R.id.nav_home -> {
                        replaceFragment(HomeFragment())
                        true
                    }
                    R.id.nav_account -> {
                        replaceFragment(AccountFragment())
                        true
                    }
                    R.id.nav_category -> {
                        replaceFragment(CategoryFragment())
                        true
                    }
                    R.id.nav_cart -> {
                        replaceFragment(CartFragment())
                        true
                    }
                    else -> {

                    }
                }
            }
            replaceFragment(HomeFragment())



    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.frame_layout, fragment).commit()
    }


    override fun onDestroy() {
        super.onDestroy()
        viewpager2.unregisterOnPageChangeCallback(pageChangeListner)
    }
}
