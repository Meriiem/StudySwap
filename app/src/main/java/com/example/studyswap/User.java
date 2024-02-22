package com.example.studyswap;

public class User {

    //Attributes
    private int id;
    private String userName;
    private String major;
    private String phone, email;


    //Constructor

    public User() {
    }

    public User(String userName, String email, String phone, String major) {
        this.userName = userName;
        this.major = major;
        this.phone = phone;
        this.email = email;
    }

    //Getters and Setters


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
