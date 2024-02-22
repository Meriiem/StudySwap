package com.example.studyswap;

public class Request {

    private int itemPicture;
    private String itemTitle;
    private String userName;
    private String time;

    public Request(int itemPicture, String itemTitle, String userName, String time) {
        this.itemPicture = itemPicture;
        this.itemTitle = itemTitle;
        this.userName = userName;
        this.time = time;
    }

    public int getItemPicture() {
        return itemPicture;
    }

    public void setItemPicture(int itemPicture) {
        this.itemPicture = itemPicture;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
