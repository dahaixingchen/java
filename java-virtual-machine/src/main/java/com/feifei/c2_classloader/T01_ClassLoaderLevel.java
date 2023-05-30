package com.feifei.c2_classloader;

/**
 * @Description: 校验classloader的规则
 * @ClassName: T01_ClassLoaderLevel
 * @Author chengfei
 * @DateTime 2021/5/1 10:01
 * TODO：1、jdk/jre/lib目录下的所有包都是最顶层的加载器，Bootstrap加载器加载的（它是c++实现的，代码中拿不到，它是null）
 *       2、jre/lib/ext目录下的类是ExtClassLoader加载
 *       3、所有自己写的class都是AppClassLoader加载（项目中classpath目录下的class文件）
 **/
public class T01_ClassLoaderLevel {
    public static void main(String[] args) {

        //结果：null
        //String所在的位置D:\service\job_tool\jdk1.8.0_91\jre\lib\
        System.out.println(String.class.getClassLoader());

        //结果：null
        //HKSCS 所在的位置D:\service\job_tool\jdk1.8.0_91\jre\lib\
        //java8才有这个类
//        System.out.println(sun.awt.HKSCS.class.getClassLoader());

        //结果：sun.misc.Launcher$ExtClassLoader@7ea987ac
        //DNSNameService 所在的位置D:\service\job_tool\jdk1.8.0_91\jre\lib\ext
        //java8才有这个类
//        System.out.println(sun.net.spi.nameservice.dns.DNSNameService.class.getClassLoader());

        //DNSNameService的classloader结果：null
        //java8才有这个类
//        System.out.println(sun.net.spi.nameservice.dns.DNSNameService.class.getClassLoader().getClass().getClassLoader());

        //结果：sun.misc.Launcher$AppClassLoader@18b4aac2
        //T01_ClassLoaderLevel 所在的位置：项目所在位置
        System.out.println(T01_ClassLoaderLevel.class.getClassLoader());
        System.out.println(new T01_ClassLoaderLevel().getClass().getClassLoader());


        //T01_ClassLoaderLevl的classloader的结果：null
        System.out.println(T01_ClassLoaderLevel.class.getClassLoader().getClass().getClassLoader());

    }
}
