package com.example.mobilliumchallengeapp.model;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Shop_ implements Serializable {

@SerializedName("id")
@Expose
private Integer id;
@SerializedName("name")
@Expose
private String name;
@SerializedName("slug")
@Expose
private String slug;
@SerializedName("definition")
@Expose
private String definition;
@SerializedName("name_updateable")
@Expose
private Boolean nameUpdateable;
@SerializedName("vacation_mode")
@Expose
private Integer vacationMode;
@SerializedName("created_at")
@Expose
private String createdAt;
@SerializedName("shop_payment_id")
@Expose
private Integer shopPaymentId;
@SerializedName("popular_products")
@Expose
private List<PopularProduct> popularProducts = null;
@SerializedName("product_count")
@Expose
private Integer productCount;
@SerializedName("shop_rate")
@Expose
private Integer shopRate;
@SerializedName("comment_count")
@Expose
private Integer commentCount;
@SerializedName("follower_count")
@Expose
private Integer followerCount;
@SerializedName("is_editor_choice")
@Expose
private Boolean isEditorChoice;
@SerializedName("is_following")
@Expose
private Boolean isFollowing;
@SerializedName("cover")
@Expose
private Cover_____ cover;
@SerializedName("share_url")
@Expose
private String shareUrl;
@SerializedName("logo")
@Expose
private Object logo;

public Integer getId() {
return id;
}

public void setId(Integer id) {
this.id = id;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public String getSlug() {
return slug;
}

public void setSlug(String slug) {
this.slug = slug;
}

public String getDefinition() {
return definition;
}

public void setDefinition(String definition) {
this.definition = definition;
}

public Boolean getNameUpdateable() {
return nameUpdateable;
}

public void setNameUpdateable(Boolean nameUpdateable) {
this.nameUpdateable = nameUpdateable;
}

public Integer getVacationMode() {
return vacationMode;
}

public void setVacationMode(Integer vacationMode) {
this.vacationMode = vacationMode;
}

public String getCreatedAt() {
return createdAt;
}

public void setCreatedAt(String createdAt) {
this.createdAt = createdAt;
}

public Integer getShopPaymentId() {
return shopPaymentId;
}

public void setShopPaymentId(Integer shopPaymentId) {
this.shopPaymentId = shopPaymentId;
}

public List<PopularProduct> getPopularProducts() {
return popularProducts;
}

public void setPopularProducts(List<PopularProduct> popularProducts) {
this.popularProducts = popularProducts;
}

public Integer getProductCount() {
return productCount;
}

public void setProductCount(Integer productCount) {
this.productCount = productCount;
}

public Integer getShopRate() {
return shopRate;
}

public void setShopRate(Integer shopRate) {
this.shopRate = shopRate;
}

public Integer getCommentCount() {
return commentCount;
}

public void setCommentCount(Integer commentCount) {
this.commentCount = commentCount;
}

public Integer getFollowerCount() {
return followerCount;
}

public void setFollowerCount(Integer followerCount) {
this.followerCount = followerCount;
}

public Boolean getIsEditorChoice() {
return isEditorChoice;
}

public void setIsEditorChoice(Boolean isEditorChoice) {
this.isEditorChoice = isEditorChoice;
}

public Boolean getIsFollowing() {
return isFollowing;
}

public void setIsFollowing(Boolean isFollowing) {
this.isFollowing = isFollowing;
}

public Cover_____ getCover() {
return cover;
}

public void setCover(Cover_____ cover) {
this.cover = cover;
}

public String getShareUrl() {
return shareUrl;
}

public void setShareUrl(String shareUrl) {
this.shareUrl = shareUrl;
}

public Object getLogo() {
return logo;
}

public void setLogo(Object logo) {
this.logo = logo;
}

}