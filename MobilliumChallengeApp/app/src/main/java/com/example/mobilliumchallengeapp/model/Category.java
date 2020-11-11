package com.example.mobilliumchallengeapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Category  implements Serializable {

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

}