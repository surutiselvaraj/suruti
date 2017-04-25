package com.hotel.manager;

import com.hotel.HotelBean;


public class ManagerBean {
private int managerid,hid;
private String managerfname,managerlname,address,district,emailid,password;private long contactno;
private HotelBean hbean;
public HotelBean getHbean() {
	return hbean;
}
public void setHbean(HotelBean hbean) {
	this.hbean = hbean;
}
public int getManagerid() {
	return managerid;
}
public void setManagerid(int managerid) {
	this.managerid = managerid;
}
public int getHid() {
	return hid;
}
public void setHid(int hid) {
	this.hid = hid;
}
public String getManagerfname() {
	return managerfname;
}
public void setManagerfname(String managerfname) {
	this.managerfname = managerfname;
}
public String getManagerlname() {
	return managerlname;
}
public void setManagerlname(String managerlname) {
	this.managerlname = managerlname;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getDistrict() {
	return district;
}
public void setDistrict(String district) {
	this.district = district;
}
public String getEmailid() {
	return emailid;
}
public void setEmailid(String emailid) {
	this.emailid = emailid;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public long getContactno() {
	return contactno;
}
public void setContactno(long contactno) {
	this.contactno = contactno;
}

}
