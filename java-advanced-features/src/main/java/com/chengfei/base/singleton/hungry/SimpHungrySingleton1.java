package com.chengfei.base.singleton.hungry;

/**
 * @ClassName: SimpHungrySingleton
 * @Author chengfei
 * @DateTime 2022/4/26 21:39
 * @TODO: 简单实现单例模式--饿汉式--》在启动类加载的时候就启动的方式
 **/
public class SimpHungrySingleton1 {
    private SimpHungrySingleton1(){}
    public final static SimpHungrySingleton1 singleton = new SimpHungrySingleton1();
    public void doSomeThing(){
        System.out.println("链接db");
    }
}
