package com.example.sliderexample;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DBCards extends SQLiteOpenHelper {
    private static DBCards sInstance;

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "cardsDB";

    public static final String TABLE_CARDS = "cards";
    public static final String KEY_ID = "_id";
    public static final String KEY_STATE = "state";
    public static final String KEY_TF = "tf";


    static final String[] COLUMNS = {KEY_ID, KEY_STATE, KEY_TF};




    private DBCards(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public static DBCards getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new DBCards(context.getApplicationContext());
        }
        return sInstance;
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        //Create table with accounts
        db.execSQL("create table " + TABLE_CARDS + "(" + KEY_ID
                + " integer primary key," + KEY_STATE + " text," + KEY_TF + " integer"  + ")");
    }




    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_CARDS);
        onCreate(db);
    }





    public ArrayList<Card> getObjectListFromDB() {
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<Card> ar = new ArrayList<>();
        Cursor cursor = db.query(TABLE_CARDS, null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            int stateIndex = cursor.getColumnIndex(KEY_STATE);
            int tfIndex = cursor.getColumnIndex(KEY_TF);
            int idIndex = cursor.getColumnIndex(KEY_ID);
            do {
                ar.add(new Card(cursor.getInt(idIndex),
                        cursor.getString(stateIndex),
                        cursor.getInt(tfIndex)
              ));
            } while (cursor.moveToNext());
        }
        db.close();
        return ar;
    }
    public ArrayList<String> getListFromDB() {
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<String> ar = new ArrayList<>();
        Cursor cursor = db.query(TABLE_CARDS, null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            int stateIndex = cursor.getColumnIndex(KEY_STATE);
            do {
                String n = cursor.getString(stateIndex);
                ar.add(n);
            } while (cursor.moveToNext());
        }
        db.close();
        return ar;
    }
    void logDB(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(TABLE_CARDS, null, null, null, null, null, null);

        if (cursor.moveToFirst()){
            int idIndex = cursor.getColumnIndex(KEY_ID); // 0
            int stateIndex = cursor.getColumnIndex(KEY_STATE); // 1
            int tfIndex = cursor.getColumnIndex(KEY_TF); // 2
            do{
                Log.d("mLog", "ID = " + cursor.getInt(idIndex) +
                        ", state = " + cursor.getString(stateIndex)+
                        ", tf = " + cursor.getInt(tfIndex));

            }while (cursor.moveToNext());
        }else
            Log.d("mLog","0 rows");
        cursor.close();

    }
         public Card getCardByState(String state) {
             SQLiteDatabase database = getReadableDatabase();
             Cursor cursor = database.query(TABLE_CARDS, null, null, null, null, null, null);
             if (cursor.moveToFirst()) {
                 int idIndex = cursor.getColumnIndex(KEY_ID); // 0
                 int stateIndex = cursor.getColumnIndex(KEY_STATE); // 1
                 int tfIndex = cursor.getColumnIndex(KEY_TF); // 2
                 while (cursor.moveToNext()) {
                     if(cursor.getString(stateIndex).equals(state)){
                         return new Card(cursor.getInt(idIndex),cursor.getString(stateIndex),cursor.getInt(tfIndex));
                     }

                 }
             }
             return null;
         }
}
