package com.chengfei.base.singleton.lazy;

/**
 * @ClassName: TwoRetryLazySingleton
 * @Author chengfei
 * @DateTime 2022/4/26 22:32
 * @TODO: 双重校验，有效的提供了单用锁的效率，
 *   静态成员变量singleton必须通过volatile来修饰，保证其初始化不被重排，否则可能被引用到一个未初始化完成的对象
 **/
public class TwoRetryLazySingleton {
    private TwoRetryLazySingleton() {}

    private volatile static TwoRetryLazySingleton singleton;
    //双重校验，提供效率
    public static TwoRetryLazySingleton getHighInstance() {
        if (singleton == null) {
            synchronized (SimpLazySingleton.class) {
                if (singleton == null) {
                    return new TwoRetryLazySingleton();
                }
            }
        }
        return singleton;
    }

    public void doSomeThing(){
        System.out.println("链接db");
    }
}
