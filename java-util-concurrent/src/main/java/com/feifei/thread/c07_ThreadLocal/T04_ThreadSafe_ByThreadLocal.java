package com.feifei.thread.c07_ThreadLocal;

/**
 * @TODO: 2022/5/7  : 两个线程修改同一个公共变量带来的问题，用threadLocal的方式解决
 * @TODO: ThreadLocal就是把公共变量set进去，
 * @ClassName: T02_ThreadLocal
 * @Author chengfei
 * @DateTime 2022/5/7 18:17
 **/
public class T04_ThreadSafe_ByThreadLocal {

    static ThreadLocal<Person> threadLocal = new ThreadLocal();

    public static void main(String[] args) {
        //在主线程里set，也就只有主线程能拿到threadlocal里的数据
//        threadLocal.set(new Person());
//        System.out.println("sadfsaf"+threadLocal.get());

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


    static void setThread(String name) {
        threadLocal.set(new Person());
//        threadLocal.set(p); //不起作用，因为多个线程用的是同一个person的引用
        threadLocal.get().set(name);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(String.format("从threadLocal中取数%s->%s", Thread.currentThread().getName(), threadLocal.get().name));
//        System.out.println(String.format("%s->%s", Thread.currentThread().getName(), p.name));
    }
}