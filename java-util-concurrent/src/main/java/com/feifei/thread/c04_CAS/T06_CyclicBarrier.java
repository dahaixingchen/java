package com.feifei.thread.c04_CAS;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * @Description: 类似于CountDownLatch，只需要await()等于初始设定的数字，就可以一起触发执行线程里的内容
 *              ，数字不够就会一直阻塞住等着
 * @ClassName: T06_CyclicBarrier
 * @Author chengfei
 * @DateTime 2021/5/17 11:17
 **/
public class T06_CyclicBarrier {
    public static void main(String[] args) {
        //CyclicBarrier barrier = new CyclicBarrier(20);

        CyclicBarrier barrier = new CyclicBarrier(20, () -> System.out.println("满人"));

        /*CyclicBarrier barrier = new CyclicBarrier(20, new Runnable() {
            @Override
            public void run() {
                System.out.println("满人，发车");
            }
        });*/

        for(int i=0; i<100; i++) {

            new Thread(()->{
                try {
                    barrier.await();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println("我们车上满了的");
//                for (int i1 = 0; i1 < 100; i1++) {
//                    try {
//                        barrier.await();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    } catch (BrokenBarrierException e) {
//                        e.printStackTrace();
//                    }
//                }
            }).start();



        }
    }
}
