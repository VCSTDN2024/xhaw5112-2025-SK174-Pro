package com.example.empoweringthenationapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import android.widget.ImageButton

class AboutUs : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var burgerBtn: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_us)

         //Navigation declarations for social media Buttons//
        val btnInstagram: ImageButton = findViewById(R.id.btnInstagram)
        val btnTiktok: ImageButton = findViewById(R.id.btnTiktok)



        btnInstagram.setOnClickListener {
            val InstagramUrl = "https://www.instagram.com/enpoweringthenation_?igsh=N3czc25meTU5dm43"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(InstagramUrl))
            startActivity(intent)

        }

        btnTiktok.setOnClickListener {
            val TiktokUrl = "https://www.tiktok.com/@user257274873945061?_t=ZM-8zpFXSlxLIm&_r=1"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(TiktokUrl))
            startActivity(intent)
        }


        //drawerLayout declared//
        drawerLayout = findViewById(R.id.drawerLayout)
        burgerBtn = findViewById(R.id.btnBurger)
        val navView: NavigationView = findViewById(R.id.navView)

        burgerBtn.setOnClickListener {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START)
            } else {
                drawerLayout.openDrawer(GravityCompat.START)
            }
        }

        //Navigation declarations for Navigation Drawer//
        navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> {
                    startActivity(Intent(this, MainActivity::class.java))
                    true

                }

                R.id.nav_about -> {
                    startActivity(Intent(this, AboutUs::class.java))
                    true

                }

                R.id.nav_prices -> {
                    startActivity(Intent(this, DiscountActivity::class.java))

                }

                R.id.nav_enquire -> {
                    startActivity(Intent(this, Enquiry::class.java))
                    true

                }

                R.id.nav_quote -> {
                    startActivity(Intent(this, Quote::class.java))
                    true

                }

                R.id.nav_courses -> {
                    startActivity(Intent(this, Courses::class.java))
                    true

                }
                R.id.nav_offices -> startActivity(Intent(this,offices::class.java))
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true


        }
    }
}
