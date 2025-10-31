package com.example.empoweringthenationapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var burgerBtn: ImageButton
    private lateinit var navView: NavigationView

    private lateinit var homepageBtn: Button
    private lateinit var aboutBtn: Button
    private lateinit var btnPrices: Button
    private lateinit var enquireBtn: Button
    private lateinit var quoteBtn: Button
    private lateinit var coursesBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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



        drawerLayout = findViewById(R.id.drawerLayout)
        burgerBtn = findViewById(R.id.btnBurger)
        navView = findViewById(R.id.navView)

        burgerBtn.setOnClickListener {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START)
            } else {
                drawerLayout.openDrawer(GravityCompat.START)
            }
        }

        navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> homepageBtn.performClick()
                R.id.nav_about -> aboutBtn.performClick()
                R.id.nav_prices -> btnPrices.performClick()
                R.id.nav_enquire -> enquireBtn.performClick()
                R.id.nav_quote -> quoteBtn.performClick()
                R.id.nav_courses -> coursesBtn.performClick()

            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }


        homepageBtn = findViewById(R.id.btnHomePage)
        aboutBtn = findViewById(R.id.btnAbout)
        btnPrices = findViewById(R.id.btnPrices)
        enquireBtn = findViewById(R.id.btnEnquire)
        quoteBtn = findViewById(R.id.btnQuote)
        coursesBtn = findViewById(R.id.btnCourses)

        homepageBtn.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        aboutBtn.setOnClickListener {
            startActivity(Intent(this, AboutUs::class.java))
        }


        enquireBtn.setOnClickListener {
            startActivity(Intent(this, Enquiry::class.java))
        }

        quoteBtn.setOnClickListener {
            startActivity(Intent(this, Quote::class.java))
        }

        btnPrices.setOnClickListener {
            startActivity(Intent(this,DiscountActivity::class.java))
        }

        coursesBtn.setOnClickListener {
            startActivity(Intent(this, Courses::class.java))
        }

    }
}