package com.example.myapplication;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class CollectionActivity extends AppCompatActivity {

    ListView cardList;
    List<CardModel> cards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);

        //Intent intent = getIntent();
        //cards = (List<CardModel>) intent.getSerializableExtra("cardCollection");
        Toast.makeText(this, cards.toString(), Toast.LENGTH_SHORT).show();

        cardList = findViewById(R.id.cardList);

    }
}