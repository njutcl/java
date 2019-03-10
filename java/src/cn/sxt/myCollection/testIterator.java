package cn.sxt.myCollection;

import java.util.*;

public class testIterator {
    public static void main(String[] args){
        List<String> aList=new ArrayList<String>();
    for (int i=0;i<5;i++){
        aList.add("a"+i);
    }
    System.out.println(aList);
    for (Iterator<String>iter=aList.iterator();iter.hasNext();){
        String temp=iter.next();
        System.out.print(temp+"\t");
    if(temp.endsWith("3")){
        iter.remove();
    }
    }
System.out.println();
System.out.println(aList);
        System.out.println();

        Set<String> set = new HashSet<String>();
        for (int i = 0; i < 5; i++) {
            set.add("a" + i);
        }
        System.out.println(set);
        for (Iterator<String> iter = set.iterator(); iter.hasNext();) {
            String temp = iter.next();
            System.out.print(temp + "\t");
        }
        System.out.println();
        System.out.println(set);
        System.out.println();

//        Map<String, String> map = new HashMap<String, String>();
//        map.put("A", "高淇");
//        map.put("B", "高小七");
//        Set<Entry<String, String>> ss = map.entrySet();
//        for (Iterator<Entry<String, String>> iterator = ss.iterator(); iterator.hasNext();) {
//            Entry<String, String> e = iterator.next();
//            System.out.println(e.getKey() + "--" + e.getValue());
//        }
//        System.out.println();
        Map<String, String> map = new HashMap<String, String>();
        map.put("A", "高淇");
        map.put("B", "高小七");
        Set<String> ss = map.keySet();
        for (Iterator<String> iterator = ss.iterator(); iterator.hasNext();) {
            String key = iterator.next();
            System.out.println(key + "--" + map.get(key));
        }
    }
}
