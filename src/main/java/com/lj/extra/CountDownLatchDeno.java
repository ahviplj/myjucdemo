package com.lj.extra;

import java.util.concurrent.CountDownLatch;

//这是一个减法计数器
//await方法，countDown方法
public class CountDownLatchDeno {
    public static void main(String[] args) throws InterruptedException {
        //构造器参数计数总数
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 1; i <= 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+" go out!");
                //数量减一
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }
        //等待计数器归0，再往下执行
        countDownLatch.await();
        System.out.println("close door!");
    }
}
