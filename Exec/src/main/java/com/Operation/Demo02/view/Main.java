package com.Operation.Demo02.view;

import com.Operation.Demo02.controller.ProductManager;
import com.Operation.Demo02.domain.Product;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/6/21 0:43
 * @version: 1.0
 */
public class Main {
        public static void main(String[] args) {
            Product[] initialProducts = {
                    new Product("20230112200501", "vivo S16", 2699, 900, "2023-01-01", "vivo"),
                    new Product("20230112200502", "华为P40 pro", 6499.0, 1000, "2022-12-12", "华为"),
                    new Product("20230112200503", "华为Mate 50", 5999, 800, "2022-12-30", "华为"),
                    new Product("20230112200504", "小米13 Pro", 6299, 2000, "2022-12-18", "小米"),
                    new Product("20230112200505", "iphone14 pro", 8899, 3000, "2022-12-10", "Apple"),
                    new Product("20230112200506", "三星 S22", 8099, 3100, "2022-11-11", "三星")
            };

            ProductManager manager = new ProductManager(initialProducts);
            ProductView view = new ProductView(manager);

            view.displayMenu();
        }
}
