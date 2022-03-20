package com.feifei.thread.c02_synchronized;

/**
 * @Description:
 * @ClassName: T01_SynchronizedBase
 * @Author chengfei
 * @DateTime 2021/5/14 16:55
 **/
public class T01_Base {
    private int count = 100;
    private static int count1 = 100;
    private Object o = new Object();


    //锁住的是对象不是代码，对象头上两位二进制数表示锁的状态
    public void m() {
        synchronized (o) {
            count--;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
        }
    }


    public void m1() {
        synchronized (this) {
            count--;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
        }
    }


    //等同于 synchronized (this)
    public synchronized void m2() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }

    //这里不能用synchronized(this),因为静态方法中没有this
    public static void mm() {
//        synchronized(T01_SynchronizedBase.class) { //考虑一下这里写synchronized(this)是否可以？
            count1 --;
            System.out.println(Thread.currentThread().getName() + " count = " + count1);
//        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
               mm();
            }).start();
        }
    }


}
