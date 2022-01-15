package com.example.dreviewcreate;

public class Product {
    private Integer productImage;
    private String productName;
    private int productPrice;
    private int review;
    private double rating;

    public Product(Integer productImage, String productName, int productPrice, int review, double rating) {
        this.productImage = productImage;
        this.productName = productName;
        this.productPrice = productPrice;
        this.review = review;
        this.rating = rating;
    }

    public Integer getProductImage() {
        return productImage;
    }

    public void setProductImage(Integer productImage) {
        this.productImage = productImage;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public int getReview() {
        return review;
    }

    public void setReview(int review) {
        this.review = review;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
