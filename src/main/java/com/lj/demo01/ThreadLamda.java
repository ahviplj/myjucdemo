package com.lj.demo01;


/*
* 基本买票的例子
* 实际开发中，多线程是一个资源类，没有任何附属操作*/
public class ThreadLamda {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
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
class Ticket{
    private int num = 50;
    //本质上，队列，锁
    public synchronized void sale(){
        if (num>0){
            System.out.println(Thread.currentThread().getName()+"卖出了"+(num--)+"张票，还剩"+num+"张票");
        }
    }
}

