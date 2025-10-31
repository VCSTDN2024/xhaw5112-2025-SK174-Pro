package com.example.empoweringthenationapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.google.android.material.textfield.TextInputEditText

class Enquiry : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navView: NavigationView
    private lateinit var btnBurger: ImageButton
    private lateinit var btnSubmit: Button

    private lateinit var name: EditText
    private lateinit var surname: EditText
    private lateinit var email: EditText
    private lateinit var phone: EditText
    private lateinit var message: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enquiry)

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


        name = findViewById(R.id.etName)
        surname = findViewById(R.id.etSurname)
        email = findViewById(R.id.etEmail)
        phone = findViewById(R.id.etPhone)
        message = findViewById(R.id.etMessage)
        btnSubmit = findViewById(R.id.btnSubmit)


        btnSubmit.setOnClickListener {
            if (validateForm()) {
                sendEmail()
                Toast.makeText(this, "Enquiry submitted successfully!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    //Form Component fro Validation of Submitting Form Enquiry//
    private fun validateForm(): Boolean {
        var isValid = true

        fun EditText.requireField(errorMsg: String): Boolean {
            if (text.isBlank()) {
                error = errorMsg
                isValid = false
            }
            return isValid
        }

        name.requireField("Please enter your name")
        surname.requireField("Please enter your last name")
        email.requireField("Please enter your email address")
        phone.requireField("Please enter your phone number")

        if (message.text.isNullOrBlank()) {
            message.error = "Message is required"
            isValid = false
        }

        return isValid
    }


    //Email is send for Validation form//
    private fun sendEmail() {
        val subject = "Enquiry from ${name.text} ${surname.text}"
        val body = """
            Name: ${name.text}
            Surname: ${surname.text}
            Email: ${email.text}
            Phone: ${phone.text}
            Message: ${message.text}
        """.trimIndent()

        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:")
            putExtra(Intent.EXTRA_EMAIL, arrayOf("your-email@gmail.com"))
            putExtra(Intent.EXTRA_SUBJECT, subject)
            putExtra(Intent.EXTRA_TEXT, body)
        }


        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
            Toast.makeText(this, "Enquiry submitted successfully!", Toast.LENGTH_SHORT).show()

        }
    }
}
