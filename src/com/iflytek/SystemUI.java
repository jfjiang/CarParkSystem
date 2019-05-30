package com.iflytek;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SystemUI {
	private Scanner scanner = new Scanner(System.in);
	private  int index;
	private Parking parking = new Parking();
	private static boolean flag = true;
	
	public static void main(String[] args) {
		SystemUI systemUI = new SystemUI();
		while (flag) {
			systemUI.showMainMenu();
		}
	}

	private void showMainMenu() {
		System.out.println("\n====================欢迎你进入停车场管理系统===================\n");
		System.out.print("1.汽车进站登记  2.汽车出站登记  3.车位状态显示  4.退出系统\n请选择序号：");
		index = scanner.nextInt();
		System.out.println();
		
		switch (index) {
		case 1:
			carInRegister();
			break;
		case 2:
			carOutRegister();
			break;
		case 3:
			showParkMenu();
			break;
		case 4:
			exitSystem();
			break;

		default:
			break;
		}
	}
	
	private void showParkMenu() {
		System.out.println("请选择：");
		System.out.println("\t1.车场列表");
		System.out.println("\t2.便道列表");
		System.out.println("\t3.返回主菜单");
		index = scanner.nextInt();
		System.out.println();
		
		switch (index) {
		case 1:
			showParkStatus();
			break;
			
		case 2:
			System.out.println("便道里没有车");
			break;
			
		case 3:
			showMainMenu();
			break;
		
		default:
			break;
		}
	}
	
	private void carInRegister() {
		if (parking.getOccupiedPlace()<parking.getAllPlace()) {
			System.out.print("请输入车牌号：");
			String carNo = scanner.next();
			Date beginTime = new Date();
			String orderUp = String.valueOf(System.currentTimeMillis());
			CarOrder carOrder = new CarOrder(orderUp, carNo, beginTime);
			String placeNo = carOrder.getPlaceNoByParking(parking);
			carOrder.setPlaceNo(placeNo);
			
			System.out.println("车辆在车场第"+ placeNo +"号车位");
			System.out.println("车辆到达时间："+ getTime(beginTime));
			
			parking.getCarOrderList().add(carOrder);
			parking.setOccupiedPlace(parking.getOccupiedPlace()+1);
		} else {
			System.out.println("车位已满！");
		}
	}
	
	private void carOutRegister() {
		System.out.print("请输入车牌号：");
		String carNo = scanner.next();
		CarOrder carOrder = parking.carOut(carNo, parking);
		
		System.out.println("离开车辆的车牌号是：" + carNo);
		System.out.println("其到达时间为："+ getTime(carOrder.getBeginTime()));
		System.out.println("其离开时间为："+ getTime(carOrder.getEndTime()));
		System.out.println("应缴费用为："+ getCost(carOrder.getBeginTime(), carOrder.getEndTime()).get("money")+"元");
	}
	
	private String getTime(Date date) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(date);
	}
	
	private Map<String, Object> getCost(Date beginTime, Date endTime) {
		Map<String, Object> costMap = new HashMap<String, Object>();
		long costTime = endTime.getTime() - beginTime.getTime();
		long nd = 1000 * 24 * 60 * 60;
		long nh = 1000 * 60 * 60;
		long nm = 1000 * 60;
		// 计算差多少天
		long day = costTime / nd;
		// 计算差多少小时
		long hour = costTime % nd / nh;
		// 计算差多少分钟
		long min = costTime % nd % nh / nm;
		int money = (int) ((hour + 1) *5);
		if (day!=0) {
			costMap.put("money", money);
			costMap.put("time", day + "天" + hour + "小时" + min + "分钟");
			return costMap;
		} else if (hour!=0) {
			costMap.put("money", money);
			costMap.put("time", hour + "小时" + min + "分钟");
			return costMap;
		} else {
			costMap.put("money", money);
			costMap.put("time", min + "分钟");
			return costMap;
		}
	}
	
	private void exitSystem() {
		flag = false;
		System.out.println("谢谢使用！");
	}
	
	private void showParkStatus() {
		if (parking.getOccupiedPlace()>0) {
			System.out.println("车场里有"+ parking.getOccupiedPlace()+"辆车");
			for (CarOrder carOrder : parking.getCarOrderList()) {
				System.out.println("订单号\t\t车牌号\t车位号\t开始时间\t");
				System.out.println(carOrder.getOrderUp()+"\t"+carOrder.getCarNo()+"\t"+carOrder.getPlaceNo()+"\t"+getTime(carOrder.getBeginTime()));
			}
		} else {
			System.out.println("车场里没有车");
		}
	}
}
