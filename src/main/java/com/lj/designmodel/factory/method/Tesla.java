package com.lj.designmodel.factory.method;

import com.lj.designmodel.factory.simple.Car;

public class Tesla implements Car {
    @Override
    public void name() {
        System.out.println("特斯拉！");
    }
}
