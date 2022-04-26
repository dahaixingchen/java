package com.chengfei.base.singleton.hungry;

/**
 * @ClassName: SimpHungrySingleton
 * @Author chengfei
 * @DateTime 2022/4/26 21:39
 * @TODO: 简单实现单例模式--饿汉式--》在启动类加载的时候就启动的方式
 *        通过静态工厂的方法创建，有静态工厂方法独特的优势
 **/
public class SimpHungrySingleton2 {
    private SimpHungrySingleton2(){}
    private final static SimpHungrySingleton2 singleton = new SimpHungrySingleton2();

    public static SimpHungrySingleton2 getInstance(){
        return singleton;
    }
    public void doSomeThing(){
        System.out.println("链接db");
    }
}
