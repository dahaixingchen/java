package com.feifei.thread.c02_synchronized;

/**
 * @Description: 不同的线程，一个线程在锁里执行，另外一个线程如果有没有加锁的程序需要运行，它可以运行
 * @ClassName: T01_SynchronizedBase
 * @Author chengfei
 * @DateTime 2021/5/14 16:55
 **/
public class T04_RunSameTime {
    public synchronized void m1() {
        System.out.println(Thread.currentThread().getName() + " m1 start...");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " m1 end");
    }

    public void m2() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " m2 ");
    }

    public static void main(String[] args) {
        T04_RunSameTime t = new T04_RunSameTime();

		/*new Thread(()->t.m1(), "t1").start();
		new Thread(()->t.m2(), "t2").start();*/

        new Thread(t::m1, "t1").start();
        new Thread(t::m2, "t2").start();

		/*
		//1.8之前的写法
		new Thread(new Runnable() {

			@Override
			public void run() {
				t.m1();
			}

		});
		*/

    }
}
