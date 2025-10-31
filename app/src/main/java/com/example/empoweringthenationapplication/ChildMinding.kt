package com.example.empoweringthenationapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class ChildMinding : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var btnBurger: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_child_minding)

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
