package com.wuqy.common.util;

import org.joda.time.DateTime;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class GenerateLogUtil {


    /**
     * 获取几天后添加数据
     * @return
     */
    public static int dayAdd() {
        int dayAdd = new Random().nextInt(4);
        if(0 == dayAdd) {
            dayAdd = 1;
        }
        return dayAdd;
    }

    /**
     * 每天日志数量
     * @return
     */
    public static int dayLogNum() {
        int num = 7 + new Random().nextInt(15);
        return num;
    }

    /**
     * 获取某一天中的随机时间
     * @return
     */
    public static Date randomTimeByDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String year = sdf.format(date);
        DateTime begin = new DateTime(year+"T07:00:00");
        DateTime  end = new DateTime(year+"T23:59:59");
        long newDay = begin.getMillis()+new Random().nextInt(end.getSecondOfDay() - begin.getSecondOfDay())*1000;
        return new Date(newDay);
    }

    public static String randomIp() {
        return IpGenerateUtil.getRandomIp();
    }
}
