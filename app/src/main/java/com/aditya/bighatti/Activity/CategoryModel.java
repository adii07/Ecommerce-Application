package com.aditya.bighatti.Activity;

public class CategoryModel {

    private String Category_icon_link;
    private String Category_name;

    public CategoryModel(String category_icon_link, String category_name) {
        Category_icon_link = category_icon_link;
        Category_name = category_name;
    }

    public String getCategory_icon_link() {
        return Category_icon_link;
    }

    public String getCategory_name() {
        return Category_name;
    }

    public void setCategory_icon_link(String category_icon_link) {
        Category_icon_link = category_icon_link;
    }

    public void setCategory_name(String category_name) {
        Category_name = category_name;
    }
}
