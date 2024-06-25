package com.lambdaExec01;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/6/26 4:53
 * @version: 1.0
 */
public class CompareByData {
    public static int compareByAge(Student o1, Student o2) {
        return o1.getAge() - o2.getAge();   //  按照年龄进行升序排序
    }

    public int compareByAgeDesc(Student o1, Student o2) {
        return o2.getAge() - o1.getAge();   //  按照年龄进行降序排序
    }
}
