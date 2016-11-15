package com.example.administrator.myapplication;

public class Light {
    private int image;
    private int imageLarge;
    private String title;
    private String content;

    public Light(){}

    public Light(int image, int imageLarge, String title, String content) {
        this.image = image;
        this.imageLarge = imageLarge;
        this.title = title;
        this.content = content;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getImageLarge() {
        return imageLarge;
    }

    public void setImageLarge(int imageLarge) {
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
