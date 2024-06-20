package com.Operation.Demo01.domain;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/6/20 18:12
 * @version: 1.0
 */
public class Customer {
  private String id;
  private String name;
  private String gender;
  private int balance;
  private String birthDate;

  public Customer(String id, String name, String gender, int balance, String birthDate) {
    this.id = id;
    this.name = name;
    this.gender = gender;
    this.balance = balance;
    this.birthDate = birthDate;
  }

  public String getId() {
    return id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setBirthDate(String birthDate) {
    this.birthDate = birthDate;
  }

  @Override
  public String toString() {
    return "客户编号: " + id + ", 姓名: " + name + ", 性别: " + gender + ", 余额: " + balance + ", 生日: "
        + birthDate;
  }
}
