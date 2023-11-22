package com.uos.studyswapapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class AddItemActivity extends AppCompatActivity {

    //Objects' declarations
    public static final int PICK_IMAGE_CODE = 1;
    EditText itemTitle, courseName, itemYear;
    ImageView itemImg;
    RadioGroup categoryGroup, chargeGroup, typeGroup;
    RadioButton categoryBtnSelected, chargeBtnSelected, typeBtnSelected;
    Button addItemToList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        itemTitle = findViewById(R.id.edtxtItemTitle);
        courseName = findViewById(R.id.edtxtCourseName);
        itemYear = findViewById(R.id.edtxtYear);
        itemImg = findViewById(R.id.imgItem);
        categoryGroup = findViewById(R.id.item_category_group);
        chargeGroup = findViewById(R.id.item_charge_group);
        typeGroup = findViewById(R.id.item_type_group);
        addItemToList = findViewById(R.id.btnAddToList);


        //Choose item image from gallery
        itemImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openGallery();
            }//end of onClick()
        });//end of onClickListener()


        //Add item to list button
        addItemToList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Get item title
                String title = itemTitle.getText().toString();
                //Get item's course name
                String course = courseName.getText().toString();
                //Get item's year
                String year = itemYear.getText().toString();

                //Get item's category from respective RadioGroup
                int categoryID = categoryGroup.getCheckedRadioButtonId();
                String categoryString = "";
                if(categoryID != -1){

                    categoryBtnSelected = findViewById(categoryID);
                    categoryString = categoryBtnSelected.getText().toString();
                }

                //Get item's charge option from respective RadioGroup
                int chargeID = chargeGroup.getCheckedRadioButtonId();
                String chargeString = "";
                if(chargeID != -1){

                    chargeBtnSelected = findViewById(chargeID);
                    chargeString = categoryBtnSelected.getText().toString();
                }

                //Get item's type from respective RadioGroup
                int typeID = typeGroup.getCheckedRadioButtonId();
                String typeString = "";
                if(typeID != -1){

                    typeBtnSelected = findViewById(typeID);
                    typeString = typeBtnSelected.getText().toString();
                }

                if(title.isEmpty() || course.isEmpty() || year.isEmpty() || categoryString.isEmpty() || chargeString.isEmpty() || typeString.isEmpty()){

                    Toast.makeText(AddItemActivity.this, getString(R.string.missing_fields), Toast.LENGTH_SHORT).show();
                    return;
                }

            }//end of onClick()
        });//end of setOnClickListener()


    }//end of onCreate()

        //Implicit intent
        private void openGallery(){

            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(intent, PICK_IMAGE_CODE);
            //ActivityLauncher.launch(intent);
        }//end of openGallery()


        protected void onActivityResult(int requestCode, int resultCode, Intent data){

            super.onActivityResult(requestCode, resultCode, data);
            if(resultCode == RESULT_OK && requestCode == PICK_IMAGE_CODE){

                Uri imgUri = data.getData();
                itemImg.setPadding(30, 30, 30, 30);
                itemImg.setImageURI(imgUri);
            }
        }//end of onActivityResult()

}//end of AddItemActivity