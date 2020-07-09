package com.lj.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableDemo {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        //使用适配器
        FutureTask futureTask = new FutureTask(myThread);
        //两个线程，会打印几个call，1个，因为结果被缓存了，高效
        new Thread(futureTask,"A").start();
        new Thread(futureTask,"B").start();
        try {
            Integer o = (Integer)futureTask.get();
            System.out.println(o);
            //System.out.println(Thread.currentThread().getName()+"执行");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}

class MyThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("call()");
        System.out.println(Thread.currentThread().getName()+"执行");

        return 1024;
    }
}
