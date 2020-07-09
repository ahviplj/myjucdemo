package com.lj.unsafe;

import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;

/*
同理可证：ConcurrentModificationException
如何解决？
1.利用Collections工具类,调用同步方法，
        Set<String> set = Collections.synchronizedSet(new HashSet<>());
2.利用JUC包下的CopyOnWriteArraySet

 */
public class SetTest {
    public static void main(String[] args) {
        Set<String> set = new CopyOnWriteArraySet<>();
        Set<String> set1 = new HashSet<>();


        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0, 5));
                System.out.println(set);
            },String.valueOf(i)).start();
        }
    }
}
