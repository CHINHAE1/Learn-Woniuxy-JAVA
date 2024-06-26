package com.IOExec;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/6/26 21:26
 * @version: 1.0
 */
public class FileInputStreamTest3 {
    public static void main(String[] args) throws Exception {
        // 1、一次性读取完文件的全部字节到一个字节数组中去。
// 创建一个字节输入流管道与源文件接通
        InputStream is = new FileInputStream("file-io-app\\src\\itheima03.txt");

// 2、准备一个字节数组，大小与文件的大小正好一样大。
        File f = new File("file-io-app\\src\\itheima03.txt");
        long size = f.length();
        byte[] buffer = new byte[(int) size];

        int len = is.read(buffer);
        System.out.println(new String(buffer));

//3、关闭流
        is.close();
    }
}
