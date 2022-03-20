package com.feifei.thread.c06_referenceType;

import java.lang.ref.WeakReference;

/**
 * @Description: 弱引用遇到gc就会回收
 * @ClassName: T03_WeakReference
 * @Author chengfei
 * @DateTime 2021/5/18 17:59
 **/
public class T03_WeakReference {
    public static void main(String[] args) {
        WeakReference<M> m = new WeakReference<>(new M());

        System.out.println(m.get());
        System.gc();
        System.out.println(m.get());


        ThreadLocal<M> tl = new ThreadLocal<>();
        tl.set(new M());
        tl.remove();

    }

}
