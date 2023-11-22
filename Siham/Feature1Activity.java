package com.uos.studyswapapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Feature1Activity extends AppCompatActivity {

    //Activity objects' declarations
    Button continueBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feature_page_1);

        //Object initialization
        continueBtn = findViewById(R.id.btnCont1);


        //Listeners
        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent f2Intent = new Intent(Feature1Activity.this, Feature2Activity.class);
                startActivity(f2Intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }//end of onClick()
        });//end of setOnClickListener()


    }//end of onCreate()

}//end of Feature1Activity