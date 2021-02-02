package com.iz0819.www.streams;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Maps {
    public static void main(String args[]) {
        Map<Integer, String> m1 = new HashMap();
        m1.put(1, "Rakesh");
        m1.put(112, "Aman");
        m1.put(32, "Pramesh");
        m1.put(89, "Nishant");

        //lambda
        m1.forEach((k,v) -> System.out.println(v));

        // stream
        m1.entrySet().stream().forEach(e -> System.out.println(e));

        // forloop
        for(Map.Entry <Integer,String> m : m1.entrySet()) {
            System.out.println(m.getKey() + " = " + m.getValue());
        }

        // iterator
        Iterator<Map.Entry<Integer, String>> itr =  m1.entrySet().iterator();
        while(itr.hasNext()) {
            Map.Entry<Integer,String > m = itr.next();
            System.out.println(m.getKey() + " = " + m.getValue());
        }

        //sort on key
        m1.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);
        m1.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);

        Map<Integer, String> m2 = Map.of(1,"ravi", 2, "akash");
        System.out.println(m2);

    }


}
