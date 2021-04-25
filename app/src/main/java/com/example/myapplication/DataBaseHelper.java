package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String CARD_COLLECTION = "CARD_COLLECTION";
    public static final String COLUMN_CARD_NAME = "CARD_NAME";
    public static final String COLUMN_CARD_URL = "CARD_URL";
    public static final String COLUMN_ID = "ID";

    public DataBaseHelper(@Nullable Context context) {
        super(context, "collection.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement =
                "CREATE TABLE " + CARD_COLLECTION + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_CARD_NAME + " TEXT, " + COLUMN_CARD_URL + " TEXT)";

        db.execSQL(createTableStatement);
    }

    // Automatically modifies db schema when new version is introduced
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addOne(CardModel cardModel) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_CARD_NAME, cardModel.getName());
        cv.put(COLUMN_CARD_URL, cardModel.getUrl());

        long insert = db.insert(CARD_COLLECTION, null, cv);

        return insert != -1;
    }
}
