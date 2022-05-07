package com.feifei.thread.c07_ThreadLocal;

/**
 * @TODO: 2022/5/7  : 两个线程修改同一个公共变量带来的问题，用threadLocal的方式解决
 * @todo ThreadLocal，利用set方法把公共变量set进去之后，不用的时候需要remove掉
 * ThreadLocal在线程里面申请
 * @ClassName: T05_ThreadSafe_ByThreadLocal1
 * @Author chengfei
 * @DateTime 2022/5/7 18:17
 **/
public class T05_OOM_NotRemove {

    static ThreadLocal<byte[]> threadLocal = new ThreadLocal();

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


    static void setThread(String name) {
        threadLocal.set(new byte[1024 * 1024 * 10]);

        //把ThreadLocal的引用设置为null之后，它如上申请的 1024*1024*10 的内存就会发生内存泄露
        threadLocal = null;
        System.gc();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //所有在用完之后一定要调用remove方法把申请的内存释放掉
        threadLocal.remove();
        byte[] bytes = new byte[1024 * 1024 * 10];
        System.out.println("程序运行到这里说明申请内存成功");
    }
}