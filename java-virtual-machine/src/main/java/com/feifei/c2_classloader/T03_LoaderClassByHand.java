package com.feifei.c2_classloader;

import com.feifei.serializable.Uesr;

/**
 * @Description: 从外部通过loadclass的方式来创建class对象
 * @ClassName: T03_LoaderClassByHand
 * @Author chengfei
 * @DateTime 2021/5/1 10:01
 * TODO：
 **/
public class T03_LoaderClassByHand {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> aClass = T03_LoaderClassByHand.class.getClassLoader().loadClass("com.feifei.serializable.Uesr");
        System.out.println(aClass.getName());

        Object instance = aClass.newInstance();
        Uesr user = (Uesr)instance;
        user.setName("xuxu");
        System.out.println(user.getName());

    }
}
