package com.feifei.thread.c02_synchronized;

public class Thread2 implements Runnable {

    @Override
    public void run() {
        // TODO Auto-generated method stub
//        T07_StaticFun s = T07_StaticFun.getInstance();
//        s.method2();
//        T07_StaticFun s2 = new T07_StaticFun();
//        s2.method2();
//        T07_StaticFun.staticMethod1();
        T07_StaticFun.staticMethod2();
//        T07_StaticFun.staticIn.method2();
//        T07_StaticFun.staticIn.staticMethod1();
    }
}