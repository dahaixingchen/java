package com.feifei.thread.c04_CAS;

import java.util.concurrent.Exchanger;

/**
 * @Description: Exchanger是一个容器，一般装2个线程，电泳exchange()的时候这两个线程会互换
 *               ，如果线程中有相同的变量，他们会也会跟着互换，不同的变量不会
 * @ClassName: T10_Exchanger
 * @Author chengfei
 * @DateTime 2021/5/18 9:48
 **/
public class T10_Exchanger {

    static Exchanger<String> exchanger = new Exchanger<>();

    public static void main(String[] args) {
        new Thread(()->{
            String s = "T1";
            int i =0;
            i++;
            try {
                s = exchanger.exchange(s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + s + " " + i);

        }, "t1").start();


        new Thread(()->{
            String s = "T2";
            int j = 1;
            j++;
            try {
                s = exchanger.exchange(s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + s+ " " + j);

        }, "t2").start();


    }
}
