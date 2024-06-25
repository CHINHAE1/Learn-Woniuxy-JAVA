package com.Operation.Demo02.controller;

import com.Operation.Demo02.domain.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/6/21 0:45
 * @version: 1.0
 */
public class ProductManager {
        private List<Product> products = new ArrayList<>();

        public ProductManager(Product[] initialProducts) {
            for (Product product : initialProducts) {
                products.add(product);
            }
        }

        // 检查商品是否存在
        public boolean isProductExists(String id) {
            for (Product product : products) {
                if (product.getId().equals(id)) {
                    return true;
                }
            }
            return false;
        }

        // 列出所有商品
        public void listAllProducts() {
            if (products.isEmpty()) {
                System.out.println("没有商品信息。");
                return;
            }
            for (Product product : products) {
                System.out.println(product);
            }
        }

        // 添加商品
        public void addProduct(Product product) {
            products.add(product);
            System.out.println("商品添加成功。");
        }

        // 更新商品信息
        public void updateProduct(String id, double newPrice, int newStock) {
            boolean found = false;
            for (Product product : products) {
                if (product.getId().equals(id)) {
                    product.setPrice(newPrice);
                    product.setStock(newStock);
                    found = true;
                    System.out.println("商品信息更新成功。");
                    break;
                }
            }
            if (!found) {
                System.out.println("商品编号 " + id + " 未找到。");
            }
        }

        // 删除所有的苹果手机
        public void deleteAppleProducts() {
            boolean found = false;
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getBrand().equalsIgnoreCase("Apple")) {
                    products.remove(i);
                    i--; // 调整索引以适应删除后的列表
                    found = true;
                }
            }
            if (found) {
                System.out.println("所有苹果手机已删除。");
            } else {
                System.out.println("没有找到苹果手机。");
            }
        }

        // 列出价格最高的前三个商品
        public void listTopThreeExpensiveProducts() {
            if (products.size() < 3) {
                System.out.println("商品数量不足3个，无法显示价格最高的前三个商品。");
                return;
            }
            products.stream()
                    .sorted(Comparator.comparingDouble(Product::getPrice).reversed())
                    .limit(3)
                    .forEach(System.out::println);
        }

        // 列出2022年12月录入的商品并按库存升序排序
        public void listDecember2022ProductsByStock() {
            List<Product> filteredProducts = products.stream()
                    .filter(product -> product.getEntryDate().startsWith("2022-12"))
                    .sorted(Comparator.comparingInt(Product::getStock))
                    .collect(Collectors.toList());

            if (filteredProducts.isEmpty()) {
                System.out.println("没有在2022年12月录入的商品。");
                return;
            }

            filteredProducts.forEach(System.out::println);
        }

        // 计算所有华为商品的平均价格
        public void calculateAveragePriceForHuawei() {
            double average = products.stream()
                    .filter(product -> product.getBrand().equalsIgnoreCase("华为"))
                    .mapToDouble(Product::getPrice)
                    .average()
                    .orElse(0.0);
            if (average == 0.0) {
                System.out.println("没有华为商品。");
            } else {
                System.out.println("华为商品的平均价格: " + average);
            }
        }

        // 列出价格最高的非华为商品
//        public void listMostExpensiveNonHuaweiProduct() {
//            products.stream()
//                    .filter(product -> !product.getBrand().equalsIgnoreCase("华为"))
//                    .max(Comparator.comparingDouble(Product::getPrice))
//                    .ifPresentOrElse(
//                            System.out::println,
//                            () -> System.out.println("没有非华为商品。")
//                    );
//        }

        // 按品牌分组并显示每个品牌的商品信息
        public void groupByBrand() {
            products.stream()
                    .collect(Collectors.groupingBy(Product::getBrand))
                    .forEach((brand, productList) -> {
                        System.out.println("品牌: " + brand + ", 总数量: " + productList.size());
                        productList.forEach(System.out::println);
                    });
        }

}
