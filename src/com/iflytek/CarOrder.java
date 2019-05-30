package com.iflytek;

import java.util.Date;

public class CarOrder {

	private String orderUp;
	private String carNo;
	private Date beginTime;
	private Date endTime;
	
	public String getOrderUp() {
		return orderUp;
	}
	
	public void setOrderUp(String orderUp) {
		this.orderUp = orderUp;
	}
	
	public String getCarNo() {
		return carNo;
	}
	
	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}
	
	public Date getBeginTime() {
		return beginTime;
	}
	
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	
	public Date getEndTime() {
		return endTime;
	}
	
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
}
