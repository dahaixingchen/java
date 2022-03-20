package com.feifei.c2_classloader;

public class T006_ClassLoadInit {
    public static void main(String[] args) {
        System.out.println(T.count);
    }
}

/**
  * @Todo: public static int count = 2 这句放在前面，答案是3，它如果放在后面答案就变成了2
 *         因为静态代码的执行顺序问题
  * @DateTime: 2021/5/1 18:49
 */
class T {
    public static int count = 2; //0
    public static T t = new T(); // null

    //private int m = 8;

    private T() {
        count ++;
        //System.out.println("--" + count);
    }
}
