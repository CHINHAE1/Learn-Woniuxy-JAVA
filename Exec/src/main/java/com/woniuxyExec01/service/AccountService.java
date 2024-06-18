package com.woniuxyExec01.service;

import com.woniuxyExec01.domain.Account;

import java.util.List;
import java.util.Map;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/6/17 17:22
 * @version: 1.0
 */
public interface AccountService {
    //  查看所有账户信息
    List<String> getAllAccounts();

    //  新增一条账户
    void addAccount(String accountId, String username, String gender, String phone, int balance, String profession);

    //  根据下标修改账户姓名
    boolean updateAccountNameByIndex(int index, String newName);

    //  根据下标删除账户信息
    boolean deleteAccountByIndex(int index);

    //  查询指定编号的账户信息
    Account queryAccountById(String accountId);

    //  查询所有性别是"女"的账户信息
    List<Account> getAccountsByGender(String gender);

    //  找出所有姓"杨"的账户信息
    List<Account> getAccountsBySurname(String surname);

    //  找出余额最高的账户信息
    Account getAccountWithHighestBalance();

    //  找出电话号码以"150"开头的账户信息
    List<Account> getAccountsByPhonePrefix(String prefix);

    //  根据职业统计出不同职业类型的人数，并显示出这些账户信息
    Map<String, List<Account>> countAccountsByProfession();
}
