package com.feifei.c4_RuntimeDataAreaAndInstructionSet;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description:
 * @ClassName: T02_HelloGC
 * @Author chengfei
 * @DateTime 2021/5/8 18:36
 **/
public class T02_HelloGC {
    public static void main(String[] args) {
        System.out.println("HelloGC!");
        List list = new LinkedList();
        for(;;) {
            byte[] b = new byte[1024*1024];
            list.add(b);
        }
    }
}
