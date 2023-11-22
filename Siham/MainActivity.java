package com.uos.studyswapapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //Objects' declaration
    Button startBtn, myCounterBtn, newItemBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Object initialization
        startBtn = findViewById(R.id.btnStart);
        myCounterBtn = findViewById(R.id.btnMyCounter);
        newItemBtn = findViewById(R.id.newItem);


        //Listeners
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent startIntent = new Intent(MainActivity.this, Feature1Activity.class);
                startActivity(startIntent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }//end of onClick()

        });//end of setOnClickListener()

        myCounterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent counterIntent = new Intent(MainActivity.this, MyCounterActivity.class);
                startActivity(counterIntent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }//end of onClick()

        });//end of setOnClickListener()


        newItemBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent newItemIntent = new Intent(MainActivity.this, AddItemActivity.class);
                startActivity(newItemIntent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }//end of onClick()

        });//end of setOnClickListener()


    }//end of onCreate()

}//end of MainActivity