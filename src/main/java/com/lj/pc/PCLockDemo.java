package com.lj.pc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PCLockDemo {
    public static void main(String[] args) {
        Product2 product = new Product2();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    product.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    product.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    product.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"C").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    product.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"D").start();
    }


}

class Product2{
    private int num = 0;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public  void increment() throws InterruptedException {
        lock.lock();

        try {
            while (num!=0){
                //调用wait方法的时候 要用synchronized锁住对象，确保代码段不会被多个线程调用
                //java.lang.IllegalMonitorStateException会报错
                condition.await();//等待
                //this.wait();
            }
            num++;
            System.out.println(Thread.currentThread().getName()+"====>"+num);
            condition.signalAll();//唤醒全部
            //this.notifyAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public  void decrement() throws InterruptedException {
        lock.lock();
        try {
        while (num==0){
            //this.wait();
            condition.await();
        }
            num--;
            System.out.println(Thread.currentThread().getName()+"====>"+num);
            condition.signalAll();
            //this.notifyAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
