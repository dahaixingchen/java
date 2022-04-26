package com.chengfei.base.singleton.lazy;

/**
 * @ClassName: SimpLazySingleton1
 * @Author chengfei
 * @DateTime 2022/4/26 22:11
 * @TODO: 简单实现单例模式--懒汉式--》在代码运行过程中，代码调用到才去加载
 **/
public class SimpLazySingleton {
    private SimpLazySingleton() {
    }

    private static SimpLazySingleton singleton1;

    //这种是线程不安全的
//    public static SimpLazySingleton1 getInstance(){
//        if (singleton1 == null){
//            return new SimpLazySingleton1();
//        }
//        return singleton1;
//    }

    //这种是基于 synchronized 的方式
    public static synchronized SimpLazySingleton getInstance() {
        if (singleton1 == null) {
            return new SimpLazySingleton();
        }
        return singleton1;
    }

    public void doSomeThing(){
        System.out.println("链接db");
    }

}
