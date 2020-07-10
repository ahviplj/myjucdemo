package com.lj.justtoolc;

import com.alibaba.druid.sql.visitor.functions.Ucase;
import com.fasterxml.jackson.databind.util.Converter;
import com.lc.core.StrFormatter;
import com.lc.core.convert.Convert;
import com.lc.lang.UConsole;
import com.lc.lang.UDict;
import com.lc.utils.UArrayUtil;
import com.lc.utils.UBase64Util;
import com.lc.utils.UDateUtil;
import org.junit.Test;
import sun.rmi.runtime.Log;

import java.io.Console;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;

public class TestJustToollc {
    public static void main(String[] args) {

//        System.out.println(UDateUtil.getNowTime_EN_yMdH());
//        返回字符串时间 日期时间格式:yyyy年MM月dd日HH, getNowTime_CN_yMdH
//        System.out.println(UDateUtil.getNowTime_CN_yMdH());
//
//        int[] arr = new int[10];
//        System.out.println(UArrayUtil.isArray(arr));//true
//        for (int i = 0; i < arr.length; i++) {
//               arr[i]=i;
//        }
//        System.out.println(UArrayUtil.min(arr));//0
//        UConsole.log("我是{}","lj");//我是lj
//        UConsole.log("hello {}","lj");
//        UConsole.log("你是性别是{}","男/女");
//        UConsole.log("现在是"+UDateUtil.getNowTime_CN_yMdHm());
//        UConsole.log(5);//5
//        UConsole.print("print\n");
//        UConsole.print("我是{}", "print");
//        UConsole.log();
//        UConsole.print(StrFormatter.format("我是{},今年{},nice to meet you!", "LJ", 3));
//        UConsole.log();
//        UConsole.error("error");
//        UConsole.error("你的错误是{}", "Error");

//        UConsole.log(Convert.numberToChinese(2014d,false));
//        UConsole.log(Convert.numberToChinese(2014d,true));

//        String encode = UBase64Util.encode("123456", "utf-8");
//        UConsole.log(encode);//MTIzNDU2
//        UConsole.log(UBase64Util.decode(encode));

        //字典对象，扩充了HashMap中的方法
//        UDict hash_Dict = UDict.create().set("1",1).set("2",2).set("3",3);
//        UConsole.log(hash_Dict);//{1=1, 2=2, 3=3}
//        UConsole.log(hash_Dict.size());//3
//        UConsole.log(hash_Dict.get("1"));//1
//        UConsole.log(hash_Dict.containsKey("3"));//true
//        UConsole.log(hash_Dict.containsValue("6"));//false

        UDict hash_Dict = UDict.create().set("1",1111).set("2",2222).set("3",3);

        for (Map.Entry<String, Object> entry : hash_Dict.entrySet()) {
            UConsole.log("key为{}，value为{}",entry.getKey(),entry.getValue());
        }


    }
    @Test
    public void UBase64UtilTest1() throws UnsupportedEncodingException {

//        byte[] byte_123456 = UBase64Util.decode(encode);
//        String str_byte_123456 = new String(byte_123456, "utf-8");
//        UConsole.log(str_byte_123456);//123456


        // 以下encode源格式是16进制字符串(源格式HEX字符)，先将16进制字符串转成byte[] ，再将byte[]传入
        String toBase64Str = UBase64Util.encodeHexStrToByteArrayToBase64Str("123456");
        UConsole.log(toBase64Str); // EjRW
        // 以下decode输入base64源格式是字符串，转成byte[] ，再将byte[]转成16进制字符串输出 (解码显示方式为16进制HEX)
        String toString = UBase64Util.decodeBase64StrToByteArrayToHexStr(toBase64Str);
        UConsole.log(toString); //123456


    }
}
