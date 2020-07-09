package com.lj.single;
//第三种：静态内部类实现,但是也不安全
public class Holder {
    public static void main(String[] args) {

    }

    private Holder(){

    }

    public static Holder getInstance(){
        return InnerClass.HOLDER;
    }
    //静态内部类
    public static class InnerClass{
        private static final Holder HOLDER = new Holder();

    }
}
