package com.example.recyclerview3;

import java.io.Serializable;

public class Post implements Serializable {

    private String strTitle, strDescription;
    private int imgImageID;

    public static final String KEY = "detailedpost";

    public String getStrTitle() {
        return strTitle;
    }

    public void setStrTitle(String strTitle) {
        this.strTitle = strTitle;
    }

    public String getStrDescription() {
        return strDescription;
    }

    public void setStrDescription(String strDescription) {
        this.strDescription = strDescription;
    }

    public int getImgImageID() {
        return imgImageID;
    }

    public void setImgImageID(int imgImageID) {
        this.imgImageID = imgImageID;
    }

    public Post(String strTitle, String strDescription, int imgPostImage) {
        this.strTitle = strTitle;
        this.strDescription = strDescription;
        this.imgImageID = imgPostImage;
    }
}

   