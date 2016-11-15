package com.example.administrator.myapplication;

import android.graphics.Bitmap;

public class Light {
    private Bitmap image;   // 이미지 정보를 가지는 객체 Bitmap
    private Bitmap imageLarge;
    private String imageFileName;
    private String imageLargeFileName;
    private String title;
    private String content;

    public Light(){}

    public Bitmap getImage() {
        return image;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }

    public String getImageLargeFileName() {
        return imageLargeFileName;
    }

    public void setImageLargeFileName(String imageLargeFileName) {
        this.imageLargeFileName = imageLargeFileName;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public Bitmap getImageLarge() {
        return imageLarge;
    }

    public void setImageLarge(Bitmap imageLarge) {
        this.imageLarge = imageLarge;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
