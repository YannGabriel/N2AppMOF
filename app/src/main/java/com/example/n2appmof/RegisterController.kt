package com.example.n2appmof;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class RegisterController  {
    private SQLiteDatabase  dataBase;
    private dataCriate data;

    public RegisterController(Context context){
        data = new dataCriate(context);
    }

    public String insertData (String email, String username, String tel, String password){
        ContentValues values;
        long result;
        dataBase = data.getWritableDatabase();

        values = new ContentValues();
        values.put("email", email);
        values.put("tel", tel);
        values.put("password", password);
        values.put("username", username);

        result = dataBase.insert("usuarios", null, values);

        dataBase.close();

        if (result == -1){
            Log.e("RegisterController", "Erro ao criar usuário");
            return "Erro ao criar usuário!";
        }
        else{
            Log.i("RegisterController", "Usuário criado com sucesso. ID: " + result);
            return "Usuário foi cadastrado com sucesso!";
        }

    }
}
