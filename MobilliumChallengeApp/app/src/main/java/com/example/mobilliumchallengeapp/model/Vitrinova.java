package com.example.mobilliumchallengeapp.model;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Vitrinova implements Serializable {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("featured")
    @Expose
    private List<Featured> featured = null;
    @SerializedName("products")
    @Expose
    private List<Product> products = null;
    @SerializedName("categories")
    @Expose
    private List<Category_> categories = null;
    @SerializedName("collections")
    @Expose
    private List<Collection> collections = null;
    @SerializedName("shops")
    @Expose
    private List<Shop_> shops = null;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Featured> getFeatured() {
        return featured;
    }

    public void setFeatured(List<Featured> featured) {
        this.featured = featured;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Category_> getCategories() {
        return categories;
    }

    public void setCategories(List<Category_> categories) {
        this.categories = categories;
    }

    public List<Collection> getCollections() {
        return collections;
    }

    public void setCollections(List<Collection> collections) {
        this.collections = collections;
    }

    public List<Shop_> getShops() {
        return shops;
    }

    public void setShops(List<Shop_> shops) {
        this.shops = shops;
    }

}