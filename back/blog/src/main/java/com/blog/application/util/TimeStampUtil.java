package com.blog.application.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeStampUtil {
    public static String transformTimeStampToDateString(long timestamp){
        Date date = new Date(timestamp);
        SimpleDateFormat myFmt2=new SimpleDateFormat("yyyy-MM-dd");
        return myFmt2.format(date);
    }
}
