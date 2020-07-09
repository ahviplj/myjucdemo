package com.lj.pc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PCLockSortDemo {
    public static void main(String[] args) {
        Product3 product3 = new Product3();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    product3.ptintA();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    product3.ptintB();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    product3.ptintC();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"C").start();
    }

}

class Product3{
    private int num = 1;
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3= lock.newCondition();

    public void ptintA() throws InterruptedException {
        lock.lock();
        try {
            //判断--》唤醒
            while (num!=1){
                condition1.await();
            }
            System.out.println(Thread.currentThread().getName()+"---------------"+num+"AAAAAAAAAAA");
            num=2;
            condition2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void ptintB() throws InterruptedException {
        lock.lock();
        try {
            //判断--》唤醒
            while (num!=2){
                condition2.await();
            }
            System.out.println(Thread.currentThread().getName()+"---------------"+num+"BBBBBBBBB");

            num=3;
            condition3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void ptintC() throws InterruptedException {
        lock.lock();
        try {
            //判断--》唤醒
            while (num!=3){
                condition3.await();
            }
            System.out.println(Thread.currentThread().getName()+"---------------"+num+"CCCCCCCCCCCCC");

            num=1;
            condition1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


}
