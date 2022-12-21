package org.java.healthcare.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

/**
 * 05:28 PM
 * 21-12-2022
 */

public class Database extends SQLiteOpenHelper {

    public Database(@Nullable Context context, @Nullable String name,
                    @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //if the table is not exist then create
        String query="create table users(username text,email text,password text,phone text)";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void register(String username,String email,String password,String phone){
        ContentValues values=new ContentValues();
        values.put("username",username);
        values.put("email",email);
        values.put("password",password);
        values.put("phone",phone);
        SQLiteDatabase database=getWritableDatabase();
        database.insert("users",null,values);
        database.close();


    }

    public int login(String email,String password){
        int result=0;
        String []str=new String[2];
        str[0]=email;
        str[1]=password;
        SQLiteDatabase database=getReadableDatabase();
        Cursor cursor=database.rawQuery("select * from users where email=? and password=?",str);

        if (cursor.moveToFirst()){
            result=1;
        }
        return  result;
    }
}
