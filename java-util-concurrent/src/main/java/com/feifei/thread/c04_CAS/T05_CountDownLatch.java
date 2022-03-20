package com.feifei.thread.c04_CAS;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: join()方式要等到所有的线程都执行完毕自己才能执行，CountDownLatch只需要调用countDown()的次数
 *               大于初始申请的时候的次数自己就可以继续往下执行
 * @ClassName: T05_CountDownLatch
 * @Author chengfei
 * @DateTime 2021/5/17 11:17
 **/
public class T05_CountDownLatch {
    public static void main(String[] args) {
//        usingJoin();
        usingCountDownLatch();
    }

    private static void usingCountDownLatch() {
        Thread[] threads = new Thread[100];
        CountDownLatch latch = new CountDownLatch(threads.length);

//        for(int i=0; i<threads.length; i++) {
        for(int i=0; i<99; i++) {
            threads[i] = new Thread(()->{
                int result = 0;
                for(int j=0; j<10000; j++) result += j;
//                latch.countDown();
            });
        }
        for (int i = 0; i < 101; i++) {
            latch.countDown();
        }

//        for (int i = 0; i < threads.length; i++) {
        for (int i = 0; i < 99; i++) {
            threads[i].start();
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("end latch");
    }

    private static void usingJoin() {
        Thread[] threads = new Thread[100];

        for(int i=0; i<threads.length; i++) {
            threads[i] = new Thread(()->{
                int result = 0;
                for(int j=0; j<10000; j++) result += j;
            });
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("end join");
    }
}
