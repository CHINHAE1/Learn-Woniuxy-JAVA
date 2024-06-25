package com.Exec03.dao;

import com.Exec03.bean.Product;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/6/23 21:00
 * @version: 1.0
 */
public class ProductDao {
    private  Database db = new Database();
    //	1.查询所有商品信息
    public List<Product> findProduct() {
        List<Product> products = db.getProducts();
        return products;
    }
    //2.添加一条商品信息
    public void addProduct(Product product) {
        List<Product> products = db.getProducts();
        products.add(product);
    }
    //判断id是否存在
    public boolean isEx(String id) {
        List<Product> products = db.getProducts();

        for(Product product : products) {
            if(product.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
    //3.根据商品编号修改指定商品价格和库存
    public void updateProduct(Product product) {
        List<Product> products = db.getProducts();
        for(Product p : products) {
            if(p.getId().equals(product.getId())) {
                p.setProductPrice(product.getProductPrice());
                p.setProductCount(product.getProductCount());
                break;
            }
        }

    }
    //4.删除所有的苹果手机
    public void delProduct() {
        Iterator<Product> it = db.getProducts().iterator();
        while(it.hasNext()) {
            Product product = it.next();
            if(product.getBrand().equals("Apple")) {
                it.remove();
            }
        }
    }
//5.查询价格最高的前三个商品信息

    //6.查询2022-12录入的商品按照库存进行升序排序
    public List<Product> sortProduct() {
        List<Product> list = new ArrayList<>();

        for(Product p : db.getProducts()) {
            if(p.getTime().equals("2022-12-12")) {
                list.add(p);
            }
        }
        Collections.sort(list,new Comparator<Product>() {

            @Override
            public int compare(Product p1, Product p2) {

                return p1.getProductCount() - p2.getProductCount();

            }
        });
        return list;
    }
//7.计算出所有华为旗下商品的平均价格

//8.查询出所有非华为旗下的所有商品中价格最高的商品信息

//9.根据品牌进行分组,显示每个品牌的总数量以及每个品牌下具体的商品信息
}
