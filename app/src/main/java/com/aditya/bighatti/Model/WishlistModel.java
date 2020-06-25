package com.aditya.bighatti.Model;

public class WishlistModel {
    private int productImage;
    private String productTitle;
    private int freeCoupons;
    private String productRatings;
    private int totalRatings;
    private String productPrice;
    private String productCuttedPrice;
    private String paymentMethod;

    public WishlistModel(int productImage, String productTitle, int freeCoupons, String productRatings, int totalRatings, String productPrice, String productCuttedPrice, String paymentMethod) {
        this.productImage = productImage;
        this.productTitle = productTitle;
        this.freeCoupons = freeCoupons;
        this.productRatings = productRatings;
        this.totalRatings = totalRatings;
        this.productPrice = productPrice;
        this.productCuttedPrice = productCuttedPrice;
        this.paymentMethod = paymentMethod;
    }

    public int getProductImage() {
        return productImage;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public int getFreeCoupons() {
        return freeCoupons;
    }

    public void setFreeCoupons(int freeCoupons) {
        this.freeCoupons = freeCoupons;
    }

    public String getProductRatings() {
        return productRatings;
    }

    public void setProductRatings(String productRatings) {
        this.productRatings = productRatings;
    }

    public int getTotalRatings() {
        return totalRatings;
    }

    public void setTotalRatings(int totalRatings) {
        this.totalRatings = totalRatings;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductCuttedPrice() {
        return productCuttedPrice;
    }

    public void setProductCuttedPrice(String productCuttedPrice) {
        this.productCuttedPrice = productCuttedPrice;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
