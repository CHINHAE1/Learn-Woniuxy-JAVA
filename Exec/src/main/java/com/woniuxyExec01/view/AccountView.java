package com.woniuxyExec01.view;

import com.woniuxyExec01.controller.AccountController;
import com.woniuxyExec01.dao.Impl.AccountDAOImpl;
import com.woniuxyExec01.service.Impl.AccountServiceImpl;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/6/17 17:20
 * @version: 1.0
 */

import java.util.Scanner;

public class AccountView {
    public static void main(String[] args) {
        String[] accountData = {
                "20230111-李朝宗-男-15067682233-30899-JAVA工程师",
                "20230112-杨星阑-男-15067682255-26000-JAVA工程师",
                "20230113-唐碗儿-女-15067682266-18899-WEB工程师",
                "20230114-杨婉柔-女-15367682277-60000-UI工程师"
        };

        AccountController controller = new AccountController(new AccountServiceImpl(new AccountDAOImpl(accountData)));
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("账户管理系统菜单:");
            System.out.println("1. 查看所有账户信息");
            System.out.println("2. 新增一条账户信息");
            System.out.println("3. 根据下标修改账户姓名");
            System.out.println("4. 根据下标删除账户信息");
            System.out.println("5. 查询指定编号的账户信息");
            System.out.println("6. 查询所有性别是\"女\"的账户信息");
            System.out.println("7. 找出所有姓\"杨\"的账户信息");
            System.out.println("8. 找出余额最高的账户信息");
            System.out.println("9. 找出电话号码以\"150\"开头的账户信息");
            System.out.println("10. 根据职业统计出不同职业类型的人数，并显示出这些账户信息");
            System.out.println("0. 退出");
            System.out.print("请选择操作: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // 消耗换行符

            switch (choice) {
                case 1:
                    //  1. 查看所有账户信息
                    controller.viewAllAccounts();
                    break;
                case 2:
                    //  2. 新增一条账户信息
                    System.out.print("请输入账号ID: ");
                    String accountId = scanner.nextLine();
                    System.out.print("请输入用户名: ");
                    String username = scanner.nextLine();
                    System.out.print("请输入性别: ");
                    String gender = scanner.nextLine();
                    System.out.print("请输入联系电话: ");
                    String phone = scanner.nextLine();
                    System.out.print("请输入余额: ");
                    int balance = scanner.nextInt();
                    scanner.nextLine(); // 消耗换行符
                    System.out.print("请输入职业: ");
                    String profession = scanner.nextLine();
                    controller.addAccount(accountId, username, gender, phone, balance, profession);
                    break;
                case 3:
                    //  3. 根据下标修改账户姓名
                    System.out.print("请输入要修改的账户下标: ");
                    int updateIndex = scanner.nextInt();
                    scanner.nextLine(); // 消耗换行符
                    System.out.print("请输入新的用户名: ");
                    String newName = scanner.nextLine();
                    controller.updateAccountNameByIndex(updateIndex, newName);
                    break;
                case 4:
                    //  4. 根据下标删除账户信息
                    System.out.print("请输入要删除的账户下标: ");
                    int deleteIndex = scanner.nextInt();
                    controller.deleteAccountByIndex(deleteIndex);
                    break;
                case 5:
                    //  5. 查询指定编号的账户信息
                    System.out.print("请输入要查询的账户编号: ");
                    String queryId = scanner.nextLine();
                    controller.queryAccountById(queryId);
                    break;
                case 6:
                    //  6. 查询所有性别是"女"的账户信息
                    controller.viewAccountsByGender("女");
                    break;
                case 7:
                    //  7. 找出所有姓"杨"的账户信息
                    controller.viewAccountsBySurname("杨");
                    break;
                case 8:
                    //  8. 找出余额最高的账户信息
                    controller.viewAccountWithHighestBalance();
                    break;
                case 9:
                    //  9. 找出电话号码以"150"开头的账户信息
                    controller.viewAccountsByPhonePrefix("150");
                    break;
                case 10:
                    //  10. 根据职业统计出不同职业类型的人数，并显示出这些账户信息
                    controller.viewAccountsByProfession();
                    break;
                case 0:
                    System.out.println("退出系统.");
                    scanner.close();
                    return;
                default:
                    System.out.println("无效的选择，请重新输入.");
            }
        }
    }
}
