package com.chengfei.base.singleton.lazy;

/**
 * @ClassName: LazyTest
 * @Author chengfei
 * @DateTime 2022/4/26 22:11
 * @TODO:
 **/
public class LazyTest {
    public static void main(String[] args) {
        ClassLazySingleton instance = ClassLazySingleton.getInstance();
        instance.doSomeThing();
    }
}
