package lock8;

import java.util.concurrent.TimeUnit;
/*
增加两个静态的锁
 */
public class Test3 {
    public static void main(String[] args) {
        //两个对象的class模板只有一个，所以锁的是同一个Class
        Phone3 phone = new Phone3();
        Phone3 phone1 = new Phone3();
        new Thread(()->{
            phone.sendMsg();
        },"A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            phone.call();
        },"B").start();


    }


}

class Phone3 {
    //锁的对象是方法的调用者
    //static方法，类一加载就有了，所以锁的是Class
    public static synchronized void sendMsg(){
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信！");
        Class<Phone3> phone3Class = Phone3.class;
        System.out.println(phone3Class);
    }

    public static synchronized void call(){
        System.out.println("打电话！");
    }

}
