package com.hotel;

public class BookingBean {
private String loginid,fromdate,todate,Newtodate;
public String getNewtodate() {
	return Newtodate;
}
public void setNewtodate(String newtodate) {
	Newtodate = newtodate;
}
int hid,rid;
HotelBean hbean;
RoomBean rbean;

public String getFromdate() {
	return fromdate;
}
public void setFromdate(String fromdate) {
	this.fromdate = fromdate;
}
public String getTodate() {
	return todate;
}
public void setTodate(String todate) {
	this.todate = todate;
}
public HotelBean getHbean() {
	return hbean;
}
public void setHbean(HotelBean hbean) {
	this.hbean = hbean;
}
public RoomBean getRbean() {
	return rbean;
}
public void setRbean(RoomBean rbean) {
	this.rbean = rbean;
}

public String getLoginid() {
	return loginid;
}
public void setLoginid(String loginid) {
	this.loginid = loginid;
}
public int getRid() {
	return rid;
}
public void setRid(int rid) {
	this.rid = rid;
}
public int getHid() {
	return hid;
}
public void setHid(int hid) {
	this.hid = hid;
}

}
