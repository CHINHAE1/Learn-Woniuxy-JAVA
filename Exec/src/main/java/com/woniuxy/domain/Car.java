package com.woniuxy.domain;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/6/17 09:54
 * @version: 1.0
 */
public class Car {
    private String plate;
    private String carType;
    private String color;
    private int price;
    private String brand;

    public Car() {
    }

    public Car(String plate, String carType, String color, int price, String brand) {
        this.plate = plate;
        this.carType = carType;
        this.color = color;
        this.price = price;
        this.brand = brand;
    }

    /**
     * 获取
     * @return plate
     */
    public String getPlate() {
        return plate;
    }

    /**
     * 设置
     * @param plate
     */
    public void setPlate(String plate) {
        this.plate = plate;
    }

    /**
     * 获取
     * @return carType
     */
    public String getCarType() {
        return carType;
    }

    /**
     * 设置
     * @param carType
     */
    public void setCarType(String carType) {
        this.carType = carType;
    }

    /**
     * 获取
     * @return color
     */
    public String getColor() {
        return color;
    }

    /**
     * 设置
     * @param color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * 获取
     * @return price
     */
    public int getPrice() {
        return price;
    }

    /**
     * 设置
     * @param price
     */
    public void setPrice(int price) {
        this.price = price;
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
        return "车牌号 = " + plate + ", 汽车类型 = " + carType + ", 颜色 = " + color + ", 价格 = " + price + ", 品牌 = " + brand ;
    }
}

