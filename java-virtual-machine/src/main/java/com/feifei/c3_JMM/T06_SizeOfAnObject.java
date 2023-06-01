package com.feifei.c3_JMM;


import com.fei.ObjectSizeAgent;

/**
 * 运行是jvm参数中加入：   -javaagent:C:\work\ijprojects\ObjectSize\out\artifacts\ObjectSize_jar\ObjectSize.jar
 *
 * 查看jvm的配置： java -XX:+PrintCommandLineFlags -version
 *
 * @param
 * @return:{@link null}
 * @DateTime: 2023/5/31 10:43
 */
public class T06_SizeOfAnObject {
    public static void main(String[] args) {
//        System.out.println(ObjectSizeAgent.sizeOf(new Object()));
//        //默认开启压缩：                                 8（markword）+4（类指针）+4（数组长度）+0（数组内容）+0（padding对齐）
//        //不开启压缩（-XX:-UseCompressedClassPointers）: 8（markword）+8（类指针）+4（数组长度）+0（数组内容）+4（padding对齐）
//        System.out.println(ObjectSizeAgent.sizeOf(new int[] {1,2}));
//        System.out.println(ObjectSizeAgent.sizeOf(new long[] {1,2})); //8+8+4+8+8+4=40
////        //8+8+4+4*3
//        System.out.println(ObjectSizeAgent.sizeOf(new P[] {new P(),new P(),new P(),new P(),new P()})); //
//        System.out.println(ObjectSizeAgent.sizeOf(new long[] {1,1})); //8+4+4+8*2
        //8+8+4+4
        System.out.println("**************int********************");
        System.out.println(ObjectSizeAgent.sizeOf(new int[] {1,1,9})); //8+8+4+4*2
        System.out.println(ObjectSizeAgent.sizeOf(new int[] {1,1})); //8+8+4+4*2
        System.out.println(ObjectSizeAgent.sizeOf(new int[] {1})); //8+8+4+8
        System.out.println(ObjectSizeAgent.sizeOf(new int[] {})); //8+8+4

        System.out.println("**************long********************");
        System.out.println(ObjectSizeAgent.sizeOf(new long[] {1,1,5})); //8+8+4+8*2
        System.out.println(ObjectSizeAgent.sizeOf(new long[] {1,1})); //8+8+4+8*2
        System.out.println(ObjectSizeAgent.sizeOf(new long[] {1})); //8+8+4+4
        System.out.println(ObjectSizeAgent.sizeOf(new long[] {})); //8+8+4

        System.out.println("**************{P}********************");
        System.out.println(ObjectSizeAgent.sizeOf(new P[] {new P(),new P(),new P()})); //8+8+4+8*2
        System.out.println(ObjectSizeAgent.sizeOf(new P[] {new P(),new P()})); //8+8+4+8*2
        System.out.println(ObjectSizeAgent.sizeOf(new P[] {new P()})); //8+8+4+4
        System.out.println(ObjectSizeAgent.sizeOf(new P[] {})); //8+8+4

//        System.out.println(ObjectSizeAgent.sizeOf(new P()));
    }

    //一个Object占多少个字节
    // -XX:+UseCompressedClassPointers -XX:+UseCompressedOops
    // Oops = ordinary object pointers
    private static class P {
                        //8 _markword
                        //4 _class pointer
        int id;         //4
        String name;    //4
        int age;        //4

        byte b1;        //1
        byte b2;        //1

        Object o;       //4
        byte b3;        //1
        byte b4;        //1
        byte b5;        //1

        long l;         //8

    }
}
