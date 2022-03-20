package com.feifei.thread.c02_synchronized;

import java.util.concurrent.TimeUnit;

/**
 * @Description: 两个加锁的方法，其中一个调用调用另外一个加锁方法是可以的
 *                因为锁在方法上，其实都是锁在当前对象上，所以是同一把锁
 * @ClassName: T01_SynchronizedBase
 * @Author chengfei
 * @DateTime 2021/5/14 16:55
 **/
public class T05_Reentry {
    synchronized void m1() {
        System.out.println("m1 start");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        m2();
        System.out.println("m1 end");
    }

    synchronized void m2() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m2");
    }

    public static void main(String[] args) {
        new T05_Reentry().m1();
    }
}
