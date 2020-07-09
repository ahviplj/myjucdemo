package com.lj.designmodel.factory.simple;
//静态/简单工厂模式，要添加新的产品，需要改变产品
public class CarFactory {
    public static Car getCar(String car){
        if (car.equals("Wuling")){
            return new Wuling();
        }else if(car.equals("Tesla")){
            return new Tesla();
        }else {
            return null;
        }
    }
//    //方法二：方法功能单一
//    public static Car getWuling(){
//        return new Wuling();
//    }
//
//    public static Car getTesla(){
//        return new Tesla();
//    }

}
