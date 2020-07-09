package com.lj.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

//等待，阻塞，一直阻塞
//等待，阻塞，等待超时
public class BlockingQueueDemo3 {
    public static void main(String[] args) throws InterruptedException {
            test02();
    }

    public static void test01() throws InterruptedException {
        BlockingQueue blockingQueue = new ArrayBlockingQueue(3);
        blockingQueue.put("a");
        blockingQueue.put("v");
        blockingQueue.put("c");
        // blockingQueue.put("d");//队列没有位置了，一直阻塞等待着

        for (int i = 0; i < 4; i++) {
            blockingQueue.take();//没有这个元素，一直阻塞
        }
        //blockingQueue.take();
    }
    public static void test02() throws InterruptedException {
        BlockingQueue blockingQueue = new ArrayBlockingQueue(3);
        blockingQueue.offer("a");
        blockingQueue.offer("b");
        System.out.println(blockingQueue.offer("c"));
        blockingQueue.offer("d",2, TimeUnit.SECONDS);

        blockingQueue.poll();
        blockingQueue.poll();
        System.out.println(blockingQueue.poll());
        blockingQueue.poll(2,TimeUnit.SECONDS);


    }


}
