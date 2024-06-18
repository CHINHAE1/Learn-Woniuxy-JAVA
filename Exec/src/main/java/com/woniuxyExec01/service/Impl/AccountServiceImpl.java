package com.woniuxyExec01.service.Impl;

import com.woniuxyExec01.dao.AccountDAO;
import com.woniuxyExec01.domain.Account;
import com.woniuxyExec01.service.AccountService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/6/17 17:36
 * @version: 1.0
 */
public class AccountServiceImpl implements AccountService {
    private AccountDAO accountDAO;

    public AccountServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    //  查看所有账户信息
    @Override
    public List<String> getAllAccounts() {
        List<String> result = new ArrayList<>();
        for (Account account : accountDAO.getAllAccounts()) {
            result.add(account.toString());
        }
        return result;
    }

    //  新增一条账户
    @Override
    public void addAccount(String accountId, String username, String gender, String phone, int balance, String profession) {
        accountDAO.addAccount(new Account(accountId, username, gender, phone, balance, profession));
    }

    //  根据下标修改账户姓名
    @Override
    public boolean updateAccountNameByIndex(int index, String newName) {
        return accountDAO.updateAccountNameByIndex(index, newName);
    }

    //  根据下标删除账户信息
    @Override
    public boolean deleteAccountByIndex(int index) {
        return accountDAO.deleteAccountByIndex(index);
    }

    //  查询指定编号的账户信息
    @Override
    public Account queryAccountById(String accountId) {
        return accountDAO.queryAccountById(accountId);
    }

    //  查询所有性别是女的账户信息
    @Override
    public List<Account> getAccountsByGender(String gender) {
        List<Account> result = new ArrayList<>();
        for (Account account : accountDAO.getAllAccounts()) {
            //  比较性别是否相同
            if (account.getGender().equals(gender)) {
                //  添加到结果集中
                result.add(account);
            }
        }
        return result;
    }

    //  找出所有姓杨的账户信息
    @Override
    public List<Account> getAccountsBySurname(String surname) {
        List<Account> result = new ArrayList<>();
        for (Account account : accountDAO.getAllAccounts()) {
            //  姓名以surname开头
            if (account.getUsername().startsWith(surname)) {
                //  添加到结果集中
                result.add(account);
            }
        }
        return result;
    }

    //  找出余额最高的账户信息
    @Override
    public Account getAccountWithHighestBalance() {
        //  使用Stream流API获取最大值
        return accountDAO.getAllAccounts().stream().max(Comparator.comparingInt(Account::getBalance)).orElse(null);
    }

    //  找出电话号码以150开头的账户信息
    @Override
    public List<Account> getAccountsByPhonePrefix(String prefix) {
        List<Account> result = new ArrayList<>();
        for (Account account : accountDAO.getAllAccounts()) {
            if (account.getPhone().startsWith(prefix)) {
                result.add(account);
            }
        }
        return result;
    }

    //  根据职业统计出不同职业类型的人数，并显示出这些账户信息
    @Override
    public Map<String, List<Account>> countAccountsByProfession() {
        //  创建Map对象
        Map<String, List<Account>> professionMap = new HashMap<>();
        for (Account account : accountDAO.getAllAccounts()) {
            //  如果不存在，则创建.
            //  使用Lambda表达式创建List对象,简化之前的代码
             /* 之前的代码是:
              if (!professionMap.containsKey(account.getProfession())) {
                  professionMap.put(account.getProfession(), new ArrayList<>());
              }*/
            professionMap.computeIfAbsent(account.getProfession(), k -> new ArrayList<>()).add(account);
        }
        //  返回结果
        return professionMap;
    }
}


