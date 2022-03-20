package com.feifei;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * @Description:
 * @ClassName: HashMapTest
 * @Author chengfei
 * @DateTime 2021/5/22 18:06
 **/
public class HashMapTest {
    public static void main(String[] args) {
        Hashtable<String, String> map = new Hashtable<>();
        map.put("a","s");
        map.put("a","s1");
        map.put("a","s2");
        map.forEach((k,v)->{
            System.out.println(k+":"+v);
        });
    }
}
