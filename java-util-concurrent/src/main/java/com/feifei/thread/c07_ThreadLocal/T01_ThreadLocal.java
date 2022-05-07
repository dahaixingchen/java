package com.feifei.thread.c07_ThreadLocal;

import java.util.concurrent.TimeUnit;

/**
 * @Description: 各个线程是独立的，所有在一个线程里设置，在另外一个线程里是不能读到的，代码结果就是null
 * @ClassName: T01_ThreadLocal
 * @Author chengfei
 * @DateTime 2021/5/18 18:17
 **/
public class T01_ThreadLocal {

    volatile static Person p = new Person();

    static ThreadLocal<Person> tl = new ThreadLocal<>();

    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(String.format("%s->%s", Thread.currentThread().getName(), tl.get()));
//            System.out.println(Thread.currentThread().getName() + tl.get() + " ");
        });
        thread1.setName("one thread");
        thread1.start();

        Thread thread2 = new Thread(() -> {
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            tl.set(new Person());
            System.out.println(String.format("%s->%s->%s", Thread.currentThread().getName(), tl.get(), tl.get().name));
        });
        thread2.setName("two thread");
        thread2.start();
    }
}

class Person {
    String name = "zhangsan";
}