package com.mathG.mathG.model;

import java.util.ArrayList;

public class Exercise {
    private ArrayList<String> list;
    private String userId;
    public ArrayList<String> getList() {
        return list;
    }
    public void setList(ArrayList<String> list) {
        this.list = list;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public Exercise(ArrayList<String> list) {
        this.list = list;
    }
    public Exercise(ArrayList<String> list, String userId) {
        this.list = list;
        this.userId = userId;
    }
}
