package com.feifei.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

/**
 * @ClassName: SelfPhantomReferenceExample
 * @Author chengfei
 * @DateTime 2024/9/3 18:00
 * @TODO:
 **/
public class SelfPhantomReferenceExample {
    /**
     * 用户类
     */
    static class User {
        public DatabaseClient databaseClient;
        public User() {
            // 初始化客户端
            databaseClient = new DatabaseClient();
            // 创建时数据库创建数据
            this.databaseClient.create();
        }
    }
    /**
     * 数据库客户端
     */
    static class DatabaseClient {
        /**
         * 创建用户数据
         */
        public void create() {
            System.out.println("--数据库创建用户数据--");
        }
        /**
         * 删除用户数据
         */
        public void remove() {
            System.out.println("--数据库删除用户数据--");
        }
    }

    //正常释放是不会自动关闭数据库连接的
//    public static void main(String[] args) {
//        User obj = new User();
//        // 释放这个内存空间
//        obj = null;
//        // 调用gc
//        System.gc();
//    }

    static class UserPhantomReference extends PhantomReference<User> {
        // 保存user的databaseClient 因为取不到user对象
        public DatabaseClient databaseClient;

        public UserPhantomReference(User referent, ReferenceQueue<? super User> q) {
            super(referent, q);
            this.databaseClient = referent.databaseClient;
        }
    }
    public static void main(String[] args) {
        // 新建一个对象，开辟一个内存空间
        User obj = new User();
        // 存储被回收的对象
        ReferenceQueue<User> QUEUE = new ReferenceQueue<>();
        // phantomReference使用虚引用指向这个内存空间
//        UserPhantomReference phantomReference = new UserPhantomReference(obj, QUEUE);
        SoftReference phantomReference = new SoftReference(obj, QUEUE);
        // 释放这个内存空间，此时只有phantomReference通过虚引用指向它
        obj = null;
        // 调用gc
        System.gc();
        // 被清除的队列中取出被回收的对象，一般新开一个线程来监控
        while (true) {
            Reference<? extends User> poll = QUEUE.poll();
            if (poll!=null) {
                UserPhantomReference userPhantomReference = (UserPhantomReference) poll;
                // 对象被回收，删除对应数据
                userPhantomReference.databaseClient.remove();
                System.out.println("--obj is recovery--");
            }
        }
    }
}
