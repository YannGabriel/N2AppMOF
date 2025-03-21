package com.example.n2appmof;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.activity.EdgeToEdge;
import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText passwordText, userLoginText;
    Button registerButton, loginButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        passwordText = findViewById(R.id.passwordLoginText);
        userLoginText = findViewById(R.id.userLoginText);

        registerButton = findViewById(R.id.registerButton);
        loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(this);

        registerButton.setOnClickListener(v ->{
            RegisterFragment resgisterFragment = new RegisterFragment();

            resgisterFragment.show(getSupportFragmentManager(), resgisterFragment.getTag());
        });

    }

    @Override
    public void onClick(View v) {

        String passwordTextValue = passwordText.getText().toString().trim();
        String userLoginTextValue = userLoginText.getText().toString().trim();

       if (userLoginTextValue.isEmpty() || passwordTextValue.isEmpty()){
           Toast.makeText(this, "Por favor, preencha todos os campos", Toast.LENGTH_SHORT).show();
           return;
       }

       LoginController loginController = new LoginController(this);
       boolean isValid = loginController.checkUserData(userLoginTextValue, passwordTextValue);

        if (isValid) {

            Toast.makeText(this, "Login bem-sucedido!", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Nome de usuário ou senha incorretos", Toast.LENGTH_SHORT).show();
        }
    }

}