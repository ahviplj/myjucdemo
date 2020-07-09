package com.lj.designmodel.factory.method;

import com.lj.designmodel.factory.simple.Car;

public class WulingFactory implements CarFactory {
    @Override
    public Car getCar() {
        return new Wuling();
    }
}
