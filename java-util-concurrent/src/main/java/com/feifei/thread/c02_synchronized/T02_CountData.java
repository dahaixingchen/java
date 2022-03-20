package com.feifei.thread.c02_synchronized;

/**
 * @Description: 锁的是一个对象，不是代码
 *                用了synchronized就没必要用volatile
 * @ClassName: T01_SynchronizedBase
 * @Author chengfei
 * @DateTime 2021/5/14 16:55
 **/
public class T02_CountData implements Runnable {

    private /*volatile*/ int count = 100;
    private Object o = new Object();

    public static void main(String[] args) {
        T02_CountData t = new T02_CountData();
        for (int i = 0; i < 100; i++) {
            new Thread(t,"thread" + i).start();
        }
    }

    @Override
    public synchronized void run() {
//        synchronized (o){
            count--;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
//        }
    }
}
