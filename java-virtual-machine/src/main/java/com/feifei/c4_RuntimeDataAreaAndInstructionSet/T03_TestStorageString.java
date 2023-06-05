package com.feifei.c4_RuntimeDataAreaAndInstructionSet;

/**
 * @ClassName: T03_TestStorageString
 * @Author chengfei
 * @DateTime 2023/6/3 9:18
 * @TODO:
 **/
public class T03_TestStorageString {
    public static void main(String[] args) {
        /**
         * 下面的例子说明字符串是在字符串常量中，对象是在堆中
         * 通过new的方式创建的字符串，会在常量池和对中都创建对象
         */
        String str1 = "hello";
        String str2 = "hello";
        String str3 = new String("hello");
        System.out.println(str1 == str2);//true
        System.out.println(str1 == str3);//fasle
        System.out.println(str2 == str3);//fasle
        System.out.println(str1.equals(str2));//true
        System.out.println(str1.equals(str3));//true
        System.out.println(str2.equals(str3));//true

        System.out.println("*********************************************");
        String str11 = "hello";
        String str22 = "helloworld";
        String str33 = str11+"world";//编译器不能确定为常量(会在堆区创建一个String对象)
        String str44 = "hello"+"world";//编译器确定为常量，直接到常量池中引用

        System.out.println(str22==str33);//fasle
        System.out.println(str22==str44);//true
        System.out.println(str33==str44);//fasle

        System.out.println("*********************************************");
        String str111 = "hello";//字面量 只会在常量池中创建对象
        String str222 = str111.intern();
        System.out.println(str111==str222);//true

        String str333 = new String("world");//new 关键字只会在堆中创建对象
        String str444 = str333.intern();
        System.out.println(str333 == str444);//false

        String str555 = str111 + str222;//变量拼接的字符串，会在常量池中和堆中都创建对象
        String str666 = str555.intern();//这里由于池中已经有对象了，直接返回的是对象本身，也就是堆中的对象
        System.out.println(str555 == str666);//true

        String str777 = "hello1" + "world1";//常量拼接的字符串，只会在常量池中创建对象
        String str888 = str777.intern();
        System.out.println(str777 == str888);//true
    }
}
