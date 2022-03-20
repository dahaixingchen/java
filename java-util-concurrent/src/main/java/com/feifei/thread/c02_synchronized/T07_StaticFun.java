package com.feifei.thread.c02_synchronized;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description:
 * https://blog.csdn.net/u010842515/article/details/65443084
 * @ClassName: T07_StaticFun
 * @Author chengfei
 * @DateTime 2022/2/24 14:37
 **/
public class T07_StaticFun {

    public static T07_StaticFun staticIn = new T07_StaticFun();   //静态对象

    public synchronized void method1() {                                      //非静态方法1
        for (int i = 0; i < 10; i++) {
            System.out.println("method1 is running!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public synchronized void method2() {                                   //非静态方法2
        for (int i = 0; i < 10; i++) {
            System.out.println("method2 is running!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public synchronized static void staticMethod1() {                     //静态方法1
        for (int i = 0; i < 10; i++) {
            System.out.println("static method1 is running!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public synchronized static void staticMethod2() {                      //静态方法2
        for (int i = 0; i < 10; i++) {
            System.out.println("static method2 is running!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Thread1());
        Thread t2 = new Thread(new Thread2());
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(t1);
        exec.execute(t2);
        exec.shutdown();
    }
}
