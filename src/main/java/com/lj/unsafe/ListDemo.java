package com.lj.unsafe;

import java.util.Arrays;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("123", "456", "789");

        //我们看一下是java.lang.Iterable<T>下的一个默认方法forEach调用的
        //System.out::println这段代码其实就是Consumer<T>接口的一个实现方式啊

        list.forEach(System.out::println);
    }
}
