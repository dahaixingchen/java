package com.feifei.thread.c04_CAS;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: 用reentrantLock可以替代 synchronized ，但是ReentrantLock一定要进行unlock手动释放锁，不然就会发生死锁
 *               synchronized是jkd自动释放的
 * @ClassName: T01_ReentrantLock
 * @Author chengfei
 * @DateTime 2021/5/17 11:17
 **/
public class T01_ReentrantLock {

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
        try {
            lock.lock();
            System.out.println("m2 ...");
        } finally {
            lock.unlock();
        }

    }
    public static void main(String[] args) {
        T01_ReentrantLock r = new T01_ReentrantLock();
        new Thread(r::m1).start();

        new Thread(r::m2).start();
    }
}
