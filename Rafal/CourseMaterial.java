package com.example.studyswap;

import android.net.Uri;

public class CourseMaterial implements java.io.Serializable {

    private String title;
    private String courseName;
    private String year;
    private String major;
    private String paidOrFree;
    private String virtualOrPrinted;
    private int imageResourceId;

    public CourseMaterial(String title, String courseName, String year, String major,
                          String paidOrFree, String virtualOrPrinted, int imageResourceId) {
        this.title = title;
        this.courseName = courseName;
        this.year = year;
        this.major = major;
        this.paidOrFree = paidOrFree;
        this.virtualOrPrinted = virtualOrPrinted;
        this.imageResourceId = imageResourceId;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getYear() {
        return year;
    }

    public String getMajor() {
        return major;
    }

    public String getPaidOrFree() {
        return paidOrFree;
    }

    public String getVirtualOrPrinted() {
        return virtualOrPrinted;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setPaidOrFree(String paidOrFree) {
        this.paidOrFree = paidOrFree;
    }

    public void setVirtualOrPrinted(String virtualOrPrinted) {
        this.virtualOrPrinted = virtualOrPrinted;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }
}
