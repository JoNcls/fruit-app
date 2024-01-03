package com.example.fruitapp.helper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "DB_FRUITS";
    private static final int DB_VERSION = 1;

    private static final String TABLE_USER = "msUser";

    private static final String TABLE_USER_ID = "id";
    private static final String TABLE_USER_USERNAME = "username";
    private static final String TABLE_USER_PASSWORD = "password";

    public DBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String queryCreateUserTable = "CREATE TABLE " + TABLE_USER+ "("
                + TABLE_USER_ID + " INTEGER PRIMARY KEY,"
                + TABLE_USER_USERNAME  + " TEXT,"
                + TABLE_USER_PASSWORD + " TEXT" + ")";
        sqLiteDatabase.execSQL(queryCreateUserTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        onCreate(sqLiteDatabase);
    }

    public void onStartApp(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        onCreate(db);
    }

    public Boolean login(String username, String password){
        String queryLogin = "SELECT * FROM " + TABLE_USER
                + " WHERE " + TABLE_USER_USERNAME + "= ?"
                + " AND " + TABLE_USER_PASSWORD + "= ?";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(queryLogin, new String[] {username, password});

        if (cursor.moveToFirst()){
            return true;
        }
        else {
            return false;
        }
    }

    public void Register(String username, String password){
        String queryRegister = "INSERT INTO " + TABLE_USER
                + "(" + TABLE_USER_USERNAME + "," + TABLE_USER_PASSWORD + ")"
                + " VALUES " + "(?, ?)";

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(queryRegister, new String[] {username, password});
    }

    public String GetPassword(String username){
        String queryGetPassword = "SELECT * FROM " + TABLE_USER
                + " WHERE " + TABLE_USER_USERNAME + "= ?";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(queryGetPassword, new String[] {username});

        if (cursor.moveToFirst()){
            return String.valueOf(cursor.getString(2));
        }
        else {
            return "Username not found";
        }
    }
}
