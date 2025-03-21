package com.example.n2appmof;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;
public class LoginController {
    private SQLiteDatabase dataBase;
    private dataCriate data;

    public LoginController(Context context){
        data = new dataCriate(context);
    }

    public boolean checkUserData(String email, String password){
        boolean isValid = false;
        dataBase = data.getReadableDatabase();

        String sqlQuery = "SELECT * FROM usuarios WHERE email = ? AND password = ?";

        Cursor cursor = dataBase.rawQuery(sqlQuery, new String[]{email, password});

        if (cursor != null && cursor.moveToFirst()){
            isValid = true;
        }

        cursor.close();
        dataBase.close();

        return isValid;
    }
}
