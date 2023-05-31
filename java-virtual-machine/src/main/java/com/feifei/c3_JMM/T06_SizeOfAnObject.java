package com.feifei.c3_JMM;


import com.fei.ObjectSizeAgent;

public class T06_SizeOfAnObject {
    public static void main(String[] args) {
        System.out.println(ObjectSizeAgent.sizeOf(new Object()));
        //默认开启压缩：8（markword）+4（类指针）+4（数组长度）+0（数组内容）+0（padding对齐）
        //不开启压缩（-XX:-UseCompressedClassPointers）：8（markword）+8（类指针）+4（数组长度）+0（数组内容）+4（padding对齐）
        System.out.println(ObjectSizeAgent.sizeOf(new int[] {1,2}));
        System.out.println(ObjectSizeAgent.sizeOf(new long[] {1,2}));
        System.out.println(ObjectSizeAgent.sizeOf(new P()));
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
