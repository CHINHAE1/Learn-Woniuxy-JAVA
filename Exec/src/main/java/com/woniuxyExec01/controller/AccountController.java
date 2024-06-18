package com.woniuxyExec01.controller;

import com.woniuxyExec01.domain.Account;
import com.woniuxyExec01.service.AccountService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/6/17 17:21
 * @version: 1.0
 */
public class AccountController {
    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    //  查看所有账户信息
    public void viewAllAccounts() {
        List<String> accounts = accountService.getAllAccounts();
        for (String account : accounts) {
            System.out.println(account);
        }
    }

    //  2. 新增一条账户信息
    public void addAccount(String accountId, String username, String gender, String phone, int balance, String profession) {
        accountService.addAccount(accountId, username, gender, phone, balance, profession);
        System.out.println("账户添加成功!");
    }

    //  3. 根据下标修改账户姓名
    public void updateAccountNameByIndex(int index, String newName) {
        if (accountService.updateAccountNameByIndex(index, newName)) {
            System.out.println("账户姓名更新成功!");
        } else {
            System.out.println("无效的下标.");
        }
    }

    //  4. 根据下标删除账户信息
    public void deleteAccountByIndex(int index) {
        if (accountService.deleteAccountByIndex(index)) {
            System.out.println("账户删除成功!");
        } else {
            System.out.println("无效的下标.");
        }
    }

    //  5.查询指定编号的账户信息
    public void queryAccountById(String accountId) {
        Account account = accountService.queryAccountById(accountId);
        if (account != null) {
            System.out.println("查询结果: " + account);
        } else {
            System.out.println("未找到指定编号的账户.");
        }
    }

    //  6. 查询所有性别是"女"的账户信息
    public void viewAccountsByGender(String gender) {
        List<Account> accounts = accountService.getAccountsByGender(gender);
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    //  7. 找出所有姓"杨"的账户信息
    public void viewAccountsBySurname(String surname) {
        List<Account> accounts = accountService.getAccountsBySurname(surname);
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    //  8. 找出余额最高的账户信息
    public void viewAccountWithHighestBalance() {
        Account account = accountService.getAccountWithHighestBalance();
        if (account != null) {
            System.out.println("余额最高的账户信息: " + account);
        } else {
            System.out.println("未找到账户.");
        }
    }

    //  9. 找出电话号码以"150"开头的账户信息
    public void viewAccountsByPhonePrefix(String prefix) {
        List<Account> accounts = accountService.getAccountsByPhonePrefix(prefix);
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    //  10. 根据职业统计出不同职业类型的人数，并显示出这些账户信息
    public void viewAccountsByProfession() {
        Map<String, List<Account>> professionMap = accountService.countAccountsByProfession();
        for (Map.Entry<String, List<Account>> entry : professionMap.entrySet()) {
            System.out.println("职业: " + entry.getKey() + ", 总数: " + entry.getValue().size());
            for (Account account : entry.getValue()) {
                System.out.println(account);
            }
        }
    }
}


