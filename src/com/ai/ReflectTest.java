package com.ai;

public class ReflectTest {

    public static void main(String[] args){
        String s="hello";
        ClassUtil.printMethodMessage(s);

        ClassUtil.printFieldMessage(s);

        ClassUtil.printConstructMessage(s);
    }
}
