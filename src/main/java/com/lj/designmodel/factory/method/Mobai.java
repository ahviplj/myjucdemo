package com.lj.designmodel.factory.method;

import com.lj.designmodel.factory.simple.Car;

public class Mobai implements Car {

    @Override
    public void name() {
        System.out.println("摩拜");
    }
}
