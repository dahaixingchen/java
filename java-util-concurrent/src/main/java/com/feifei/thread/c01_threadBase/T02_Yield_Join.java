package com.feifei.thread.c01_threadBase;

/**
 * @Description: join()方法写在哪个线程里，那个线程就要等待所有的线程执行完后，它自己才能继续执行
 * @ClassName: T02_Yield_Join
 * @Author chengfei
 * @DateTime 2021/5/11 11:31
 **/
public class T02_Yield_Join {
    public static void main(String[] args) throws InterruptedException {
//        testYield();
        testJoin();
//        Thread.currentThread().join();
        System.out.println("主线程执行完毕");
    }

    static void testSleep() {
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("A" + i);
                try {
                    Thread.sleep(500);
                    //TimeUnit.Milliseconds.sleep(500)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    //让出当前的资源，自己进入到候选队列中,结果会出现他们互相出现，加不加yield这个方法现象不是很明显
    static void testYield() {
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("A" + i);
//                if (i%2 == 0) Thread.yield();
            }
        }).start();

        new Thread(() -> {
            for (int i = 100; i > 0; i--) {
                System.out.println("-------------B" + i);
//                if (i%2 == 0) Thread.yield();
            }
        }).start();
    }

    //join就是等着另外一个线程执行完了，当前线程再执行
//    Thread.currentThread().join(); 会卡住所在线程，
    static void testJoin() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("A" + i);
                try {
                    Thread.sleep(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(() -> {

            try {
                System.out.println(t1.getState());
                t1.join();
//                Thread.currentThread().join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 100; i++) {
                System.out.println("--------------B" + i);
                try {
                    Thread.sleep(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
//        t1.join();
        t2.join();
//        Thread.currentThread().join();
    }

}
