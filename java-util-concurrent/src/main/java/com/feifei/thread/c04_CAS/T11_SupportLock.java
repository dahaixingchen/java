package com.feifei.thread.c04_CAS;

import java.util.concurrent.locks.LockSupport;

/**
 * @Description: LockSupport.park()会让线程阻塞住，直到调用 unpark()不管是哪个线程调用都可以
 *               ，也可以之前就调用unpark()，这样就算是再调用park()也不会阻塞了
 *               ，park和unpark需要成对出现，不然程序会阻塞，如果只有park
 * @ClassName: T11_SupportLock
 * @Author chengfei
 * @DateTime 2021/5/18 9:56
 **/
public class T11_SupportLock {
    public static void main(String[] args) {
        Thread t = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                if(i == 5) {
                    LockSupport.park();
                }
                if(i == 7) {
                    LockSupport.park();
                }
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t.start();

//        LockSupport.unpark(t);

        try {
//            TimeUnit.SECONDS.sleep(8);
            Thread.sleep(80);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("after 8 senconds!");

        LockSupport.unpark(t);

        try {
//            TimeUnit.SECONDS.sleep(8);
            Thread.sleep(80);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LockSupport.unpark(t);
        System.out.println("after 9 senconds!");
    }
}
