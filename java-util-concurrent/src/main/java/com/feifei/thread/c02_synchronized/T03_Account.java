package com.feifei.thread.c02_synchronized;

/**
 * @Description: 虽然synchronized写在不同的方法上，但是锁的都是同一个对象，相当于是同一把锁，
 *                如果set（存钱）方法加锁，读（查看账号）的方法不加锁，由于这两个方法是两个线程单独做的事情，
 *                当写的逻辑用的时间比较长时候，就会产生”脏读“的现象
 * @ClassName: T01_SynchronizedBase
 * @Author chengfei
 * @DateTime 2021/5/14 16:55
 **/
public class T03_Account {
    String name;
    double balance;

    //虽然synchronized写在不同的方法上，但是锁的都是同一个对象，相当于是同一把锁，
    public synchronized void set(String name, double balance) {
        this.name = name;

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        this.balance = balance;
    }

    public synchronized double getBalance(String name) {
        return this.balance;
    }


    public static void main(String[] args) {
        T03_Account a = new T03_Account();

        //往账户里打100元
        new Thread(()->a.set("zhangsan", 100.0)).start();

        //模拟业务处理
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //取出钱
        System.out.println(a.getBalance("zhangsan"));

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(a.getBalance("zhangsan"));
    }
}
