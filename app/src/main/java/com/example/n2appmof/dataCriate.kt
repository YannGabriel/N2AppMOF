package com.example.n2appmof

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class dataCriate(context: Context?) :
    SQLiteOpenHelper(context, DATA_NAME, null, VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        val createUserSql = ("CREATE TABLE usuarios("
                + "id integer primary key autoincrement,"
                + "email text,"
                + "username text,"
                + "tel text,"
                + "password text)")
        db.execSQL(createUserSql)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS usuarios")
        onCreate(db)
    }

    companion object {
        private const val DATA_NAME = "mofdata.db"
        private const val VERSION = 1
    }
}
