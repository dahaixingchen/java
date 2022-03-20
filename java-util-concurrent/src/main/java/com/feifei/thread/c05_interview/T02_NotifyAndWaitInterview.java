package com.feifei.thread.c05_interview;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 曾经的面试题：（淘宝？）
 * 实现一个容器，提供两个方法，add，size
 * 写两个线程，线程1添加10个元素到容器中，线程2实现监控元素的个数，当个数到5个时，线程2给出提示并结束
 *
 * @Description: 可以发现t2不能起到监控的作用，原因在于，notify()是不会释放锁的，wait()才会释放锁
 * @ClassName: T07_NotifyAndWait
 * @Author chengfei
 * @DateTime 2021/5/18 10:59
 **/
public class T02_NotifyAndWaitInterview {
    //添加volatile，使t2能够得到通知
    volatile List lists = new ArrayList();

    public void add(Object o) {
        lists.add(o);
    }

    public int size() {
        return lists.size();
    }

    public static void main(String[] args) {
        T02_NotifyAndWaitInterview c = new T02_NotifyAndWaitInterview();

        final Object synLock = new Object();

        new Thread(() -> {
            synchronized(synLock) {
                System.out.println("t2启动");
                if(c.size() != 5) {
                    try {
                        synLock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("t2 结束");
            }

        }, "t2").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        new Thread(() -> {
            System.out.println("t1启动");
            synchronized(synLock) {
                for(int i=0; i<10; i++) {
                    c.add(new Object());
                    System.out.println("add " + i);

                    if(c.size() == 5) {
                        synLock.notify();
                    }

                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "t1").start();


    }
}
