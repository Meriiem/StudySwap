package com.example.studyswap;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;


import java.util.List;

public class ItemAdapter extends ArrayAdapter<Item> {

    private Context myContext;  //Calling activity
    private List<Item> myItems;

    public ItemAdapter(@NonNull Context context, List<Item> items) {
        super(context, R.layout.item_course_material, items);
        myContext = context;
        myItems = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = (LayoutInflater) myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.item_course_material, parent, false);

        TextView title = view.findViewById(R.id.titleTextView);
        ImageView img = view.findViewById(R.id.materialImageView);

        title.setText(getItem(position).getTitle());
        img.setImageResource(getItem(position).getImg());

        if(img.getDrawable() == null){

            img.setImageURI(getItem(position).getImg_view());
        }

        return view;
    }

    @Override
    public int getCount()
    {
        return myItems.size();
    }


}
