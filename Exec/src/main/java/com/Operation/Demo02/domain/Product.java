package com.Operation.Demo02.domain;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/6/21 0:44
 * @version: 1.0
 */
public class Product {
        private String id;
        private String name;
        private double price;
        private int stock;
        private String entryDate;
        private String brand;

        public Product(String id, String name, double price, int stock, String entryDate, String brand) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.stock = stock;
            this.entryDate = entryDate;
            this.brand = brand;
        }

        // Getters and Setters
        public String getId() {
            return id;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public void setStock(int stock) {
            this.stock = stock;
        }

        public double getPrice() {
            return price;
        }

        public int getStock() {
            return stock;
        }

        public String getEntryDate() {
            return entryDate;
        }

        public String getBrand() {
            return brand;
        }

        @Override
        public String toString() {
            return "商品编号: " + id + ", 商品名称: " + name + ", 价格: " + price + ", 库存: " + stock + ", 录入时间: " + entryDate + ", 品牌: " + brand;
        }

}
