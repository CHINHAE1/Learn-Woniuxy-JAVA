package com.woniuxyExec01.domain;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/6/17 17:32
 * @version: 1.0
 */
public class Account {
    private String accountId;   //  账户编号
    private String username;    //  用户名
    private String gender;  //  性别
    private String phone;   //  手机号
    private int balance;    //  余额
    private String profession;  //  职业

    public Account(String accountId, String username, String gender, String phone, int balance, String profession) {
        this.accountId = accountId;
        this.username = username;
        this.gender = gender;
        this.phone = phone;
        this.balance = balance;
        this.profession = profession;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public String getPhone() {
        return phone;
    }

    public int getBalance() {
        return balance;
    }

    public String getProfession() {
        return profession;
    }

    @Override
    public String toString() {
        return accountId + "-" + username + "-" + gender + "-" + phone + "-" + balance + "-" + profession;
    }
}


