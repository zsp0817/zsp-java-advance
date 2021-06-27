package com.zsp.fun.jvm.bytecode;

/**
 * Created by zhangshaopeng on 2021/6/24.
 *
 * 执行如下指令，生成字节码
 * javac -g HelloByteCode.java
 * javap -c -verbose HelloByteCode
 */
public class HelloByteCode {

    public static void main(String[] args) {
        int a = 3, b = 2;
        int c = b * (a + 3) - 4;

        String test = "Hello World";
        if (c > 10) {
            test = "Goods";
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(test);
        }
    }
}
