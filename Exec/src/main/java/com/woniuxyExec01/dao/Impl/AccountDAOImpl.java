package com.woniuxyExec01.dao.Impl;

import com.woniuxyExec01.dao.AccountDAO;
import com.woniuxyExec01.domain.Account;

import java.util.ArrayList;
import java.util.List;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/6/17 17:24
 * @version: 1.0
 */
public class AccountDAOImpl implements AccountDAO {
    //  存储账户信息的列表
    private List<Account> accounts = new ArrayList<>();

    public AccountDAOImpl(String[] accountData) {
        for (String data : accountData) {
            String[] parts = data.split("-");
            accounts.add(new Account(parts[0], parts[1], parts[2], parts[3], Integer.parseInt(parts[4]), parts[5]));
        }
    }

    //  查看所有账户信息
    @Override
    public List<Account> getAllAccounts() {
        //  返回一个新的列表，防止修改原列表
        return new ArrayList<>(accounts);
    }

    //  新增一条账户
    @Override
    public void addAccount(Account account) {
        //  添加到列表中
        accounts.add(account);
    }

    //  根据下标修改账户姓名
    @Override
    public boolean updateAccountNameByIndex(int index, String newName) {
        //  下标有效
        if (index >= 0 && index < accounts.size()) {
            //  修改姓名
            accounts.get(index).setUsername(newName);
            return true;
        }
        return false;
    }

    //  根据下标删除账户
    @Override
    public boolean deleteAccountByIndex(int index) {
        if (index >= 0 && index < accounts.size()) {
            //  删除元素
            accounts.remove(index);
            return true;
        }
        return false;
    }

    //  根据账户ID查询账户信息
    @Override
    public Account queryAccountById(String accountId) {
        for (Account account : accounts) {
            if (account.getAccountId().equals(accountId)) {
                return account;
            }
        }
        return null;
    }
}


