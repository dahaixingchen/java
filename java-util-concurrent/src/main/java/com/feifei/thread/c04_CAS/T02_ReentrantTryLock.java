package com.feifei.thread.c04_CAS;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: tryLock，尝试锁下，这样无法锁定，或者在指定时间内无法锁定，线程可以决定是否继续等待
 *               使用ReentrantLock还可以调用lockInterruptibly方法，可以对线程interrupt方法做出响应，
 *               在一个线程等待锁的过程中，可以被打断
 * @ClassName: T01_ReentrantLock
 * @Author chengfei
 * @DateTime 2021/5/17 11:17
 **/
public class T02_ReentrantTryLock {

    ReentrantLock lock = new ReentrantLock();

    void m1(){
        try {
            lock.lock();
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
            }
        }finally {
            lock.unlock();
        }

    }

    void m2() {
        boolean tryLock = false;
        try {
            tryLock = lock.tryLock(1, TimeUnit.MILLISECONDS);
//            boolean tryLock = lock.tryLock();
            System.out.println("m2 ...地方" + tryLock);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if(tryLock) lock.unlock();
        }

    }
    public static void main(String[] args) {
        T02_ReentrantTryLock r = new T02_ReentrantTryLock();
        new Thread(r::m1).start();

        new Thread(r::m2).start();
    }
}
