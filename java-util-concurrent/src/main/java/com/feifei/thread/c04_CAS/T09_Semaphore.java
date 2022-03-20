package com.feifei.thread.c04_CAS;

import java.util.concurrent.Semaphore;

/**
 * @Description: Semaphore表示同时能允许多少个线程同时运行，第二个参数表示这些线程是否是公平的运行
 * @ClassName: T09_Semaphore
 * @Author chengfei
 * @DateTime 2021/5/18 9:45
 **/
public class T09_Semaphore {
    public static void main(String[] args) {
        //Semaphore s = new Semaphore(2);
        Semaphore s = new Semaphore(2, true);
        //允许一个线程同时执行
        //Semaphore s = new Semaphore(1);

        new Thread(()->{
            try {
                s.acquire();

                System.out.println("T1 running...");
                Thread.sleep(200);
                System.out.println("T1 running...");

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                s.release();
            }
        }).start();

        new Thread(()->{
            try {
                s.acquire();

                System.out.println("T2 running...");
                Thread.sleep(200);
                System.out.println("T2 running...");

                s.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
