package com.lj.designmodel.factory.method;

import com.lj.designmodel.factory.simple.Car;
import com.lj.designmodel.factory.simple.CarFactory;

//工厂模式特点：不使用new来创建实例，而是从工厂中获取
public class Consumer {
    public static void main(String[] args) {
//        原来的方式
//        Tesla tesla = new Tesla();
//        Wuling wuling = new Wuling();
//        tesla.name();
//        wuling.name();
//        方法工厂的方式
        Car car1 = new WulingFactory().getCar();
        car1.name();
        Car car2 = new TeslaFactory().getCar();
        car2.name();
        //想买摩拜
        Car car3= new MobaiFactory().getCar();
        car3.name();
    }
}
