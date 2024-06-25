package com.Operation.Demo03;


public class Product {
	private String productNumber;
	private String productName;
	private Double price;
	private int commodityStock;
	private String entryTime;
	private String brand;

	public Product() {
	}

	public Product(String productNumber, String productName, Double price, int commodityStock, String entryTime, String brand) {
		this.productNumber = productNumber;
		this.productName = productName;
		this.price = price;
		this.commodityStock = commodityStock;
		this.entryTime = entryTime;
		this.brand = brand;
	}

	/**
	 * 获取
	 * @return productNumber
	 */
	public String getProductNumber() {
		return productNumber;
	}

	/**
	 * 设置
	 * @param productNumber
	 */
	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}

	/**
	 * 获取
	 * @return productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * 设置
	 * @param productName
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * 获取
	 * @return price
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * 设置
	 * @param price
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	/**
	 * 获取
	 * @return commodityStock
	 */
	public int getCommodityStock() {
		return commodityStock;
	}

	/**
	 * 设置
	 * @param commodityStock
	 */
	public void setCommodityStock(int commodityStock) {
		this.commodityStock = commodityStock;
	}

	/**
	 * 获取
	 * @return entryTime
	 */
	public String getEntryTime() {
		return entryTime;
	}

	/**
	 * 设置
	 * @param entryTime
	 */
	public void setEntryTime(String entryTime) {
		this.entryTime = entryTime;
	}

	/**
	 * 获取
	 * @return brand
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * 设置
	 * @param brand
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String toString() {
		return "Product{productNumber = " + productNumber + ", productName = " + productName + ", price = " + price + ", commodityStock = " + commodityStock + ", entryTime = " + entryTime + ", brand = " + brand + "}";
	}
}
