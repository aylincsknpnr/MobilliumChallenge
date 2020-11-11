package com.example.mobilliumchallengeapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Cover__ implements Serializable {

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
private Medium_____ medium;
@SerializedName("thumbnail")
@Expose
private Thumbnail_____ thumbnail;

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

public Medium_____ getMedium() {
return medium;
}

public void setMedium(Medium_____ medium) {
this.medium = medium;
}

public Thumbnail_____ getThumbnail() {
return thumbnail;
}

public void setThumbnail(Thumbnail_____ thumbnail) {
this.thumbnail = thumbnail;
}

}