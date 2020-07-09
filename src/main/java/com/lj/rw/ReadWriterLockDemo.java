package com.lj.rw;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ReadWriterLock是允许多个线程同时读，只允许一个线程写,虽然可以加lock锁或同步锁，但是这个更加细粒度的操作读写
 * 独占锁(写锁)一次只能被一个线程占有
 * 共亨锁(波锁) 多个线程可以同时占有
 * ReadWriteLock
 * 读-读 可以共存!
 * 读-写不能共存!
 * 写-写不能共存!
 */

public class ReadWriterLockDemo {
    //线程操作资源类
    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        for (int i = 1; i <= 6; i++) {
            final int temp = i;
            new Thread(()->{
                myCache.put(temp+"",temp+"");
            },String.valueOf(i)).start();
        }
        //读取
        for (int i = 1; i <= 6; i++) {
            final int temp = i;
            new Thread(()->{
                myCache.get(temp+"");
            },String.valueOf(i)).start();
        }
    }
}

class MyCache{
    //volatile关键字是保证可见性，原理是直接强制从主内存中读取该变量，而不是从方法栈中读取，保证了线程之间的可见性，
    // 但是在并发操作时是可以被任意一个线程修改的，所以没有保证原子性
    private volatile Map<String, Object> map = new HashMap<>();
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    //cun
    public void put(String key, Object value){
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"写入"+key);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName()+"写入完毕");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }
    //qu
    public void get(String key){
        readWriteLock.readLock().lock();

        try {
            System.out.println(Thread.currentThread().getName()+"读取"+key);
            map.get(key);
            System.out.println(Thread.currentThread().getName()+"读取完毕");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }

    }
}
