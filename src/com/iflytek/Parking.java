package com.iflytek;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Parking {

	private final int ALL_PLACE = 100;//总停车位
	private int occupiedPlace;//当前已停车数量
	private List<CarOrder> carOrderList = new ArrayList<CarOrder>();//当前停的车
	
	public int getAllPlace() {
		return ALL_PLACE;
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
	
	public void carIn(CarOrder carOrder) {
		this.carOrderList.add(carOrder);
		this.occupiedPlace++;
	}
	
	public CarOrder carOut(String carNo, Parking parking) {
		for (CarOrder carOrder : parking.carOrderList) {
			if(carOrder.getCarNo().equals(carNo)) {
				carOrder.setEndTime(new Date());
				parking.carOrderList.remove(carOrder);
				parking.occupiedPlace--;
				return carOrder;
			}
		}
		return null;
	}


	
	
}
