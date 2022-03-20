package com.feifei.thread.c04_CAS;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Description: 下面对比了 ReentrantLock，和 ReentrantReadWriteLock的效率，很明显的区别
 *               ，ReentrantReadWriteLock用 readLock的时候，能一下接受所有的读线程，writeLock是一样的
 * @ClassName: T08_ReadWriteLock
 * @Author chengfei
 * @DateTime 2021/5/18 9:35
 **/
public class T08_ReadWriteLock {

    static Lock lock = new ReentrantLock();

    private static int value;

    static  private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    static  private Lock writeLock = readWriteLock.writeLock();
    static  private Lock readLock = readWriteLock.readLock();

    public static void read(Lock lock) {
        try {
            lock.lock();
            Thread.sleep(1);
            System.out.println("read over!");
            //模拟读取操作
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void write(Lock lock, int v) {
        try {
            System.out.println("read over!");
            Thread.sleep(1000);
            lock.lock();
            Thread.sleep(1);
            value = v;
            System.out.println("write over!");
            //模拟写操作
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }





    public static void main(String[] args) {
//        Runnable readR = ()-> read(lock);
        Runnable readR = ()-> read(readLock);

//        Runnable writeR = ()->write(lock, new Random().nextInt());
        Runnable writeR = ()->write(writeLock, new Random().nextInt());

//        for(int i=0; i<18; i++) new Thread(readR).start();
        for(int i=0; i<20; i++) new Thread(writeR).start();


    }
}
