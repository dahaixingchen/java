package com.feifei.thread.c03_volatile;

/**
 * @Description: 只用volatile是不能达到依次递减的效果的，它只能让线程之间对公共变量可见性
 *                ，并没有要求同时修改公共变量的只有一个线程，所有是不能达到预期效果的
 *                ，想要预期效果还得用synchronized
 * @ClassName: T02_CountData
 * @Author chengfei
 * @DateTime 2021/5/14 16:55
 **/
public class T03_CountData implements Runnable {

    private volatile int count = 100;
    private Object o = new Object();

    public static void main(String[] args) {
        T03_CountData t = new T03_CountData();
        for (int i = 0; i < 100; i++) {
            new Thread(t,"thread" + i).start();
        }
    }

    @Override
    public /*synchronized*/ void run() {
            count--;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
    }
}
