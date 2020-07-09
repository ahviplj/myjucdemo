package com.lj.unsafe;

import java.awt.datatransfer.StringSelection;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

//ConcurrentModificationException并发修改异常
//怎么解决？
/*
1.使用vector,不建议这种方式

2.利用Collections工具类,调用同步方法，

3.利用JUC包下的CopyOnWriteArrayList
        List<String> list = new CopyOnWriteArrayList<String>();

 */
public class ListDemo2 {
    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList<String>();
        //CopyOnWriteArrayList<>();

        for (int i = 1; i <= 10; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }

    }

}
