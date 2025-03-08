package com.example.n2appmof;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.activity.EdgeToEdge;
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


    }

    @Override
    public void onClick(View v) {

        String invalidateText = "Os dados inseridos não estão corretos ou não existem!";

        String validateText = "Acessando a conta!";

        String passwordTextValue = passwordText.getText().toString().trim();
        String userLoginTextValue = userLoginText.getText().toString().trim();

        if (passwordTextValue.isEmpty() || userLoginTextValue.isEmpty()){
            Toast.makeText(this, invalidateText, Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this, validateText, Toast.LENGTH_SHORT).show();
        }
    }
}