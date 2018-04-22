package com.business.main.util;

public class StringUtil {

    public static boolean isNotEmpty(String str) {
        return str != null && str.trim().length() > 0;
    }

}
