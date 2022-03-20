package com.feifei.thread.c06_referenceType;

import java.io.IOException;

/**
 * @Description: 我们普通用new的方式创建的引用就是强引用
 * @ClassName: T01_NormalReference
 * @Author chengfei
 * @DateTime 2021/5/18 17:44
 **/
public class T01_NormalReference {

    public static void main(String[] args) throws IOException {
        T01_NormalReference m = new T01_NormalReference();
        m = null;
        System.gc(); //DisableExplicitGC

        System.in.read();
    }
}
