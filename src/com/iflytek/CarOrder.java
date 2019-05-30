package com.iflytek;

import java.util.Date;

public class CarOrder {

	private String orderUp; //单号
	private String placeNo; //车位号
	private String carNo;   //车牌
	private Date beginTime; //开始时间
	private Date endTime;   //结束时间
	
	
	public CarOrder(String orderUp, String carNo, Date beginTime) {
		super();
		this.orderUp = orderUp;
		this.carNo = carNo;
		this.beginTime = beginTime;
	}
	
	public CarOrder() {
		
	}

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

	public String getPlaceNo() {
		return placeNo;
	}
	
	public String getPlaceNoByParking(Parking parking) {
		placeNo = String.valueOf((int)((Math.random()*100)+1));
		while (isExist(placeNo, parking)) {
			placeNo = String.valueOf((int)((Math.random()*100)+1));
		}
		return placeNo;
	}

	public void setPlaceNo(String placeNo) {
		this.placeNo = placeNo;
	}
	
	private boolean isExist(String placeNo, Parking parking) {
		for (CarOrder carOrder : parking.getCarOrderList()) {
			if (carOrder.placeNo.equals(placeNo)) {
				return true;
			}
		}
		return false;
	}
	
}
