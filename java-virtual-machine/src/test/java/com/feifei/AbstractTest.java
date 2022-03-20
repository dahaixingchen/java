package com.feifei;

/**
 * @Description: native关键词是C语言实现的函数
 * @ClassName: AbstractTest
 * @Author chengfei
 * @DateTime 2021/5/1 12:26
 *
 **/
public abstract class AbstractTest {


    private native final Class<?> findLoadedClass0(String name);

    public native void find();
    protected abstract void find1();

    public void find2() {
        System.out.println("我是find2在抽象类中实现过的");
    }

}
