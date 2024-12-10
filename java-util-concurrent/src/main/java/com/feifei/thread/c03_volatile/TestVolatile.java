package com.feifei.thread.c03_volatile;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName: TestVolatile
 * @Author chengfei
 * @DateTime 2024/9/9 15:16
 * @TODO:
 **/
public class TestVolatile {
    private volatile static boolean stop = false;

    public static void main(String[] args) {
        // Thread-A
        new Thread("Thread A") {
            @Override
            public void run() {
                while (!stop) {

                }
                System.out.println(Thread.currentThread() + " stopped");
            }
        }.start();

        // Thread-main
        try {
            TimeUnit.SECONDS.sleep(1);
            System.out.println(Thread.currentThread() + " after 1 seconds");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        stop = true;
        System.out.println("已经执行了stop=true命令");
    }
}
