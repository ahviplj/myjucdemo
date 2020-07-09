package com.lj.demo01;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
* 基本买票的例子
* 实际开发中，多线程是一个资源类，没有任何附属操作*/
public class ThreadLamda2 {
    public static void main(String[] args) {
        Ticket2 ticket = new Ticket2();
        //并发：多线程操作同一个资源,三个线程
        //()-> { } { }里面是代码，
        //Ctrl alt t  or alt+T

        new Thread(()-> {
            for (int i = 0; i < 60; i++) {
                ticket.sale();
            }
        },"A").start();
        new Thread(()-> {
            for (int i = 0; i < 60; i++) {
                ticket.sale();
            }
        },"B").start();
        new Thread(()-> {
            for (int i = 0; i < 60; i++) {
                ticket.sale();
            }
        },"C").start();

    }
}
class Ticket2{
    private int num = 50;
    Lock lock = new ReentrantLock();
    //本质上，队列，锁
    public void sale(){
        lock.lock();

        try {
            if (num>0){
                System.out.println(Thread.currentThread().getName()+"卖出了"+(num--)+"张票，还剩"+num+"张票");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

