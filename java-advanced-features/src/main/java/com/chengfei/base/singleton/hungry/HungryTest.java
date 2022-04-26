package com.chengfei.base.singleton.hungry;

/**
 * @ClassName: hungry
 * @Author chengfei
 * @DateTime 2022/4/26 21:35
 * @TODO: 单例的实现--饿汉式
 **/
public class HungryTest {
    public static void main(String[] args) {
        SimpHungrySingleton1.singleton.doSomeThing();

        SimpHungrySingleton2.getInstance().doSomeThing();
    }
}
