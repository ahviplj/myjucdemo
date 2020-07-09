package lock8;

import java.util.concurrent.TimeUnit;

/*
普通同步方法，静态同步方法，一个对象
普通同步方法，静态同步方法，两个对象
打电话！
发短信！
 */
public class Test4 {
    public static void main(String[] args) {
        //两个对象的class模板只有一个，所以锁的是同一个Class
        Phone4 phone = new Phone4();
        Phone4 phone1 = new Phone4();
        new Thread(()->{
            phone.sendMsg();
        },"A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            phone1.call();
        },"B").start();


    }


}

class Phone4 {
    //锁的对象是方法的调用者
    //static方法，类一加载就有了，所以锁的是Class
    public static synchronized void sendMsg(){
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信！");

    }

    public synchronized void call(){
        System.out.println("打电话！");
    }

}
