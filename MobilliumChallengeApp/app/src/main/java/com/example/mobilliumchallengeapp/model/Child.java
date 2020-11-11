package com.example.mobilliumchallengeapp.model;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Child implements Serializable {

@SerializedName("id")
@Expose
private Integer id;
@SerializedName("name")
@Expose
private String name;
@SerializedName("parent_id")
@Expose
private Integer parentId;
@SerializedName("order")
@Expose
private Integer order;
@SerializedName("parent_category")
@Expose
private ParentCategory parentCategory;
@SerializedName("logo")
@Expose
private Logo_ logo;
@SerializedName("cover")
@Expose
private Cover_ cover;
@SerializedName("children")
@Expose
private List<Object> children = null;

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

public Integer getParentId() {
return parentId;
}

public void setParentId(Integer parentId) {
this.parentId = parentId;
}

public Integer getOrder() {
return order;
}

public void setOrder(Integer order) {
this.order = order;
}

public ParentCategory getParentCategory() {
return parentCategory;
}

public void setParentCategory(ParentCategory parentCategory) {
this.parentCategory = parentCategory;
}

public Logo_ getLogo() {
return logo;
}

public void setLogo(Logo_ logo) {
this.logo = logo;
}

public Cover_ getCover() {
return cover;
}

public void setCover(Cover_ cover) {
this.cover = cover;
}

public List<Object> getChildren() {
return children;
}

public void setChildren(List<Object> children) {
this.children = children;
}

}