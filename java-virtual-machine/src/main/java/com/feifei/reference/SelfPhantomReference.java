package com.feifei.reference;

import java.lang.ref.*;

/**
 * @ClassName: SelfPhantomReference
 * @Author chengfei
 * @Date 2020/11/15 20:03
 * @Description: TODO 虚引用，用来回收堆外内存的（程序中用到的操作系统的内存），在NIo中用到
 **/
public class SelfPhantomReference {

    public static void main(String[] args) {
//        final Object o = new Object();
//        System.out.println(o);
//        ReferenceQueue referenceQueue = new ReferenceQueue();
//        PhantomReference<Object> phantomReference = new PhantomReference<Object>(o, referenceQueue);
//        System.out.println(phantomReference.get()); // null
//
//        //用引用是可以拿到对象的引用的
//        final WeakReference<Object> objectWeakReference = new WeakReference<Object>(o, referenceQueue);
//        System.out.println(objectWeakReference.get()); //java.lang.Object@6d6f6e28

        //**********************************************
        //创建一个对象用不同的引用指向这个对象
        Object o1 = new Object();
        ReferenceQueue QUEUE = new ReferenceQueue();
//        PhantomReference<Object> phantomReference1 = new PhantomReference<Object>(o1, QUEUE);
        WeakReference<Object> weakReference = new WeakReference<Object>(o1, QUEUE);
//        SoftReference<Object> weakReference = new SoftReference<Object>(o1, QUEUE);
        // 释放这个内存空间，此时只剩phantomReference通过虚引用指向它
        o1 = null;
        // 调用gc回收new User的内存空间
//        System.gc();
        // 被清除的队列/中取出被回收的对象
        while (true) {
            Reference<? extends Object> poll = QUEUE.poll();
            if (poll != null) {
                System.out.println(poll);
                System.out.println(poll.get());
                System.out.println("--obj is recovery--");
                break;
            }
        }
    }
}
