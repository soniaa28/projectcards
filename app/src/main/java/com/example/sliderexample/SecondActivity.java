package com.example.sliderexample;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    TextView rules;
    private DBCards dbHelper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        rules = findViewById(R.id.rules);
        Toast.makeText(this, "kjhg", Toast.LENGTH_SHORT).show();

    }



   public void getRules(Object dataObject){
        Card card = dbHelper.getCardByState(dataObject.toString());

        rules.setText("1");

    }

}
