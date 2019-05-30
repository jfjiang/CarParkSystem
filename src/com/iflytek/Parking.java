package com.iflytek;

import java.util.List;

public class Parking {

	private int allPlace;
	private int occupiedPlace;
	private List<CarOrder> carOrderList;
	
	public int getAllPlace() {
		return allPlace;
	}
	
	public void setAllPlace(int allPlace) {
		this.allPlace = allPlace;
	}
	
	public int getOccupiedPlace() {
		return occupiedPlace;
	}
	
	public void setOccupiedPlace(int occupiedPlace) {
		this.occupiedPlace = occupiedPlace;
	}
	
	public List<CarOrder> getCarOrderList() {
		return carOrderList;
	}
	
	public void setCarOrderList(List<CarOrder> carOrderList) {
		this.carOrderList = carOrderList;
	}
	
	public void addCarOrder(CarOrder carOrder) {
		this.carOrderList.add(carOrder);
	}
	
}
