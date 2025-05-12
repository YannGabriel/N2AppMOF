package com.example.n2appmof

import android.content.Context
import android.database.sqlite.SQLiteDatabase

class LoginController(context: Context?) {
    private var dataBase: SQLiteDatabase? = null
    private val data = dataCriate(context)

    fun checkUserData(email: String, password: String): Boolean {
        var isValid = false
        dataBase = data.readableDatabase

        val sqlQuery = "SELECT * FROM usuarios WHERE email = ? AND password = ?"

        val cursor = dataBase?.rawQuery(sqlQuery, arrayOf(email, password))

        if (cursor != null && cursor.moveToFirst()) {
            isValid = true
        }

        cursor!!.close()
        dataBase?.close()

        return isValid
    }
}
