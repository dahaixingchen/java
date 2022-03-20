package com.feifei.thread.c01_threadBase;

/**
 * @Description:
 * @ClassName: T03_ThreadState
 * @Author chengfei
 * @DateTime 2021/5/14 16:23
 **/
public class T03_ThreadState {

    static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println(this.getState());

            for(int i=0; i<10; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        Thread t = new MyThread();

        System.out.println(t.getState());

        t.start();

        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(t.getState());

    }
}
