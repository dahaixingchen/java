package com.chengfei.base.singleton.lazy;

/**
 * @ClassName: ClassLazySingleton
 * @Author chengfei
 * @DateTime 2022/4/26 22:35
 * @TODO:
 **/
public class ClassLazySingleton {

    private ClassLazySingleton(){}
    private static class ClassLazySingletonHolder{
        private final static ClassLazySingleton INSTANCE = new ClassLazySingleton();
    }

    public final static ClassLazySingleton getInstance(){
        return  ClassLazySingletonHolder.INSTANCE;
    }

    public void doSomeThing(){
        System.out.println("链接db");
    }
}
