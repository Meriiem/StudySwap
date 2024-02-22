package com.example.studyswap;

import android.net.Uri;
import android.widget.ImageView;

public class Item {

    //Attributes
    private int id;
    private String title, course_name, year;
    private int img;
    private Uri img_view;
    private String category, charge, type;

    //Constructor

    public Item(String title, String course_name, String year, int img, String category, String charge, String type) {
        this.title = title;
        this.course_name = course_name;
        this.year = year;
        this.img = img;
        this.category = category;
        this.charge = charge;
        this.type = type;
    }

    public Item(String title, String course_name, String year, Uri img_view, String category, String charge, String type) {
        this.title = title;
        this.course_name = course_name;
        this.year = year;
        this.img_view = img_view;
        this.category = category;
        this.charge = charge;
        this.type = type;
    }


    //Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Uri getImg_view() {
        return img_view;
    }

    public void setImg_view(Uri img_view) {
        this.img_view = img_view;
    }
}
