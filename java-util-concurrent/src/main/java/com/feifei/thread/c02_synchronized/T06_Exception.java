package com.feifei.thread.c02_synchronized;

import java.util.concurrent.TimeUnit;

/**
 * @Description: 程序异常的时候，加锁的代码释放锁，其他的线程就会开始执行，导致问题
 *                代码中，t2线程本来没有机会执行的，但是由于t1线程中的异常处理的不合理，就会让t2运行
 * @ClassName: T01_SynchronizedBase
 * @Author chengfei
 * @DateTime 2021/5/14 16:55
 **/
public class T06_Exception {
    int count = 0;
    synchronized void m() {
        System.out.println(Thread.currentThread().getName() + " start");
        while(true) {
            count ++;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
            try {
                TimeUnit.SECONDS.sleep(1);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(count == 5) {
                int i = 1/0; //此处抛出异常，锁将被释放，要想不被释放，可以在这里进行catch，然后让循环继续
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        T06_Exception t = new T06_Exception();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                t.m();
            }
        };
        new Thread(r, "t1").start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(r, "t2").start();
    }
}
