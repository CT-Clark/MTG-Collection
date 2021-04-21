package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CollectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);

        if (getIntent().hasExtra("CollectionScreen")) {
            TextView tv = (TextView) findViewById(R.id.collectionTitleText);
            String text = getIntent().getExtras().getString("CollectionScreen");
            tv.setText(text);
        }
    }
}