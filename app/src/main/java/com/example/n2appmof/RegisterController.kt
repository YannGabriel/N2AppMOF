package com.example.n2appmof

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.util.Log

class RegisterController(context: Context?) {
    private var dataBase: SQLiteDatabase? = null
    private val data = dataCriate(context)

    fun insertData(email: String?, username: String?, tel: String?, password: String?): String {
        val result: Long
        dataBase = data.writableDatabase

        val values = ContentValues()
        values.put("email", email)
        values.put("tel", tel)
        values.put("password", password)
        values.put("username", username)

        result = dataBase!!.insert("usuarios", null, values)

        dataBase?.close()

        if (result == -1L) {
            Log.e("RegisterController", "Erro ao criar usuário")
            return "Erro ao criar usuário!"
        } else {
            Log.i("RegisterController", "Usuário criado com sucesso. ID: $result")
            return "Usuário foi cadastrado com sucesso!"
        }
    }
}
