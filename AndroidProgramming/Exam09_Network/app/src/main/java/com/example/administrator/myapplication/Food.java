package com.example.administrator.myapplication;

public class Food {
    private int image;
    private String name;
    private String price;
    private String content;

    public Food(int image, String name, String price, String content) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.content = content;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
