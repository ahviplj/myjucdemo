package com.lj.single;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

//enum本身也是一个类,枚举可以保证安全性，反射破坏不了
//枚举没有无参构造，只有有参构造，String.class,int.class两个参数
//其他单例不安全，因为有反射
public enum EnumSingle {

    INSTANCE;

    public EnumSingle getInstance(){
        return INSTANCE;
    }

}
class Test{
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        EnumSingle single =EnumSingle.INSTANCE;
        EnumSingle single2 =EnumSingle.INSTANCE;
//        NoSuchMethodException:
//        Constructor<EnumSingle> declaredConstructor = EnumSingle.class.getDeclaredConstructor(null);
        Constructor<EnumSingle> declaredConstructor = EnumSingle.class.getDeclaredConstructor(String.class,int.class);
        declaredConstructor.setAccessible(true);
        EnumSingle single1 = declaredConstructor.newInstance();
        System.out.println(single);
        System.out.println(single1);

        System.out.println(single);
        System.out.println(single2);
        System.out.println(single2.equals(single));
        System.out.println(single2==single2);


    }
}