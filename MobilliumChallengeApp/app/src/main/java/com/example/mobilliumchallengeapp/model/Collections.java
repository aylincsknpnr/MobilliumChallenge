package com.example.mobilliumchallengeapp.model;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Collections  implements Serializable {

@SerializedName("id")
@Expose
private Integer id;
@SerializedName("name")
@Expose
private String name;
@SerializedName("parent_id")
@Expose
private Object parentId;
@SerializedName("order")
@Expose
private Integer order;
@SerializedName("parent_category")
@Expose
private Object parentCategory;
@SerializedName("logo")
@Expose
private Logo logo;
@SerializedName("cover")
@Expose
private Cover cover;
@SerializedName("children")
@Expose
private List<Child> children = null;

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

public Object getParentId() {
return parentId;
}

public void setParentId(Object parentId) {
this.parentId = parentId;
}

public Integer getOrder() {
return order;
}

public void setOrder(Integer order) {
this.order = order;
}

public Object getParentCategory() {
return parentCategory;
}

public void setParentCategory(Object parentCategory) {
this.parentCategory = parentCategory;
}

public Logo getLogo() {
return logo;
}

public void setLogo(Logo logo) {
this.logo = logo;
}

public Cover getCover() {
return cover;
}

public void setCover(Cover cover) {
this.cover = cover;
}

public List<Child> getChildren() {
return children;
}

public void setChildren(List<Child> children) {
this.children = children;
}

}