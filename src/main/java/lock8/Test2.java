package lock8;

import java.util.concurrent.TimeUnit;
//增加了一个普通方法，先执行普通方法，不受锁的影响
public class Test2 {
    public static void main(String[] args) {
        //两个不同的对象，两把锁
        Phone2 phone = new Phone2();
        Phone2 phone1 = new Phone2();
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

class Phone2 {
    public synchronized void sendMsg(){
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

    public void hello(){
        System.out.println("hello!");
    }
}
