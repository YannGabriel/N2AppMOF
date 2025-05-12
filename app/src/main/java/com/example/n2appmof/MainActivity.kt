package com.example.n2appmof

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {
    var passwordText: EditText? = null
    var userLoginText: EditText? = null
    var registerButton: Button? = null
    var loginButton: Button? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(
            findViewById(R.id.main)
        ) { v: View, insets: WindowInsetsCompat ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        passwordText = findViewById(R.id.passwordLoginText)
        userLoginText = findViewById(R.id.userLoginText)

        registerButton = findViewById(R.id.registerButton)
        loginButton = findViewById(R.id.loginButton)
        loginButton?.setOnClickListener(this)

        registerButton?.setOnClickListener(View.OnClickListener { v: View? ->
            val resgisterFragment = RegisterFragment()
            resgisterFragment.show(supportFragmentManager, resgisterFragment.tag)
        })
    }

    override fun onClick(v: View) {
        val passwordTextValue = passwordText!!.text.toString().trim { it <= ' ' }
        val userLoginTextValue = userLoginText!!.text.toString().trim { it <= ' ' }

        if (userLoginTextValue.isEmpty() || passwordTextValue.isEmpty()) {
            Toast.makeText(this, "Por favor, preencha todos os campos", Toast.LENGTH_SHORT).show()
            return
        }

        val loginController = LoginController(this)
        val isValid = loginController.checkUserData(userLoginTextValue, passwordTextValue)

        if (isValid) {
            Toast.makeText(this, "Login bem-sucedido!", Toast.LENGTH_SHORT).show()
            val intent = Intent(
                this@MainActivity,
                HomePage::class.java
            )
            intent.putExtra("email_usuario", userLoginTextValue)
            startActivity(intent)
        } else {
            Toast.makeText(this, "Nome de usuário ou senha incorretos", Toast.LENGTH_SHORT).show()
        }
    }
}