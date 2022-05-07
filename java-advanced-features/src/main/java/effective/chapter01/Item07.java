package effective.chapter01;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Item07
 * @Author chengfei
 * @DateTime 2022/5/2 18:52
 * @TODO: 消除过期的对象，内存泄露，发生的原因，就是自己关系内存导致
 *
 **/
public class Item07 {
    public static void main(String[] args) throws InterruptedException {
        List<byte[]> arrayList = new ArrayList<>();
        arrayList.add(new byte[1024*1024*10]);
        arrayList.add(new byte[1024*1024*10]);

        arrayList = null;
//        System.gc();
//        Thread.sleep(2000);
        byte[] bytes = new byte[1024 * 1024 * 20];
        System.out.println("程序运行到这里说明申请内存成功");
    }
}
