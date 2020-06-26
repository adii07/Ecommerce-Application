package com.aditya.bighatti.Model;

public class MyRewardModel {
    private String couponTitle;
    private String couponValidity;
    private String couponBody;

    public MyRewardModel(String couponTitle, String couponValidity, String couponBody) {
        this.couponTitle = couponTitle;
        this.couponValidity = couponValidity;
        this.couponBody = couponBody;
    }

    public String getCouponTitle() {
        return couponTitle;
    }

    public void setCouponTitle(String couponTitle) {
        this.couponTitle = couponTitle;
    }

    public String getCouponValidity() {
        return couponValidity;
    }

    public void setCouponValidity(String couponValidity) {
        this.couponValidity = couponValidity;
    }

    public String getCouponBody() {
        return couponBody;
    }

    public void setCouponBody(String couponBody) {
        this.couponBody = couponBody;
    }
}
