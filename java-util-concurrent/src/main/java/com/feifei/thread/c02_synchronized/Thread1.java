package com.feifei.thread.c02_synchronized;

/**
 * @Description:
 * @ClassName: Thread1
 * @Author chengfei
 * @DateTime 2022/2/24 14:46
 **/
public class Thread1 implements Runnable {

    @Override
    public void run() {
//		T07_StaticFun s = T07_StaticFun.getInstance();
//		s.method1();
//		T07_StaticFun s1 = new T07_StaticFun();
//		s1.method1();
        T07_StaticFun.staticIn.method1();

//		T07_StaticFun.staticMethod1();
//		T07_StaticFun.staticMethod2();
    }
}