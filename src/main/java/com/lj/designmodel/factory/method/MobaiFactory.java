package com.lj.designmodel.factory.method;

import com.lj.designmodel.factory.simple.Car;

public class MobaiFactory implements CarFactory {
    @Override
    public Car getCar() {
        return new Mobai();
    }
}
