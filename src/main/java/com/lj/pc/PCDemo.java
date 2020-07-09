package com.lj.pc;

public class PCDemo {
    public static void main(String[] args) {
        Product product = new Product();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    product.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    product.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    product.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"C").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    product.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"D").start();
    }


}

class Product{
    private int num = 0;

    public synchronized void increment() throws InterruptedException {
        while (num!=0){
            //调用wait方法的时候 要用synchronized锁住对象，确保代码段不会被多个线程调用
            //java.lang.IllegalMonitorStateException会报错
            this.wait();
        }
        num++;
        System.out.println(Thread.currentThread().getName()+"====>"+num);
        this.notifyAll();
    }

    public synchronized void decrement() throws InterruptedException {
        while (num==0){
            this.wait();
        }
        num--;
        System.out.println(Thread.currentThread().getName()+"====>"+num);

        this.notifyAll();
    }
}
