package com.lambdaExec01;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/6/26 4:32
 * @version: 1.0
 */
public class Exec01 {
    public static void main(String[] args){
        Student[] students = new Student[4];
        students[0] = new Student("蜘蛛精", 169.5, 23);
        students[1] = new Student("紫霞", 163.8, 26);
        students[2] = new Student("紫霞", 163.8, 26);
        students[3] = new Student("至尊宝", 167.5, 24);

     //原始写法:对数组中的学生对象,按照年龄进行升序排序
    Arrays.sort(students,new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.getAge() - o2.getAge();
        }
    });

    //  使用lambda表达式进行排序
        Arrays.sort(students,(o1,o2) -> o1.getAge() - o2.getAge());
        System.out.println("按照年龄进行升序排序:" + Arrays.toString(students));

    //  使用静态方法引用 进行排序
        Arrays.sort(students,(o1,o2) -> CompareByData.compareByAge(o1,o2));

    //  简化  静态方法引用：类名::方法名
        Arrays.sort(students,CompareByData::compareByAge);

        CompareByData compare = new CompareByData();
        //  按照年龄进行降序排序
        Arrays.sort(students, (o1, o2) -> compare.compareByAgeDesc(o1, o2));

        //  简化  静态方法引用：类名::方法名
        Arrays.sort(students, compare::compareByAgeDesc);
    }
}
