package com.Exec02.domain;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/6/18 09:41
 * @version: 1.0
 */
public class Drug {
    private String id; // 药品编号
    private String name; // 药品名称
    private String origin; // 产地
    private double purchasePrice; // 进价
    private double sellingPrice; // 单价
    private int stock; // 库存

    public Drug() {
    }

    public Drug(String id, String name, String origin, double purchasePrice, double sellingPrice, int stock) {
        this.id = id;
        this.name = name;
        this.origin = origin;
        this.purchasePrice = purchasePrice;
        this.sellingPrice = sellingPrice;
        this.stock = stock;
    }

    /**
     * 获取
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return origin
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * 设置
     * @param origin
     */
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    /**
     * 获取
     * @return purchasePrice
     */
    public double getPurchasePrice() {
        return purchasePrice;
    }

    /**
     * 设置
     * @param purchasePrice
     */
    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    /**
     * 获取
     * @return sellingPrice
     */
    public double getSellingPrice() {
        return sellingPrice;
    }

    /**
     * 设置
     * @param sellingPrice
     */
    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    /**
     * 获取
     * @return stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * 设置
     * @param stock
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

  public String toString() {
    return "药品{药品编号 = "
        + id
        + ", 药品名称 = "
        + name
        + ", 产地 = "
        + origin
        + ", 进价 = "
        + purchasePrice
        + ", 单价 = "
        + sellingPrice
        + ", 库存 = "
        + stock
        + "}";
        }
}
