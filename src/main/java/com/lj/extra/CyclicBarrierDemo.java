package com.lj.extra;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
//CyclicBarrier类似加法计数器
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        //集齐七颗龙珠召唤神龙
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{
            System.out.println("召唤神龙成功！");
        });
        //lamda表达式不能拿到i
        //只能拿到final修饰的变量
        for (int i = 1; i <= 7; i++) {
            final int temp = i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"收集"+temp+"颗龙珠");
                //System.out.println(temp);
                ////等待计数器到7，再往下执行
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }

        //System.out.println("召集龙珠成功！");
    }
}

