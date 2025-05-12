package com.example.n2appmof;
import com.example.n2appmof.R;


import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import android.database.Cursor;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomePage extends AppCompatActivity {



    TextView userNameHomePage;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.home_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.homePageRoot), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String userEmail = getIntent().getStringExtra("email_usuario");

        SQLiteDatabase database = openOrCreateDatabase("mofdata.db", MODE_PRIVATE, null);

        String userEmailConsult = userEmail;
        String userName = "";

        Cursor cursor = database.rawQuery("SELECT username FROM usuarios WHERE email = ?", new String[]{userEmailConsult});

        if (cursor.moveToFirst()) {
            userName = cursor.getString(0);
        }

        cursor.close();
        database.close();


        userNameHomePage = findViewById(R.id.userNameHome);
        userNameHomePage.setText(userName);

    }

}

