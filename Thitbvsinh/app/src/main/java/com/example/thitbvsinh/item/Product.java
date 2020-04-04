package com.example.thitbvsinh.item;

public class Product {
    private int image;
    private String name;
    private String prize;

    public Product(int image, String name, String prize) {
        this.image = image;
        this.name = name;
        this.prize = prize;
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

    public String getPrize() {
        return prize;
    }

    public void setPrize(String prize) {
        this.prize = prize;
    }
}
