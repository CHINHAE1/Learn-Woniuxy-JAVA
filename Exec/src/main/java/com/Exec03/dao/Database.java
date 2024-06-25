package com.Exec03.dao;

import com.Exec03.bean.Product;
import java.util.ArrayList;
import java.util.List;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/6/23 21:00
 * @version: 1.0
 */
public class Database {

    private List<Product> products;

    public Database() {
        Product p1 = new Product("20230112200501","vivo S16",2699,900,"2023-01-01","vivo");
        Product p2 = new Product("20230112200502","华为P40 pro",6499.0,1000,"2022-12-12","华为");
        Product p3 = new Product("20230112200503","华为Mate 50",5999,800,"2022-12-30","华为");
        Product p4 = new Product("20230112200504","小米13 Pro",6299,2000,"2022-12-18","小米");
        Product p5 = new Product("20230112200505","iphone14 pro",8899,3000,"2022-12-10","Apple");
        Product p6 = new Product("20230112200506","三星 S22",8099,3100,"2022-11-11","三星");

        products = new ArrayList<>();

        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);
        products.add(p5);
        products.add(p6);

    }

    public List<Product> getProducts() {
        return products;
    }
}