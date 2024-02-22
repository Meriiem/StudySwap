package com.example.studyswap;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<ListItem> {

    private Context context;
    private ArrayList<ListItem> listItems;

    public CustomAdapter(Context context, ArrayList<ListItem> listItems) {
        super(context, 0, listItems);
        this.context = context;
        this.listItems = listItems;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListItem listItem = listItems.get(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        }

        ImageView itemPicture = convertView.findViewById(R.id.item_picture);
        TextView itemTitle = convertView.findViewById(R.id.item_title);
        TextView requestStatus = convertView.findViewById(R.id.request_status);
        TextView itemSeller = convertView.findViewById(R.id.item_seller);
        TextView dateSent = convertView.findViewById(R.id.date_sent);

        String text = requestStatus.getText().toString();

        SpannableString spannableString = new SpannableString(text);

        spannableString.setSpan(new ForegroundColorSpan(Color.BLACK), 0, 8, 0);

        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#FF9800")), 8, text.length(), 0);

        requestStatus.setText(spannableString);

        itemPicture.setImageResource(listItem.getItemPicture());
        itemTitle.setText(listItem.getItemTitle());
        requestStatus.setText(listItem.getRequestStatus());
        itemSeller.setText(listItem.getItemSeller());
        dateSent.setText(listItem.getDateSent());

        return convertView;
    }
}
