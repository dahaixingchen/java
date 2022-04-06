package com.chengfei.base;

/**
 * @ClassName: coding
 * @Author chengfei
 * @DateTime 2022/3/25 16:22
 * @todo: 编码问题 关于中文 换成了有中文编码的字符集（UTF,GBK）
 *       ,换了之后一定要rebuild，重新生成.class文件才行
 **/
public class Coding {
    public static void main(String[] args) {
        //编码不能转成iso类型的，因为iso类型它是没有中文编码的，强转过去就转不回来了
        System.out.println("我们的爱");
    }
}
