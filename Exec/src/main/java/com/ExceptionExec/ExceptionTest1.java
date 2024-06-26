package com.ExceptionExec;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/6/26 20:47
 * @version: 1.0
 */
public class ExceptionTest1 {
    public static void main(String[] args){
        // 需求：保存一个合法的年
        try {
            saveAge(225);
            System.out.println("saveAge2底层执行是成功的！");
        } catch (AgeIllegalException e) {
            e.printStackTrace();
            System.out.println("saveAge2底层执行是出现bug的！");
        }
    }

    public static void saveAge(int age) throws AgeIllegalException {
        if(age > 0 && age < 150){
      System.out.println("年龄被成功保存： " + age);
        } else {
            // 用一个异常对象封装这个问题
            // throw 抛出去这个异常对象
            throw new AgeIllegalException("/age is illegal, your age is " + age);
        }
    }
}
