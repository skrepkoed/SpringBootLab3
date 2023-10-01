package com.example.demo2.util;

import java.text.SimpleDateFormat;

public class DateTimeUtil {
    public static  SimpleDateFormat getSimpleDateTimeFormat(){
        return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    }
}
