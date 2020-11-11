package com.example.mobilliumchallengeapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Collection implements Serializable {

@SerializedName("id")
@Expose
private Integer id;
@SerializedName("title")
@Expose
private String title;
@SerializedName("definition")
@Expose
private String definition;
@SerializedName("start")
@Expose
private String start;
@SerializedName("end")
@Expose
private Object end;
@SerializedName("share_url")
@Expose
private String shareUrl;
@SerializedName("cover")
@Expose
private Cover____ cover;
@SerializedName("logo")
@Expose
private Logo___ logo;

public Integer getId() {
return id;
}

public void setId(Integer id) {
this.id = id;
}

public String getTitle() {
return title;
}

public void setTitle(String title) {
this.title = title;
}

public String getDefinition() {
return definition;
}

public void setDefinition(String definition) {
this.definition = definition;
}

public String getStart() {
return start;
}

public void setStart(String start) {
this.start = start;
}

public Object getEnd() {
return end;
}

public void setEnd(Object end) {
this.end = end;
}

public String getShareUrl() {
return shareUrl;
}

public void setShareUrl(String shareUrl) {
this.shareUrl = shareUrl;
}

public Cover____ getCover() {
return cover;
}

public void setCover(Cover____ cover) {
this.cover = cover;
}

public Logo___ getLogo() {
return logo;
}

public void setLogo(Logo___ logo) {
this.logo = logo;
}

}