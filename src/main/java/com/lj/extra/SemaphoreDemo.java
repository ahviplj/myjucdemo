package com.lj.extra;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
//juc包中常用的辅助类之一
//信号量，作用两方面：一是用在 多个共享资源互斥的使用；
// 并发限流：控制最大的线程数
//acquire方法:获得，假设已经满了，会等待被释放为止，+1操作
// release方法，释放，会将当前的信号量释放，-1操作，然后唤醒等待的线程
//停车位，6车与三停车位
//原理，
public class SemaphoreDemo {
    public static void main(String[] args) {
        //三个线程数,在限流中用的比较多，springcloud!need to see
        Semaphore semaphore = new Semaphore(3);
        for (int i = 1; i <= 6; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"捡到车位");
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println(Thread.currentThread().getName()+"离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            },String.valueOf(i)).start();
        }


    }



}
