package com.example.n2appmof

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomePage : AppCompatActivity() {
    var activitysButton: Button? = null
    var iaButton: Button? = null

    var activitysImageHome: ImageView? = null
    var addActivitImageHome: ImageView? = null
    var userImageHome: ImageView? = null

    var userNameHomePage: TextView? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.enableEdgeToEdge()
        setContentView(R.layout.home_page)
        ViewCompat.setOnApplyWindowInsetsListener(
            findViewById(R.id.homePageRoot)
        ) { v: View, insets: WindowInsetsCompat ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val userEmail = intent.getStringExtra("email_usuario")

        val database = openOrCreateDatabase("mofdata.db", MODE_PRIVATE, null)

        val userEmailConsult = userEmail
        var userName = ""

        val cursor = database.rawQuery(
            "SELECT username FROM usuarios WHERE email = ?",
            arrayOf(userEmailConsult)
        )

        if (cursor.moveToFirst()) {
            userName = cursor.getString(0)
        }

        cursor.close()
        database.close()


        userNameHomePage = findViewById(R.id.userNameHome)
        userNameHomePage?.setText(userName)

        //criação da conexão dos botões da Home
        activitysButton = findViewById(R.id.activityHomeButton)
        iaButton = findViewById(R.id.iaButtonTarget)

        //botões headerHome
        activitysImageHome = findViewById(R.id.activitysImageTargetHome)
        addActivitImageHome = findViewById(R.id.addActivityImageTargetHome)
        userImageHome = findViewById(R.id.userImageTargetHome)

        activitysImageHome?.setOnClickListener(View.OnClickListener {
            val activitysPage = Intent(
                this@HomePage,
                ActivitysPage::class.java
            )
            startActivity(activitysPage)
        })
    }
}

