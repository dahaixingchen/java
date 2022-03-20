package com.feifei.thread.c04_CAS;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: 如下两个线程，一个线程在无限制的sleep下去，这时可以通过main线程来调用interrupt来打断它的sleep
 *              ，让另外一个线程来执行
 * @ClassName: T04_ReentrantLockInterrupt
 * @Author chengfei
 * @DateTime 2021/5/17 11:17
 **/
public class T04_ReentrantLockInterrupt {


    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Thread t1 = new Thread(() -> {
            try {
                lock.lock();
                System.out.println("t1 start");
                TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
                System.out.println("t1 end");
            } catch (InterruptedException e) {
                System.out.println("interrupted!");
            } finally {
                lock.unlock();
            }
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            try {
                //lock.lock();
                lock.lockInterruptibly(); //可以对interrupt()方法做出响应
                System.out.println("t2 start");
                TimeUnit.SECONDS.sleep(5);
                System.out.println("t2 end");
            } catch (InterruptedException e) {
                System.out.println("interrupted!");
            } finally {
                lock.unlock();
            }
        });
        t2.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (
                InterruptedException e) {
            e.printStackTrace();
        }
        t2.interrupt(); //打断线程2的等待

    }
}
