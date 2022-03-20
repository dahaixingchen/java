package com.feifei;

/**
 * @Description:
 * @ClassName: a
 * @Author chengfei
 * @DateTime 2021/5/1 12:26
 *
 * todo:1、抽象类是不能new的，native方法是C实现的函数
 **/
public class AbstractTestMain {
    public static void main(String[] args) {
        AbstractTest abstractTest = new AbstractTest() {
            @Override
            protected void find1() {
                System.out.println("AbstractTestMain 山海经");
            }
        };

        abstractTest.find2();
        abstractTest.find1();
        abstractTest.find();

//        AbstractTest2 abstractTest2 = new AbstractTest2();
    }
}
