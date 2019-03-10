package cn.sxt.myCollection;

import java.util.HashMap;
import java.util.Map;

public class testMap {
    public static void main(String[] args){
        Map<Integer,String >m1=new HashMap<Integer, String>();
        Map<Integer,String >m2=new HashMap<Integer, String>();
        m1.put(1,"messi");
        m1.put(2,"lionel");
        m1.put(3,"andred");
        m2.put(1,"123");
        m2.put(2,"456");
        System.out.println(m1.size());
        System.out.println(m1.containsKey(1));
        System.out.println(m2.containsValue("123"));
        m1.put(3, "third"); //键重复了，则会替换旧的键值对
        Map<Integer, String> m3 = new HashMap<Integer, String>();
        m3.putAll(m1);
        m3.putAll(m2);
        System.out.println("m1:" + m1);
        System.out.println("m2:" + m2);
        System.out.println("m3:" + m3);
    }
}
