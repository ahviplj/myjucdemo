package com.lj.single;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

//懒汉式单例模式
public class LazyMan {

    private static boolean lj = false;

    private LazyMan() {
        synchronized (LazyMan.class){
            if (lj == false){
                lj = true;
            }else {
                throw new RuntimeException("不要试图使用反射搞破坏异常");
            }
        }
        System.out.println(Thread.currentThread().getName()+"=>ok");

    }

    private static volatile LazyMan lazyMan;
    //单线程下确实OK
    public static LazyMan getInstance(){
        //加锁，解决多线程并发问题
        /**
         * 这段代码做了什么？
         * 1.分配内存空间
         * 2.执行构造方法，创建对象
         * 3.将对象引用指向分配的内存空间
         *
         * 有可能发生指令重排？例如1-3-2执行，另一个线程B误以为对象不为空，对象已经构造完成，直接返回对象造成问题
         */
        //双重检测锁模式的懒汉式单例  简称  DCL懒汉式
        if (lazyMan==null) {
            synchronized (LazyMan.class) {
                if (lazyMan == null) {
                    lazyMan =  new LazyMan();
                }
            }
        }

        return lazyMan;
    }

    public static void main(String[] args) throws Exception {
        //利用反射显示不安全！,反射破坏单例模式，如何解决？
        Field lj = LazyMan.class.getDeclaredField("lj");
        lj.setAccessible(true);
        //LazyMan instance = LazyMan.getInstance();
        Constructor<LazyMan> declaredConstructor = LazyMan.class.getDeclaredConstructor(null);
        //使之可以无视私有的构造器
        declaredConstructor.setAccessible(true);
        LazyMan instance2 = declaredConstructor.newInstance();
        lj.set(instance2,false);
        LazyMan instance3 = declaredConstructor.newInstance();
        //System.out.println(instance);
        System.out.println(instance2);
        System.out.println(instance3);
//        System.out.println(instance3.equals(instance2));false
//        System.out.println(instance3==instance2);
//        for (int i = 0; i < 10; i++) {
//            new Thread(()->{
//                LazyMan.getInstance();
//            }).start();
//        }
    }
}
