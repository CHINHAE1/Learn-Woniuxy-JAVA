package com.Operation.Demo02.view;

import com.Operation.Demo02.controller.ProductManager;
import com.Operation.Demo02.domain.Product;

import java.util.Scanner;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/6/21 0:45
 * @version: 1.0
 */
public class ProductView {
        private ProductManager productManager;

        public ProductView(ProductManager productManager) {
            this.productManager = productManager;
        }

        public void displayMenu() {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("\n商品管理系统菜单:");
                System.out.println("1. 查询所有商品信息");
                System.out.println("2. 添加一条商品信息");
                System.out.println("3. 根据商品编号修改指定商品价格和库存");
                System.out.println("4. 删除所有的苹果手机");
                System.out.println("5. 查询价格最高的前三个商品信息");
                System.out.println("6. 查询2022-12录入的商品按照库存进行升序排序");
                System.out.println("7. 计算出所有华为旗下商品的平均价格");
                System.out.println("8. 查询出所有非华为旗下的所有商品中价格最高的商品信息");
                System.out.println("9. 根据品牌进行分组, 显示每个品牌的总数量以及每个品牌下具体的商品信息");
                System.out.println("10. 退出");
                System.out.print("请选择操作(1-10): ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        productManager.listAllProducts();
                        break;
                    case 2:
                        addProduct(scanner);
                        break;
                    case 3:
                        updateProduct(scanner);
                        break;
                    case 4:
                        productManager.deleteAppleProducts();
                        break;
                    case 5:
                        productManager.listTopThreeExpensiveProducts();
                        break;
                    case 6:
                        productManager.listDecember2022ProductsByStock();
                        break;
                    case 7:
                        productManager.calculateAveragePriceForHuawei();
                        break;
                    case 8:
//                        productManager.listMostExpensiveNonHuaweiProduct();
                        break;
                    case 9:
                        productManager.groupByBrand();
                        break;
                    case 10:
                        System.out.println("退出系统");
                        return;
                    default:
                        System.out.println("无效的选择，请重新输入");
                }
            }
        }

        private void addProduct(Scanner scanner) {
            System.out.println("请输入商品编号:");
            String id = scanner.nextLine();
            // 判断商品编号是否已经存在
            if (productManager.isProductExists(id)) {
                System.out.println("商品编号 " + id + " 已经存在。");
                return;
            }

            System.out.println("请输入商品名称:");
            String name = scanner.nextLine();
            System.out.println("请输入价格:");
            double price = scanner.nextDouble();
            System.out.println("请输入商品库存量:");
            int stock = scanner.nextInt();
            scanner.nextLine(); // consume newline
            System.out.println("请输入录入时间 (格式: YYYY-MM-DD):");
            String entryDate = scanner.nextLine();
            System.out.println("请输入品牌:");
            String brand = scanner.nextLine();

            Product product = new Product(id, name, price, stock, entryDate, brand);
            productManager.addProduct(product);
        }

        private void updateProduct(Scanner scanner) {
            System.out.println("请输入要修改的商品编号:");
            String id = scanner.nextLine();
            System.out.println("请输入新的价格:");
            double newPrice = scanner.nextDouble();
            System.out.println("请输入新的库存:");
            int newStock = scanner.nextInt();
            scanner.nextLine(); // consume newline

            productManager.updateProduct(id, newPrice, newStock);
        }
}
