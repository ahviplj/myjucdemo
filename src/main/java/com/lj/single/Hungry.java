package com.lj.single;
//饿汉式单例模式：所谓饿就是一开始就将对象加载进内存，可能会造成内存浪费/浪费空间
public class Hungry {
    public static void main(String[] args) {

        System.out.println(getInstance());
        System.out.println(getInstance());
        System.out.println(getInstance());
    }
    private Hungry() {
    }

    private static final Hungry HUNGRY = new Hungry();

    public static Hungry getInstance(){
        return HUNGRY;
    }

}
