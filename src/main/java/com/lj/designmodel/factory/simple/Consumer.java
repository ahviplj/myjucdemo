package com.lj.designmodel.factory.simple;
//工厂模式特点：不使用new来创建实例，而是从工厂中获取
public class Consumer {
    public static void main(String[] args) {
//        原来的方式
//        Tesla tesla = new Tesla();
//        Wuling wuling = new Wuling();
//        tesla.name();
//        wuling.name();
//        工厂的方式
        Car wuling = CarFactory.getCar("Wuling");
        Car tesla = CarFactory.getCar("Tesla");
        wuling.name();
        tesla.name();
    }
}
