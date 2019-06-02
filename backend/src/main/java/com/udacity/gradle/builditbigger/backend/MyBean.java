package com.udacity.gradle.builditbigger.backend;

import jokslibrary.Library;

/** The object model for the data we are sending through endpoints */
public class MyBean {

    private String myData;

    public String getData() {
        Library k = new Library();
        return myData;
    }

    public void setData(String data) {
        myData = data;
    }
}