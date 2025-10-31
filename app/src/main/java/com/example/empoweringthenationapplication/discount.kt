package com.example.empoweringthenationapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class DiscountActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navView: NavigationView
    private lateinit var btnBurger: ImageButton

    private lateinit var firstAid: CheckBox
    private lateinit var sewing: CheckBox
    private lateinit var lifeSkills: CheckBox
    private lateinit var landscaping: CheckBox
    private lateinit var cooking: CheckBox
    private lateinit var gardenMaintenance: CheckBox
    private lateinit var childMinding: CheckBox

    private lateinit var discountBox: TextView
    private lateinit var calculateBtn: Button
    private lateinit var resetBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_discount)

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

        //Navigation Drawer declarations//
        drawerLayout = findViewById(R.id.drawerLayout)
        btnBurger = findViewById(R.id.btnBurger)
        navView = findViewById(R.id.navView)

        // Navigation Drawer toggle//
        btnBurger.setOnClickListener {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START)
            } else {
                drawerLayout.openDrawer(GravityCompat.START)
            }
        }

        navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> startActivity(Intent(this, MainActivity::class.java))
                R.id.nav_about -> startActivity(Intent(this, AboutUs::class.java))
                R.id.nav_prices -> startActivity(Intent(this, DiscountActivity::class.java))
                R.id.nav_enquire -> startActivity(Intent(this, Enquiry::class.java))
                R.id.nav_quote -> startActivity(Intent(this, Quote::class.java))
                R.id.nav_courses -> startActivity(Intent(this, Courses::class.java))
                R.id.nav_offices -> startActivity(Intent(this, offices::class.java))
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }

        // Initialize checkboxes and buttons//
        firstAid = findViewById(R.id.firstAid)
        sewing = findViewById(R.id.sewing)
        lifeSkills = findViewById(R.id.lifeSkills)
        landscaping = findViewById(R.id.landscaping)
        cooking = findViewById(R.id.cooking)
        gardenMaintenance = findViewById(R.id.gardenMaintenance)
        childMinding = findViewById(R.id.childMinding)

        discountBox = findViewById(R.id.discountBox)
        calculateBtn = findViewById(R.id.calculateBtn)
        resetBtn = findViewById(R.id.resetBtn)

        // Calculate Discount Button//
        calculateBtn.setOnClickListener {
            calculateTotalCost()
        }

        // Reset Button //
        resetBtn.setOnClickListener {
            firstAid.isChecked = false
            sewing.isChecked = false
            lifeSkills.isChecked = false
            landscaping.isChecked = false
            cooking.isChecked = false
            gardenMaintenance.isChecked = false
            childMinding.isChecked = false
            discountBox.text = ""
        }
    }

    // Calculates total cost and applies discount based on number of courses selected//
    private fun calculateTotalCost() {
        var total = 0
        var courseCount = 0

        val sixMonthCourses = listOf(
            firstAid to 1500,
            sewing to 1500,
            lifeSkills to 1500,
            landscaping to 1500
        )
        val sixWeekCourses = listOf(
            cooking to 750,
            gardenMaintenance to 750,
            childMinding to 750
        )

        sixMonthCourses.forEach { (checkbox, price) ->
            if (checkbox.isChecked) {
                total += price
                courseCount++
            }
        }

        sixWeekCourses.forEach { (checkbox, price) ->
            if (checkbox.isChecked) {
                total += price
                courseCount++
            }
        }

        val discount = when (courseCount) {
            0,1 -> 0.0
            2 -> 0.05
            3 -> 0.10
            else -> 0.15
        }

        val discountAmount = total * discount
        val discountedTotal = total - discountAmount

        //Text Displays in TextBox after calculation//
        discountBox.text = buildString {
            append("Courses Selected: $courseCount\n")
            append("Total Before Discount: R$total\n")
            append("Discount Applied: ${(discount * 100).toInt()}% (R${discountAmount.toInt()})\n")
            append("Final Payable Amount: R${discountedTotal.toInt()}")
        }
    }
}
