package com.Exec03.view;

import com.Exec03.dao.ProductDao;
import com.Exec03.util.IDutils;
import com.Exec03.bean.Product;

import java.util.List;
import java.util.Scanner;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/6/23 21:02
 * @version: 1.0
 */
public class ProductView {
    private static ProductDao dao  =  new ProductDao();
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        boolean isLoop = true;
        while(isLoop) {

            System.out.println("1.查询所有商品信息");
            System.out.println("2.添加一条商品信息");
            System.out.println("3.根据商品编号修改指定商品价格和库存");
            System.out.println("4.删除所有的苹果手机");
            System.out.println("5.查询价格最高的前三个商品信息");
            System.out.println("6.查询2022-12录入的商品按照库存进行升序排序");
            System.out.println("7.计算出所有华为旗下商品的平均价格");
            System.out.println("8.查询出所有非华为旗下的所有商品中价格最高的商品信息");
            System.out.println("9.根据品牌进行分组,显示每个品牌的总数量以及每个品牌下具体的商品信息");
            System.out.println("10.退出");

            System.out.println("请选择功能：");
            int num = scan.nextInt();
            switch(num) {
                case 1:
                    findProduct();
                    break;
                case 2:
                    addProduct();
                    break;
                case 3:
                    updateProduct();
                    break;
                case 4:
                    delProduct();
                    break;
                case 5:
                    findMaxProduct();
                    break;
                case 6:
                    System.out.println("调用 sortProduct()");
                    sortProduct();
                    break;
                case 7:
                    averageProduct();
                    break;
                case 8:
                    findPriceMaxProduct();
                    break;
                case 9:
                    groupProduct();
                    break;
                case 10:
                    System.out.println("退出成功");
                    break;

                default:
                    System.out.println("你的输入有误，请重新输入！");
                    break;
            }
        }
    }
    //9.根据品牌进行分组,显示每个品牌的总数量以及每个品牌下具体的商品信息
    private static void groupProduct() {
        // TODO Auto-generated method stub

    }
    //8.查询出所有非华为旗下的所有商品中价格最高的商品信息
    private static void findPriceMaxProduct() {
        // TODO Auto-generated method stub

    }
    //7.计算出所有华为旗下商品的平均价格
    private static void averageProduct() {
        // TODO Auto-generated method stub

    }
    //6.查询2022-12录入的商品按照库存进行升序排序
    private static void sortProduct() {
        List<Product> list = dao.sortProduct();
        System.out.println("排序后的产品列表：");
        if (list.isEmpty()) {
            System.out.println("没有找到符合条件的商品。");
        } else {
            list.forEach(System.out::println);
        }
    }
    //5.查询价格最高的前三个商品信息
    private static void findMaxProduct() {


    }
    //4.删除所有的苹果手机
    private static void delProduct() {
        dao.delProduct();
        System.out.println("删除成功！");

    }
    //3.根据商品编号修改指定商品价格和库存
    private static void updateProduct() {
        System.out.println("请输入商品编号");
        String id = scan.next();

        boolean flag = dao.isEx(id);
        if(flag) {
            System.out.println("请输入修改的商品价格");
            double price = scan.nextDouble();
            System.out.println("请输入修改的商品库存");
            int count = scan.nextInt();

            Product product = new Product(id,null,price,count,null,null);
            dao.updateProduct(product);
            System.out.println("修改成功");
        }else {
            System.out.println("你输入的"+ id + "不存在");
        }
    }
    //2.添加一条商品信息
    private static void addProduct() {
        System.out.println("请输入商品名称");
        String name = scan.next();
        System.out.println("请输入商品价格");
        Double price = scan.nextDouble();
        System.out.println("请输入商品库存");
        int count = scan.nextInt();
        System.out.println("请输入商品入库时间");
        String time = scan.next();
        System.out.println("请输入商品品牌");
        String brand = scan.next();
        long productID = IDutils.getTimeId();

        Product product = new Product(productID+"",name,price,count,time,brand);
        dao.addProduct(product);
        System.out.println("添加成功");
    }
    //	1.查询所有商品信息
    private static void findProduct() {
        List<Product> products = dao.findProduct();
        for(Product product : products) {
            System.out.println(product);
        }
    }
}
