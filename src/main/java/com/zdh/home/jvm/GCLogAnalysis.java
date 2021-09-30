package com.zdh.home.jvm;

import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;

public class GCLogAnalysis {


    public static Random random = new Random();

    public static void main(String[] args) {
        long startMillis = System.currentTimeMillis();
        long timeOutMillis = TimeUnit.SECONDS.toMillis(1);

        long endMillis = startMillis + timeOutMillis;

        LongAdder counter = new LongAdder();
        System.out.println("正在执行====");
        // 缓存一部分对象，进入老年代
        int cacheSize = 2000;
        Object[] cacheGarbage = new Object[cacheSize];
        //在此时间范围内 ，持续循环
        while (System.currentTimeMillis() < endMillis) {
            Object garbage = generateGarbage(100 * 1024);
            counter.increment();
            int randomindex = random.nextInt(2 * cacheSize);
            if (randomindex < cacheSize) {
                cacheGarbage[randomindex] = garbage;
            }
        }

        System.out.println("执行结束！ 共生成对象次数" + counter.longValue());

    }

    private static Object generateGarbage(int max) {
        int randomSize = random.nextInt(max);

        int type = randomSize % 4;
        Object result = null;
        switch (type) {
            case 0:
                result = new int[randomSize];
                break;

            case 1:
                result = new Byte[randomSize];
                break;
            case 2:
                result = new double[randomSize];
                break;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                String randomString = "randomString-everything";
                while (stringBuilder.length() < randomSize) {
                    stringBuilder.append(randomString);
                    stringBuilder.append(max);
                    stringBuilder.append(randomSize);
                }
                result = stringBuilder.toString();
                break;
        }
        random.nextInt();
        return result;
    }
}
