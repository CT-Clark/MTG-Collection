package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String CARD_COLLECTION = "CARD_COLLECTION";
    public static final String COLUMN_CARD_NAME = "CARD_NAME";
    public static final String COLUMN_CARD_URL = "CARD_URL";
    public static final String COLUMN_ID = "ID";
    private Context parentContext;

    public DataBaseHelper(@Nullable Context context) {
        super(context, "collection.db", null, 1);
        this.parentContext = context;
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
        db.close();

        return insert != -1;
    }

    public List<CardModel> getAll() {
        Toast.makeText(parentContext, "END OF DB OPERATIONS", Toast.LENGTH_SHORT).show();
        List<CardModel> returnList = new ArrayList<>();

        String queryString = "SELECT * FROM " + CARD_COLLECTION;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(queryString, null); // Returns the dataset

        if (cursor.moveToFirst()) {
            // Iterate through the results, creating a new CardModel for each result
            do {
                int cardID = cursor.getInt(0);
                String cardName = cursor.getString(1);
                String cardURL = cursor.getString(2);

                CardModel newCard = new CardModel(cardID, cardName, cardURL);
                returnList.add(newCard);
            } while (cursor.moveToNext());
        }
        else {
            // Failure
        }

        cursor.close();
        db.close();

        return returnList;
    }
}
