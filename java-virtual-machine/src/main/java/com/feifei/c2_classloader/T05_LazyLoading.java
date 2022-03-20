package com.feifei.c2_classloader;

/**
 * @Description:
 * @ClassName: T05_LazyLoading
 * @Author chengfei
 * @DateTime 2021/5/1 18:05
 **/
public class T05_LazyLoading {
    public static void main(String[] args) throws Exception {
        // 实时简单的声明，是不会初始化任何的东西的
//        P p;

        //new实例了就会初始化里面的所以的静态方法，静态代码块，静态变量
//        new P();

        //会先去初始化父类的
//        X x = new X();

        //final修饰的变量调用的时候，是不会惊动整个类的静态变量初始化的
//        System.out.println(P.i);

        //调用静态变量的时候，会先初始化静态的代码块
//        System.out.println(P.j);

        //会调用静态的代码块
        Class.forName("com.feifei.c2_classloader.T05_LazyLoading$P");

    }

    public static class P {
        final static int i = 8;
        static int j = 9;
        static {
            System.out.println("P");
        }

        //所有的方法，不管是静态的还是普通的方法，都不会被初始化的
        private static void t(){
            System.out.println("PT");
        }
        private void tt(){
            System.out.println("PTT");
        }
    }

    public static class X extends P {
        static {
            System.out.println("X");
        }
    }
}
