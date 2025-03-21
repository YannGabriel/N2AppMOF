package com.example.n2appmof;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class dataCriate extends SQLiteOpenHelper {

    private static final String DATA_NAME = "mofdata.db";
    private static final int VERSION = 1;

    public dataCriate(Context context){
        super(context, DATA_NAME, null, VERSION);
    }

    @Override
    public void onCreate (SQLiteDatabase db){
        String createUserSql = "CREATE TABLE usuarios("
                + "id integer primary key autoincrement,"
                + "email text,"
                + "username text,"
                + "tel text,"
                + "password text)";
        db.execSQL(createUserSql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS usuarios");
        onCreate(db);
    }
}
