package com.example.studyswap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class AddItemActivity extends AppCompatActivity {

    //Objects' declarations
    public static final int PICK_IMAGE_CODE = 1;
    EditText itemTitle, courseName, itemYear;
    ImageView itemImg;
    byte[] itemImageInByte;
    RadioGroup categoryGroup, chargeGroup, typeGroup;
    RadioButton categoryBtnSelected, chargeBtnSelected, typeBtnSelected;
    Button addItemToList;
    Drawable img;
    Uri imgUri;

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

                if(title.isEmpty() || course.isEmpty() || year.isEmpty() || categoryString.isEmpty() || chargeString.isEmpty() || typeString.isEmpty() ||
                        itemImg == null){

                    Toast.makeText(AddItemActivity.this, getString(R.string.missing_fields), Toast.LENGTH_SHORT).show();
                    return;
                }

                Item item = new Item(title, course, year, imgUri, categoryString, chargeString, typeString);

                Log.d("OIII", (categoryString.toString().trim() == "BOOK" ? "YEZZZZ" : "NOOOO") + " " + categoryString);
                if(categoryString.equals("BOOK")){

                    MyBooksFragment.AddBook(item);
                    Toast.makeText(AddItemActivity.this, getString(R.string.successful_item_addition), Toast.LENGTH_SHORT).show();
                    finish();
                }

                if(categoryString.equals("NOTES")){

                    MyNotesFragment.AddNote(item);
                    Toast.makeText(AddItemActivity.this, getString(R.string.successful_item_addition), Toast.LENGTH_SHORT).show();
                    finish();
                }


                /*Item newItem = new Item(title, course, year, itemImg, categoryString, chargeString, typeString);
                db.AddNewItem(newItem);
                Toast.makeText(AddItemActivity.this, getString(R.string.successful_item_addition), Toast.LENGTH_SHORT).show();
                finish();*/

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

            imgUri = data.getData();
            itemImg.setPadding(30, 30, 30, 30);
            itemImg.setImageURI(imgUri);

            /*//ImageView imageView = (ImageView) findViewById(R.id.imageView);
            Bitmap bitmap = ((BitmapDrawable) itemImg.getDrawable()).getBitmap();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            itemImageInByte = baos.toByteArray();
            try {
                baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }*/
        }
    }//end of onActivityResult()

}//end of AddItemActivity