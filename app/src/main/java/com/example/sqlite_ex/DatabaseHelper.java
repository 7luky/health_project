package com.example.sqlite_ex;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    final static String DATABASE_NAME = "Health.db";  //데이터베이스 명
    final static String  TABLE_TRAINER = "trainer_table"; //테이블 명

    //테이블 항목
    public static final String COL_1 = "trainer_Num";
    public static final String COL_2 = "Name";
    public static final String COL_3 = "Phone";
    public static final String COL_4 = "Address";


    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_TRAINER + "(trainer_Num INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT NOT NULL, PHONE TEXT NOT NULL, ADDRESS TEXT NOT NULL)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TRAINER);
        onCreate(db);

    }

    //데이터베이스 추가하기 insert
    public boolean insertData(String name, String phone, String address){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, phone);
        contentValues.put(COL_4, address);
        long result = db.insert(TABLE_TRAINER, null, contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    //데이터베이스 삭제하기
    public Integer deleteData(String trainer_Num){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_TRAINER, "ID = ? ", new String[]{trainer_Num});
    }

    //데이터베이스 항목 읽어오기 Read
    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+ TABLE_TRAINER, null);
        return res;
    }

    //데이터베이스 수정하기
    public boolean updateData(String trainer_Num, String name, String phone, String address){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, trainer_Num);
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, phone);
        contentValues.put(COL_4, address);
        db.update(TABLE_TRAINER, contentValues, "ID = ?", new String[] { trainer_Num });
        return true;
    }
}
