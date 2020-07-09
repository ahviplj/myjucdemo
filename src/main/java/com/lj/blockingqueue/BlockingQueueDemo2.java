package com.lj.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

//不抛出异常：offer，poll方法分别返回false和null，element(),peek()检测队首元素
public class BlockingQueueDemo2 {
    public static void main(String[] args) {
        BlockingQueue blockingQueue = new ArrayBlockingQueue(4);
        blockingQueue.offer("1");
        blockingQueue.offer("2");
        blockingQueue.offer("3");
        System.out.println(blockingQueue.offer("4"));
        System.out.println(blockingQueue.offer("5"));
        Object element = blockingQueue.element();
        Object peek = blockingQueue.peek();
        System.out.println("队首元素是："+element);
        System.out.println("队首元素是："+peek);

        for (int i = 0; i < 5; i++) {
            System.out.println(blockingQueue.poll());
        }
    }
}
