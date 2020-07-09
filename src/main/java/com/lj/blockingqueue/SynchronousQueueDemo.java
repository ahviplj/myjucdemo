package com.lj.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

//同步队列，和其他queue不一样，因为他不能存储元素，你put一次，,只有取出去后，才能再次put一个元素
public class SynchronousQueueDemo {
    public static void main(String[] args) throws InterruptedException {
//        SynchronousQueue synchronousQueue = new SynchronousQueue();
//        synchronousQueue.put("123");
//        synchronousQueue.put("345");
        BlockingQueue<String> blockingQueue = new SynchronousQueue<>();
            new Thread(()->{
                try {
                    System.out.println(Thread.currentThread().getName()+"=> put 123");
                    blockingQueue.put("123");
                    System.out.println(Thread.currentThread().getName()+"=> put 456");
                    blockingQueue.put("456");
                    System.out.println(Thread.currentThread().getName()+"=> put 789");
                    blockingQueue.put("789");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();

        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName()+"=> take"+blockingQueue.take());
                System.out.println(Thread.currentThread().getName()+"=> take"+blockingQueue.take());
                System.out.println(Thread.currentThread().getName()+"=> take"+blockingQueue.take());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();




    }
}
