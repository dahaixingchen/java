package com.feifei.c4_RuntimeDataAreaAndInstructionSet;

/**
 * @Description:
 * @ClassName: T01_TestPlusPlus
 * @Author chengfei
 * @DateTime 2021/5/2 15:11
 **/
public class T01_TestPlusPlus {
    public static void main(String[] args) {
        int i = 8;
//        i = i++; //先压栈后，再赋值,所有还是8
        i = ++i; //先+1然后然后压栈，这样就是9了
//        i++;  结果是9
//        ++i;  结果是9
        System.out.println(i);
    }
}
