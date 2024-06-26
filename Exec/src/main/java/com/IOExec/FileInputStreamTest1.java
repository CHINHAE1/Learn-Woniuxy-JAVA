package com.IOExec;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/6/26 21:22
 * @version: 1.0
 */
public class FileInputStreamTest1 {
    public static void main(String[] args) throws Exception {
        // 1、创建文件字节输入流管道，与源文件接通
        InputStream is = new FileInputStream(("file-io-app\\src\\itheima01.txt"));

        // 2、开始读取文件的字节数据。
        // public int read():每次读取一个字节返回，如果没有数据了，返回-1.
        int b; // 用于记住读取的字节。
        while ((b = is.read()) != -1){
            System.out.print((char) b);
        }

        //3、流使用完毕之后，必须关闭！释放系统资源！
        is.close();
    }
}
