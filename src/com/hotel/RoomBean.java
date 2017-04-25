package com.hotel;

public class RoomBean extends HotelBean {
public int rid;	

private Boolean isAc;
private int no_Of_cot;


//private Boolean hasBalconyView;
private int grade;
private int livingSpace;
private int hid;
private int cost;
private String type;
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public int getRid() {
	return rid;
}
public void setRid(int rid) {
	this.rid = rid;
}
public int getCost() {
	return cost;
}
public void setCost(int cost) {
	this.cost = cost;
}
public int getHid() {
	return hid;
}
public void setHid(int hid) {
	this.hid = hid;
}


public Boolean getIsAc() {
	return isAc;
}
public void setIsAc(Boolean isAc) {
	this.isAc = isAc;
}
public int getNo_Of_cot() {
	return no_Of_cot;
}
public void setNo_Of_cot(int no_Of_cot) {
	this.no_Of_cot = no_Of_cot;
}
/*
public Boolean getHasBalconyView() {
	return hasBalconyView;
}
public void setHasBalconyView(Boolean hasBalconyView) {
	this.hasBalconyView = hasBalconyView;
}*/
public int getGrade() {
	return grade;
}
public void setGrade(int grade) {
	this.grade = grade;
}
public int getLivingSpace() {
	return livingSpace;
}
public void setLivingSpace(int livingSpace) {
	this.livingSpace = livingSpace;
}


}
