package com.example.studyswap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Feature2Activity extends AppCompatActivity {

    //Objects' declaration
    Button backBtn, continueBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feature2);

        //Object initialization
        backBtn = findViewById(R.id.btnBackToF1);
        continueBtn = findViewById(R.id.btnCont2);


        //Listeners
        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent f3Intent = new Intent(Feature2Activity.this, Feature3Activity.class);
                startActivity(f3Intent);
//                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }//end of onClick()
        });//end of setOnClickListener()

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }//end of onClick()
        });//end of setOnClickListener()

    }//end of onCreate()


    //Exiting activity animation
    @Override
    public void finish(){

        super.finish();
//        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }//end of finish()


}//end of Feature2Activity