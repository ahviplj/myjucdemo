package com.lj.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
//抛出异常
public class BlockingQueueDemo {
    public static void main(String[] args) {
        BlockingQueue blockingQueue = new ArrayBlockingQueue(4);
        for (int i = 1; i <= 4; i++) {
            System.out.println(blockingQueue.add(i));
            System.out.print(i);
        }
        //java.lang.IllegalStateException: Queue full
        //
        // blockingQueue.add("123");
        for (int i = 1; i <= 4; i++) {
            System.out.println(blockingQueue.remove(i));
            System.out.print(i);
        }
        //java.util.NoSuchElementException
        //System.out.println(blockingQueue.remove());

    }
}
