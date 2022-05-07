package com.feifei.thread.c07_ThreadLocal;

/**
 * @Description: 两个线程修改同一个公共变量带来的问题，用锁的方式解决
 * @ClassName: T02_ThreadLocal
 * @Author chengfei
 * @DateTime 2022/5/7 18:17
 **/
public class T02_ThreadLocal_1 {

    static Person p = new Person();

    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
            setThread("xuxu");
        });
        thread1.setName("one thread");
        thread1.start();

        Thread thread2 = new Thread(() -> {
            setThread("feifei");
        });
        thread2.setName("two thread");
        thread2.start();
    }

    static synchronized void setThread(String name) {
        p.set(name);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(String.format("%s->%s-", Thread.currentThread().getName(), p.name));
    }
}