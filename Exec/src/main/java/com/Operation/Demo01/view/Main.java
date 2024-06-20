package com.Operation.Demo01.view;

import com.Operation.Demo01.controller.CustomerManager;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/6/20 18:15
 * @version: 1.0
 */
public class Main {
  public static void main(String[] args) {
    String[] customerData = {
      "2023122214-杜琼瑶-女-8888-12/22",
      "2023122215-范建-男-10000-12/21",
      "2023122216-范桃花-女-12000-12/20",
      "2023122217-范醉-男-11500-12/20"
    };

    CustomerManager manager = new CustomerManager(customerData);
    CustomerView view = new CustomerView(manager);

    view.displayMenu();
  }
}
