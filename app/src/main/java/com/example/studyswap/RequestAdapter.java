package com.example.studyswap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;


public class RequestAdapter extends ArrayAdapter<Request> {

    private Context context;
    private ArrayList<Request> requests;

    public RequestAdapter(@NonNull Context context, ArrayList<Request> requests) {
        super(context, R.layout.received_list_item, requests);
        this.context = context;
        this.requests = requests;

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.received_list_item,parent,false);

        // Get the request object at the current position
        Request request = requests.get(position);

        // Inflate the layout if the view is null
        /*if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_received_requests, parent, false);
        }*/

        // Get the views from the layout
        ImageView itemPicture = view.findViewById(R.id.item_pictureR);
        TextView itemTitle = view.findViewById(R.id.item_titleR);
        TextView userName = view.findViewById(R.id.user_nameR);
        TextView time = view.findViewById(R.id.timeR);

        // Set the views with the data from the request object
        itemPicture.setImageResource(request.getItemPicture());
        itemTitle.setText(request.getItemTitle());
        userName.setText(request.getUserName());
        time.setText(request.getTime());

        // Return the view
        return view;
    }
}
