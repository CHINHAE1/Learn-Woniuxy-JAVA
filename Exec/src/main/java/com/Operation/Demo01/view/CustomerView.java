package com.Operation.Demo01.view;

import com.Operation.Demo01.controller.CustomerManager;
import com.Operation.Demo01.domain.Customer;

import java.util.Scanner;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/6/20 18:14
 * @version: 1.0
 */
public class CustomerView {
  private CustomerManager customerManager;

  public CustomerView(CustomerManager customerManager) {
    this.customerManager = customerManager;
  }

  public void displayMenu() {
    Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.println("\n客户管理系统菜单:");
      System.out.println("1. 查询所有客户信息");
      System.out.println("2. 添加一条客户信息");
      System.out.println("3. 修改客户姓名和生日");
      System.out.println("4. 删除客户信息");
      System.out.println("5. 退出");
      System.out.print("请选择操作(1-5): ");
      int choice = scanner.nextInt();
      scanner.nextLine(); // consume newline

      switch (choice) {
        case 1:
          displayAllCustomers();
          break;
        case 2:
          addCustomer();
          break;
        case 3:
          updateCustomer();
          break;
        case 4:
          deleteCustomer();
          break;
        case 5:
          System.out.println("退出系统");
          return;
        default:
          System.out.println("无效的选择，请重新输入");
      }
    }
  }

  public void displayAllCustomers() {
    for (Customer customer : customerManager.getAllCustomers()) {
      System.out.println(customer);
    }
  }

  public void addCustomer() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("请输入客户编号:");
    String id = scanner.nextLine();
    System.out.println("请输入客户姓名:");
    String name = scanner.nextLine();
    System.out.println("请输入客户性别:");
    String gender = scanner.nextLine();
    System.out.println("请输入客户余额:");
    int balance = scanner.nextInt();
    scanner.nextLine(); // consume newline
    System.out.println("请输入客户生日:");
    String birthDate = scanner.nextLine();

    customerManager.addCustomer(id, name, gender, balance, birthDate);
  }

  public void updateCustomer() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("请输入要修改的客户编号:");
    String id = scanner.nextLine();
    System.out.println("请输入新的客户姓名:");
    String newName = scanner.nextLine();
    System.out.println("请输入新的客户生日:");
    String newBirthDate = scanner.nextLine();

    customerManager.updateCustomer(id, newName, newBirthDate);
  }

  public void deleteCustomer() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("请输入要删除的客户编号:");
    String id = scanner.nextLine();

    customerManager.deleteCustomer(id);
  }
}
