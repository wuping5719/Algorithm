package com.myra.design.pattern.bridge;

public class TestBridge {

	public static void main(String[] args) {
       double width = 68;
       double height = 30;
       int floorNumber = 8;
       double unitPrice = 6800;
       
       BuildingDesign design = new HouseDesign(width, height, floorNumber);
       System.out.println("宽: " + width + " 米, " + "高: " + height +" 米, 层数为: " + floorNumber);
       
       ArchitectureCost cost = new BuildingCost(design, unitPrice);
       double price = cost.giveCost();
       System.out.printf("每平米地价：" + unitPrice + " 元的商业楼的建设成本：%2f 元。\n", price);
       
       width = 52;
       height = 28;
       floorNumber = 6;
       unitPrice = 3000;
       
       design = new HouseDesign(width, height, floorNumber);
       System.out.println("宽: " + width + " 米, " + "高: " + height +" 米, 层数为: " + floorNumber);
       
       cost = new BuildingCost(design, unitPrice);
       price = cost.giveCost();
       System.out.printf("每平米地价：" + unitPrice + " 元的住宅楼的建设成本：%2f 元。\n", price);
       
	}

}
