package com.feifei.thread.c01_threadBase;

/**
 * @Description: 创建线程的几种方法
 * @ClassName: T01_ThreadCread
 * @Author chengfei
 * @DateTime 2021/5/11 9:52
 **/
public class T01_HowToCreateThread {

    //第一种：利用Runnable
    static class RunnableImpl implements Runnable{

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            System.out.println("大家好，Runnable，线程名称："+ threadName);
        }
    }

    //第二种：实现Thread中的run方法来实现
    static class ThreadExtends extends Thread{
        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            System.out.println("通过重写Thread中的run方法来实现，线程名称："+ threadName);
        }
    }

    public static void main(String[] args) throws Exception {
        //第一种：利用Runnable
        new Thread(new RunnableImpl()).start();
        //第二种：实现Thread中的run方法来实现
        new  ThreadExtends().start();
        //第三种方式：lamba 表达式来创建线程
        new Thread(()->{
            String threadName = Thread.currentThread().getName();
            System.out.println("lamba 表达式来创建线程，线程名称："+ threadName);
        }).start();

        //第四种方式，通过线程池来创建
        String threadName = Thread.currentThread().getName();
        System.out.println("我是主线程，线程名称："+ threadName);
    }

}
