package com.example.fruitapp.helper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.fruitapp.model.Fruit;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "DB_FRUITS";
    private static final int DB_VERSION = 1;

    private static final String TABLE_USER = "msUser";

    private static final String TABLE_USER_ID = "id";
    private static final String TABLE_USER_USERNAME = "username";
    private static final String TABLE_USER_PASSWORD = "password";

    private static final String TABLE_SESSION = "msSession";

    private static final String TABLE_SESSION_USERNAME = "username";

    private static final String TABLE_FRUIT = "msFruit";
    private static final String TABLE_FRUIT_ID = "id";
    private static final String TABLE_FRUIT_CODE = "code";
    private static final String TABLE_FRUIT_NAME = "name";
    private static final String TABLE_FRUIT_PRICE = "price";

    private static final String TABLE_CART = "trCart";
    private static final String TABLE_CART_ID = "id";
    private static final String TABLE_CART_USERNAME = "username";
    private static final String TABLE_CART_FRUIT_ID = "fruit_id";


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
        String queryCreateSessionTable = "CREATE TABLE " + TABLE_SESSION+ "("
                + TABLE_SESSION_USERNAME  + " TEXT" + ")";
        sqLiteDatabase.execSQL(queryCreateSessionTable);
        String queryCreateFruitTable = "CREATE TABLE " + TABLE_FRUIT+ "("
                + TABLE_FRUIT_ID + " INTEGER PRIMARY KEY,"
                + TABLE_FRUIT_CODE  + " TEXT, "
                + TABLE_FRUIT_NAME + " TEXT, "
                + TABLE_FRUIT_PRICE  + " NUMERIC "
                + ")";
        sqLiteDatabase.execSQL(queryCreateFruitTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        onCreate(sqLiteDatabase);
    }

    public void onStartApp(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SESSION);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FRUIT);
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

    public void SaveSession(String username){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_SESSION);

        String querySaveSession = "INSERT INTO " + TABLE_SESSION
                + "(" + TABLE_USER_USERNAME + ")"
                + " VALUES " + "(?)";

        db.execSQL(querySaveSession, new String[] {username});
    }

    public String GetSession(){
        String queryGetSession = "SELECT * FROM " + TABLE_SESSION;

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(queryGetSession, null);

        if (cursor.moveToFirst()){
            return String.valueOf(cursor.getString(0));
        }
        else {
            return "";
        }
    }

    public void ChangePassword(String Username, String Password){
        String queryChangePassword = "UPDATE " + TABLE_USER
                + " SET " + TABLE_USER_PASSWORD + "=?"
                + " WHERE " + TABLE_USER_USERNAME + "=?";

        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL(queryChangePassword, new String[]{Password, Username});
    }

    public void Logout(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_SESSION);
    }

    public void DeteleAccount(String username){
        SQLiteDatabase db = this.getWritableDatabase();
        String queryDeleteAccount = "DELETE FROM " + TABLE_USER
                + " WHERE " + TABLE_USER_USERNAME + "=?";
        db.execSQL(queryDeleteAccount, new String[] {username});
    }

    public void AddFruits(ArrayList<Fruit> fruitArrayList){
        SQLiteDatabase db = this.getWritableDatabase();

        for (Fruit fruit: fruitArrayList) {
            String queryInsertFruit = "INSERT INTO " + TABLE_FRUIT
                    + "(" + TABLE_FRUIT_ID + ","
                    + TABLE_FRUIT_CODE + ","
                    + TABLE_FRUIT_NAME + ","
                    + TABLE_FRUIT_PRICE +")"
                    + " VALUES " + "(?,?,?,?)";
            db.execSQL(queryInsertFruit, new Object[]{
                    fruit.getID(),
                    fruit.getCode(),
                    fruit.getName(),
                    fruit.getPrice(),
            });
        }
    }

    public ArrayList<Fruit> GetFruitsList(){
        String queryCountFruits = "SELECT * FROM " + TABLE_FRUIT;

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(queryCountFruits, null);

        ArrayList<Fruit> tempFruits = new ArrayList<Fruit>();
        if (cursor.moveToFirst()){
            do {
                Fruit fruit = new Fruit();
                fruit.setID(Integer.parseInt(cursor.getString(0)));
                fruit.setCode(cursor.getString(1));
                fruit.setName(cursor.getString(2));
                fruit.setPrice(cursor.getInt(3));
                tempFruits.add(fruit);
            } while (cursor.moveToNext());
        }

        return tempFruits;
    }

    public int GetCountFruits(){
        String queryCountFruits = "SELECT * FROM " + TABLE_FRUIT;

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(queryCountFruits, null);

        int count = 0;
        if (cursor.moveToFirst()){
            do {
                count += 1;
            } while (cursor.moveToNext());
        }

        return count;
    }
}
