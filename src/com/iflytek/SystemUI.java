package com.iflytek;

import java.util.Scanner;

public class SystemUI {
	private Scanner scanner = new Scanner(System.in);
	private  int index;
	
	public static void main(String[] args) {
		new SystemUI().showMainMenu();
	}

	private void showMainMenu() {
		System.out.println("====================欢迎你进入停车场管理系统===================\n");
		System.out.print("1.汽车进站登记  2.汽车出站登记  3.车位状态显示  4.退出系统\n请选择序号：");
		index = scanner.nextInt();
		System.out.println();
		
		switch (index) {
		case 1:
			
			break;
		case 2:
			
			break;
		case 3:
			showParkMenu();
			break;
		case 4:
			
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
			
			break;
		case 2:
			
			break;
		case 3:
			showMainMenu();
			break;
		
		default:
			break;
		}
	}
}
