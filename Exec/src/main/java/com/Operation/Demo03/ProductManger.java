package com.Operation.Demo03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ProductManger {
	static Scanner scan = new Scanner(System.in);
	static List<Product> products = new ArrayList<>();
	public static void main(String[] args) {
		Product products1 = new Product("20230112200501","vivo S16",2699.0,900,"2023-01-01","vivo");
		Product products2 = new Product("20230112200502","华为P40 pro",6499.0,900,"2023-01-01","vivo");
		Product products3 = new Product("20230112200501","vivo S16",2699.0,900,"2023-01-01","vivo");
		Product products4 = new Product("20230112200501","vivo S16",2699.0,900,"2023-01-01","vivo");
		Product products5 = new Product("20230112200501","vivo S16",2699.0,900,"2023-01-01","vivo");
		Product products6 = new Product("20230112200501","vivo S16",2699.0,900,"2023-01-01","vivo");
		products.add(products1);
		products.add(products2);
		products.add(products3);
		products.add(products4);
		products.add(products5);
		products.add(products6);
		boolean isLoop = true;
		while(isLoop) {
			System.out.println("1.查询所有商品信息？");
			System.out.println("2.添加一条商品信息？");
			System.out.println("3.根据商品编号修改指定商品价格和库存");
			System.out.println("4.删除所有的苹果手机");
			System.out.println("5.查询价格最高的前三个商品信息");
			System.out.println("6.查询2022-12录入的商品按照库存进行升序排序？");
			System.out.println("7.计算出所有华为旗下商品的平均价格");
			System.out.println("8.查询出所有非华为旗下的所有商品中价格最高的商品信息");
			System.out.println("9.根据品牌进行分组,显示每个品牌的总数量以及每个品牌下具体的商品信息");
			System.out.println("10.退出系统");
			int num = scan.nextInt();
			switch(num) {
			case 1 :
				findProduct();
				break;
			case 2 :
				addProduct();
				break;
			case 3 :
				updateProduct();
				break;
			case 4 :
				delProduct();
				break;
			case 5 :
				findMaxPriceProduct();
				break;
			case 6 :
				sortProduct();
				break;
			case 7 :
				findProduct();
				break;
			case 8 :
				averagePriceProduct();
				break;
			case 9 :
				groupProduct();
				break;
			case 10 :
				System.out.println("退出成功");
				isLoop = false;
				break;
				default:
					System.out.println("输入错误，重新输入");
			}
		}

	}
	private static void groupProduct() {
		// TODO Auto-generated method stub
		
	}
	private static void averagePriceProduct() {
		// TODO Auto-generated method stub
		
	}
//	6.查询2022-12录入的商品按照库存进行升序排序
	private static void sortProduct() {
		// TODO Auto-generated method stub
		
	}
//	5.查询价格最高的前三个商品信息
	private static void findMaxPriceProduct() {
		// TODO Auto-generated method stub
		
	}
//	4.删除所有的苹果手机
	private static void delProduct() {
		// TODO Auto-generated method stub
		
	}
//	3.根据商品编号修改指定商品价格和库存
	private static void updateProduct() {
		
		
	}
//	2.添加一条商品信息
	private static void addProduct() {
		System.out.println("请输入商品编号");
		String id = scan.next();
		for(Product p : products) {
      if (p.getProductNumber().equals(id)) {
        System.out.println("你输入的" + id + "已经存在");
			}
		}
		System.out.println("请输入商品名称");
		String productName = scan.next();
		System.out.println("请输入商品价格");
		double price = scan.nextDouble();
		System.out.println("请输入商品库存量");
		int commodityStock = scan.nextInt();
		System.out.println("请输入商品时间");
		String entryTime = scan.next();
		System.out.println("请输入商品品牌");
		String brand = scan.next();
		Product t = new Product(id,productName,price,commodityStock,entryTime,brand);
		products.add(t);
		System.out.println("添加成功");
		
	}
	private static int isEx(String id) {
		for(int i = 0;i < products.size();i++) {
			Product u = products.get(i);
			if(u.getProductNumber().equals(id)) {
				return i;
			}
		}
		return -1;
	}
	private static void findProduct() {
		for(Product p : products) {
			System.out.println(p);
		}
		
	}
}
