package com.aditya.bighatti.Activity;

import java.util.List;

public class HomePageModel {
    private  int type;
    public static final int BANNER_SLIDER=0;
    public static final int STRIP_ADD_BANNER=1;
    public static final int HORIZONTAL_PRODUCT_VIEW=2;
    public static final int GRID_PRODUCT_VIEW=3;
    ////////////////////////////////////////////////////Banner Slider
    private List<SliderModel> sliderModelList;

    public HomePageModel(int type, List<SliderModel> sliderModelList) {
        this.type = type;
        this.sliderModelList = sliderModelList;
    }
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }
    public List<SliderModel> getSliderModelList() {
        return sliderModelList;
    }
    public void setSliderModelList(List<SliderModel> sliderModelList) {
        this.sliderModelList = sliderModelList;
    }
    ////////////////////////////////////////////////////Banner Slider

    /////////////////////////////Strip Add
    private String resource;
    private String backgroundColor;

    public HomePageModel(int type,String resource, String backgroundColor) {
        this.type = type;
        this.resource = resource;
        this.backgroundColor = backgroundColor;
    }
    public String getResource() {
        return resource;
    }
    public void setResource(String resource) {
        this.resource = resource;
    }
    public String getBackgroundColor() {
        return backgroundColor;
    }
    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }
    /////////////////////////////Strip Add

    /////////////////////////////Horizontal Product Layout && Grid Product Layout
    private String title;
    private List<HorizontalProductModel> horizontalProductModelList;

    public HomePageModel(int type, String title, List<HorizontalProductModel> horizontalProductModelList) {
        this.type = type;
        this.title = title;
        this.horizontalProductModelList = horizontalProductModelList;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public List<HorizontalProductModel> getHorizontalProductModelList() {
        return horizontalProductModelList;
    }
    public void setHorizontalProductModelList(List<HorizontalProductModel> horizontalProductModelList) {
        this.horizontalProductModelList = horizontalProductModelList;
    }
    /////////////////////////////Horizontal Product Layout  && Grid Product Layout




}
