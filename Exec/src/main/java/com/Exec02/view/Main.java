package com.Exec02.view;

import com.Exec02.controller.DrugController;
import com.Exec02.dao.Impl.DrugDaoImpl;
import com.Exec02.domain.Drug;
import com.Exec02.service.Impl.DrugServiceImpl;
import java.util.Scanner;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/6/18 09:42
 * @version: 1.0
 */
public class Main {
  public static void main(String[] args) {
    DrugController controller = new DrugController(new DrugServiceImpl(new DrugDaoImpl()));

    Scanner scanner = new Scanner(System.in);

    while (true) {
      System.out.println("药品管理系统菜单:");
      System.out.println("1、查询所有药品信息");
      System.out.println("2、添加一条药品信息");
      System.out.println("3、根据药品编号修改药品详情中的单价、库存、产地信息");
      System.out.println("4、根据编号删除指定药品信息");
      System.out.println("5、根据编号查询指定车药品信息");
      System.out.println("6、显示进价高于15元在南京生产的药品信息");
      System.out.println("7、计算指定地区药品的售卖的平均价格");
      System.out.println("8、找出售卖价格最高的药品信息");
      System.out.println("9、根据药品的进价进行升序排序");
      System.out.println("10、统计不同产地的药品总数及详细的商品信息");
      System.out.println("0. 退出");
      System.out.print("请选择操作: ");
      int choice = scanner.nextInt(); // 获取用户选择的操作
      scanner.nextLine(); // 消耗换行符

      switch (choice) {
        case 1:
          // 查询所有药品信息
          controller.getAllDrugs();
          break;
        case 2:
          // 添加药品信息
          System.out.println("输入药品信息 (格式: 编号-名称-产地-进价-单价-库存):");
          String[] drugInfo = scanner.nextLine().split("-");
          Drug newDrug =
              new Drug(
                  drugInfo[0],
                  drugInfo[1],
                  drugInfo[2],
                  Double.parseDouble(drugInfo[3]),
                  Double.parseDouble(drugInfo[4]),
                  Integer.parseInt(drugInfo[5]));
          controller.addDrug(newDrug);
          break;
        case 3:
          // 修改药品信息
          System.out.println("输入需要修改的药品编号:");
          String updateId = scanner.nextLine();
          double newPrice = getDoubleInput(scanner, "输入新的单价:");
          int newStock = getIntInput(scanner, "输入新的库存:");
          System.out.println("输入新的产地:");
          String newOrigin = scanner.nextLine();
          controller.updateDrug(updateId, newPrice, newStock, newOrigin);
          break;
        case 4:
          // 删除药品信息
          System.out.println("输入需要删除的药品编号:");
          String deleteId = scanner.nextLine();
          controller.deleteDrug(deleteId);
          break;
        case 5:
          // 查询指定药品信息
          System.out.println("输入需要查询的药品编号:");
          String searchId = scanner.nextLine();
          controller.getDrugById(searchId);
          break;
        case 6:
          // 显示进价高于15元在南京生产的药品信息
          controller.getDrugsByPriceAndOrigin(15, "南京");
          break;
        case 7:
          // 计算指定地区药品的售卖的平均价格
          System.out.println("输入需要计算平均价格的产地:");
          String avgOrigin = scanner.nextLine();
          controller.getAveragePriceByOrigin(avgOrigin);
          break;
        case 8:
          // 找出售卖价格最高的药品信息
          controller.getHighestSellingPriceDrug();
          break;
        case 9:
          // 根据药品的进价进行升序排序
          controller.sortDrugsByPurchasePrice();
          break;
        case 10:
          // 统计不同产地的药品总数及详细的商品信息
          controller.getDrugsGroupedByOrigin();
          break;
        case 0:
          // 退出系统
          System.out.println("退出系统");
          scanner.close(); // 关闭Scanner对象
          return; // 结束程序
        default:
          System.out.println("无效选择，请重新输入");
      }
    }
  }

  /**
   * 获取整数输入
   * @param scanner Scanner对象，用于读取用户输入
   * @param message 提示用户输入的信息
   * @return 用户输入的整数值
   */
  private static int getIntInput(Scanner scanner, String message) {
    System.out.println(message);
    while (!scanner.hasNextInt()) {
      System.out.println("无效输入，请输入整数。");
      scanner.next();
    }
    return scanner.nextInt();
  }

  /**
   * 获取浮点数输入
   * @param scanner Scanner对象，用于读取用户输入
   * @param message 提示用户输入的信息
   * @return 用户输入的浮点数值
   */

  private static double getDoubleInput(Scanner scanner, String message) {
    System.out.println(message);
    while (!scanner.hasNextDouble()) {
      System.out.println("无效输入，请输入数字。");
      scanner.next();
    }
    return scanner.nextDouble();
  }
}
