package com.example.empoweringthenationapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class Courses : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var btnBurger: ImageView

    private lateinit var btnFirstAid: Button
    private lateinit var btnSewing: Button
    private lateinit var btnLandscaping: Button
    private lateinit var btnLifeSkills: Button
    private lateinit var btnChildMinding: Button
    private lateinit var btnCooking: Button
    private lateinit var btnGardenMaintenance: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_courses)

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
        btnBurger = findViewById(R.id.btnBurger)
        val navView: NavigationView = findViewById(R.id.navView)

        btnBurger.setOnClickListener {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START)
            } else {
                drawerLayout.openDrawer(GravityCompat.START)
            }
        }

        //Navigation Drawer//
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


            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true

        }

        btnFirstAid = findViewById(R.id.btnFirstAid)
        btnSewing = findViewById(R.id.btnSewing)
        btnLandscaping = findViewById(R.id.btnLandScaping)
        btnLifeSkills = findViewById(R.id.btnLifeSkills)
        btnCooking = findViewById(R.id.btnCooking)
        btnChildMinding = findViewById(R.id.btnChildMinding)
        btnGardenMaintenance = findViewById(R.id.btnGardenMaintenance)

        //When Clicked Navigates to the Selected Course Screen//
        btnFirstAid.setOnClickListener {
            startActivity(Intent(this, FirstAid::class.java))
        }

        btnSewing.setOnClickListener {
            startActivity(Intent(this, sewing::class.java))
        }

        btnLandscaping.setOnClickListener {
            startActivity(Intent(this, landscaping::class.java))
        }

        btnLifeSkills.setOnClickListener {
            startActivity(Intent(this, lifeskills::class.java))
        }

        btnCooking.setOnClickListener {
            startActivity(Intent(this, Cooking::class.java))
        }

        btnChildMinding.setOnClickListener {
            startActivity(Intent(this, ChildMinding::class.java))
        }

        btnGardenMaintenance.setOnClickListener {
            startActivity(Intent(this, GardenMaintenance::class.java))
        }

    }
}







