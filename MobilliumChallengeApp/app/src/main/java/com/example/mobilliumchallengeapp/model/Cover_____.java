package com.example.mobilliumchallengeapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Cover_____ implements Serializable {

@SerializedName("width")
@Expose
private Integer width;
@SerializedName("height")
@Expose
private Integer height;
@SerializedName("url")
@Expose
private String url;
@SerializedName("medium")
@Expose
private Medium___________ medium;
@SerializedName("thumbnail")
@Expose
private Thumbnail___________ thumbnail;

public Integer getWidth() {
return width;
}

public void setWidth(Integer width) {
this.width = width;
}

public Integer getHeight() {
return height;
}

public void setHeight(Integer height) {
this.height = height;
}

public String getUrl() {
return url;
}

public void setUrl(String url) {
this.url = url;
}

public Medium___________ getMedium() {
return medium;
}

public void setMedium(Medium___________ medium) {
this.medium = medium;
}

public Thumbnail___________ getThumbnail() {
return thumbnail;
}

public void setThumbnail(Thumbnail___________ thumbnail) {
this.thumbnail = thumbnail;
}

}