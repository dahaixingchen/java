package com.feifei.thread.c05_interview;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * 面试题：写一个固定容量同步容器（多线程往里面装，多线程往外拿），拥有put和get方法，以及getCount方法，
 * 能够支持2个生产者线程以及10个消费者线程的阻塞调用
 *
 * 使用wait和notify/notifyAll来实现
 *
 * 问题：这个会出现两个拿到一模一样的数据，应该不是这样的吧
 *
 * @Description:
 * @ClassName: T06_MyContainer
 * @Author chengfei
 * @DateTime 2021/5/18 17:04
 **/
public class T06_MyContainerSyn<T> {
    final private LinkedList<T> lists = new LinkedList<>();
    final private int MAX = 10; //最多10个元素
    private int count = 0;


    public synchronized void put(T t) {
        while(lists.size() == MAX) { //想想为什么用while而不是用if？
            try {
                this.wait(); //effective java
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        lists.add(t);
        ++count;
        this.notifyAll(); //通知消费者线程进行消费
    }

    public synchronized T get() {
        T t = null;
        while(lists.size() == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        t = lists.removeFirst();
        count --;
        this.notifyAll(); //通知生产者进行生产
        return t;
    }

    public static void main(String[] args) {
        T06_MyContainerSyn<String> c = new T06_MyContainerSyn<>();
        //启动消费者线程
        for(int i=0; i<10; i++) {
            new Thread(()->{
                for(int j=0; j<5; j++)
                    System.out.println(c.get());
            }, "c" + i).start();
        }

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //启动生产者线程
        for(int i=0; i<2; i++) {
            new Thread(()->{
                for(int j=0; j<25; j++)
                    c.put(Thread.currentThread().getName() + " " + j);
            }, "p" + i).start();
        }
    }
}
