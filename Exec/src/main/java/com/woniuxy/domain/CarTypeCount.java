package com.woniuxy.domain;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/6/17 10:14
 * @version: 1.0
 */
public class CarTypeCount {
    private String carType; // 汽车类型
    private int count;  //  数量

    public CarTypeCount(String carType) {
        this.carType = carType;
        this.count = 0;
    }

    public String getCarType() {
        return carType;
    }

    public int getCount() {
        return count;
    }

    public void increment() {
        this.count++;
    }
}
