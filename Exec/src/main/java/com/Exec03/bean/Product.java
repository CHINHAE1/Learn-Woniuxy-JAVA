package com.Exec03.bean;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/6/23 20:59
 * @version: 1.0
 */
public class Product {
    private String id;
    private String productName;
    private double productPrice;
    private int productCount;
    private String time;
    private String brand;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public double getProductPrice() {
        return productPrice;
    }
    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
    public int getProductCount() {
        return productCount;
    }
    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    @Override
    public String toString() {
        return "Product [id=" + id + ", productName=" + productName + ", productPrice=" + productPrice
                + ", productCount=" + productCount + ", time=" + time + ", brand=" + brand + "]";
    }
    public Product(String id, String productName, double productPrice, int productCount, String time, String brand) {
        super();
        this.id = id;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productCount = productCount;
        this.time = time;
        this.brand = brand;
    }
    public Product() {
        super();
    }

}
