package com.Operation.Demo01.controller;

import com.Operation.Demo01.domain.Customer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/6/20 18:13
 * @version: 1.0
 */
public class CustomerManager {
  private List<Customer> customers = new ArrayList<>();

  public CustomerManager(String[] customerData) {
    for (String data : customerData) {
      String[] parts = data.split("-");
      String id = parts[0];
      String name = parts[1];
      String gender = parts[2];
      int balance = Integer.parseInt(parts[3]);
      String birthDate = parts[4];
      customers.add(new Customer(id, name, gender, balance, birthDate));
    }
  }

  public List<Customer> getAllCustomers() {
    return customers;
  }

  public void addCustomer(String id, String name, String gender, int balance, String birthDate) {
    customers.add(new Customer(id, name, gender, balance, birthDate));
  }

  public void updateCustomer(String id, String newName, String newBirthDate) {
    for (Customer customer : customers) {
      if (customer.getId().equals(id)) {
        customer.setName(newName);
        customer.setBirthDate(newBirthDate);
        return;
      }
    }
    System.out.println("客户编号 " + id + " 未找到。");
  }

  public void deleteCustomer(String id) {
    Iterator<Customer> iterator = customers.iterator();
    while (iterator.hasNext()) {
      Customer customer = iterator.next();
      if (customer.getId().equals(id)) {
        iterator.remove();
        return;
      }
    }
    System.out.println("客户编号 " + id + " 未找到。");
  }
}
