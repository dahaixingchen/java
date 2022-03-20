package com.feifei.thread.c03_volatile;

import javax.sound.midi.Soundbank;
import java.util.concurrent.TimeUnit;

/**
 * @Description: volatile在多线程情况下，能让所有线程对公共变量都具有可见性，如下面的例子
 *                本来如果没有volatile，尽管是main线程把公共变量修改为false了，但是由于线程有自己的单独的线程栈
 *                ，对于main线程修改的公共变量runing，它是不可见的，
 *                但是加上了volatile的话，main修改的runing为false就对t1线程可见，程序就会停止
 * @ClassName: T01_SynchronizedBase
 * @Author chengfei
 * @DateTime 2021/5/14 16:55
 **/
public class T01_Base {
    boolean running = true; //对比一下有无volatile的情况下，整个程序运行结果的区别
    void m() {
        System.out.println("m start");
        while(running) {
            try {
//                Thread.sleep(1);
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            for (int i = 0; i < 1000000; i++) {
//                System.out.println("safd");
//            }
            System.out.println("fsdadsf");
        }
        System.out.println("m end!");

    }

    public static void main(String[] args) throws InterruptedException {
        T01_Base t = new T01_Base();

        new Thread(t::m, "t1").start();
        new Thread(()->{
           t.running = false;
        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        t.running = false;
    }

}
