package com.woniuxyExec01.dao;

import com.woniuxyExec01.domain.Account;

import java.util.List;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/6/17 17:25
 * @version: 1.0
 */
public interface AccountDAO {
    //  查看所有账户信息
    List<Account> getAllAccounts();

    //  新增一条账户
    void addAccount(Account account);

    //  根据下标修改账户姓名
    boolean updateAccountNameByIndex(int index, String newName);

    //  根据下标删除账户信息
    boolean deleteAccountByIndex(int index);

    //  查询指定编号的账户信息
    Account queryAccountById(String accountId);
}



