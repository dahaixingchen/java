package com.feifei.c2_classloader;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @Description: 定义类的加载器，加载固定文件夹下面的class文件，变成一个class类
 * @ClassName: T04_ChengfeiClassFileByHand   com.mashibing.jvm.c2_classloader.T002_ClassLoaderLevel
 * @Author chengfei
 * @DateTime 2021/5/1 10:01
 * TODO：代码有问题，等弄懂了反射的内容再来
 **/
public class T04_ChengfeiClassFileByHand extends ClassLoader {
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File f = new File("E:/work-late-code/mashibingCode/JVM/out/production/JVM/"
                , name.replace(".", "/").concat(".class"));
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(f);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int b = 0;
            while ((b = fis.read()) != 0){
                baos.write(b);
            }

            byte[] bytes = baos.toByteArray();
            baos.close();
            fis.close();

            return defineClass(name,bytes,0,bytes.length);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return super.findClass(name);
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Class<?> loadClass = new T04_ChengfeiClassFileByHand().loadClass("com.mashibing.jvm.c2_classloader.T006_MSBClassLoader");

//        Class<?> loadClass = new T04_ChengfeiClassFileByHand().findClass("com.mashibing.jvm.c2_classloader.T006_MSBClassLoader");
        Object o = loadClass.newInstance();
        System.out.println(o.getClass());
        System.out.println(o.toString());
    }
}
