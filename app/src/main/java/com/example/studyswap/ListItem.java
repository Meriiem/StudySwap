package com.example.studyswap;

public class ListItem {

    // Declare the variables for the item picture, title, request status, item seller username, and date of request sent
    private int itemPicture;
    private String itemTitle;
    private String requestStatus;
    private String itemSeller;
    private String dateSent;

    // Create a constructor for the ListItem class
    public ListItem(int itemPicture, String itemTitle, String requestStatus, String itemSeller, String dateSent) {
        this.itemPicture = itemPicture;
        this.itemTitle = itemTitle;
        this.requestStatus = requestStatus;
        this.itemSeller = itemSeller;
        this.dateSent = dateSent;
    }

    // Create getters and setters for the variables
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

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }

    public String getItemSeller() {
        return itemSeller;
    }

    public void setItemSeller(String itemSeller) {
        this.itemSeller = itemSeller;
    }

    public String getDateSent() {
        return dateSent;
    }

    public void setDateSent(String dateSent) {
        this.dateSent = dateSent;
    }
}
