package com.Exec03.util;

import java.util.Date;
import java.util.UUID; /**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/6/23 21:01
 * @version: 1.0
 */
public class IDutils {

    public static String getUUID() {
        return UUID.randomUUID().toString().replace("", "").toUpperCase();

    }
    public static long getTimeId() {
        return new Date().getTime();

    }
}

