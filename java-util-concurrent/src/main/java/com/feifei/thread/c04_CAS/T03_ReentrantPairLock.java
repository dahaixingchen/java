package com.feifei.thread.c04_CAS;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: 公平锁，ReentrantLock(true)，表示申请的是公平锁，如下，两个线程拿到锁的概率是一样的。
 * @ClassName: T01_ReentrantLock
 * @Author chengfei
 * @DateTime 2021/5/17 11:17
 **/
public class T03_ReentrantPairLock extends Thread {
    ReentrantLock lock = new ReentrantLock(true);

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + "获得锁");
            }finally {
                lock.unlock();
            }
        }

    }

    public static void main(String[] args) {
        T03_ReentrantPairLock r = new T03_ReentrantPairLock();

        new Thread(r).start();
        new Thread(r).start();
    }
}
