package com.feifei.c2_classloader;

/**
 * @Description: 各种classloader加载类的范围
 * @ClassName: T01_ClassLoaderLevel
 * @Author chengfei
 * @DateTime 2021/5/1 10:01
 * TODO：
 **/
public class T02_ClassLoaderScope {
    public static void main(String[] args) {
        System.out.println("项目的目录");
        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);

        System.out.println("************************************");

        System.out.println("项目中所有用到的class文件的jar包所在的位置");
        String allJarPath = System.getProperty("java.class.path");
        System.out.println(allJarPath.replaceAll(";",System.lineSeparator()));

        System.out.println("************************************");

        System.out.println("Bootstrap类加载器的位置");
        //Launcher 类源码中写了 private static String bootClassPath = System.getProperty("sun.boot.class.path");
        String bootPath = System.getProperty("sun.boot.class.path");
        System.out.println(bootPath.replaceAll(";",System.lineSeparator()));

        System.out.println("************************************");

        System.out.println("Appclassloader加载器的路径");
        String pathExt = System.getProperty("java.ext.dirs");
        System.out.println(pathExt.replaceAll(";", System.lineSeparator()));

        System.out.println("************************************");

        //APPClassLoader，只能加载本项目中的类，所有需要自定义ClassLoader来加载外部的类
        System.out.println("--------------------");
        String pathApp = System.getProperty("java.class.path");
        System.out.println(pathApp.replaceAll(";", System.lineSeparator()));

        System.out.println("--------------------");
        System.out.println(T02_ClassLoaderScope.class.getClassLoader());

    }
}
