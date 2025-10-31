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

class Quote : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navView: NavigationView
    private lateinit var btnBurger: ImageView
    private lateinit var btnSubmit: Button

    private lateinit var name: EditText
    private lateinit var lastName: EditText
    private lateinit var email: EditText
    private lateinit var phone: EditText
    private lateinit var message: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quote)


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
        lastName = findViewById(R.id.etLastName)
        email = findViewById(R.id.etEmailAddress)
        phone = findViewById(R.id.etPhone)
        message = findViewById(R.id.etMessage)
        btnSubmit = findViewById(R.id.btnsubmitQuote)


        btnSubmit.setOnClickListener {
            if (validateForm()) {
                sendEmail()
                Toast.makeText(this, "Quote submitted successfully!", Toast.LENGTH_SHORT).show()
            }
        }
    }


    private fun validateForm(): Boolean {
        var isValid = true

        fun EditText.requireField(errorMsg: String): Boolean {
            if (text.isBlank()) {
                error = errorMsg
                isValid = false
            }
            return isValid
        }

        name.requireField("Please Enter Your Name")
        lastName.requireField("Please Enter Your Last Name")
        email.requireField("Please Enter Your Email address")
        phone.requireField("Please Enter Your Phone Number")

        if (message.text.isNullOrBlank()) {
            message.error = "Message is required"
            isValid = false
        }

        return isValid
    }


    private fun sendEmail() {
        val subject = "Quote Request from ${name.text} ${lastName.text}"
        val body = """
            Name: ${name.text}
            Last Name: ${lastName.text}
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
            Toast.makeText(this, "Quote submitted successfully!", Toast.LENGTH_SHORT).show()

        }
    }
}
