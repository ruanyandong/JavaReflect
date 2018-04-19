package com.ai;

import java.lang.reflect.Method;

/**
 * 反射操作方法
 */
public class ReflectMethod {

    public static void main(String[] args){
        //获取print(int a,int b)方法
        /**
         * 1、要获取一个方法就是获取类的信息，获取类的信息首先要获取类的类类型
         */
        A a=new A();
        Class c=a.getClass();
        /**
         * 2、获取方法  名称和参数列表来决定
         * getMethod获取的是public的方法
         * getDeclaredMethod获取的是所有方法，包括private
         */
        try {
            //c.getDeclaredMethod("print",new Class[]{int.class,int.class});
            /**
             * 两种写法都对
             * 获取方法对象
             */
            Method method=c.getMethod("print",new Class[]{int.class,int.class});
            Method method1=c.getMethod("print",int.class,int.class);


            /**
             * 方法的反射操作
             * 用Method对象进行方法调用，和new A().print(a,b)效果一样
             */
            /**
             * 两种写法都对
             * 方法如果没有返回值返回null，有返回值返回具体返回值
             */
            Object o=method.invoke(a,new Object[]{10,20});
            Object o1=method.invoke(a,10,20);

            System.out.println("========================");

            Method method2=c.getMethod("print",new Class[]{String.class,String.class});
            Object o2=method2.invoke(a,new Object[]{"Hello","World"});

            System.out.println("=========================");
            //两种写法都对，获取无参方法
            Method method3=c.getMethod("print",new Class[]{});
            Method method4=c.getMethod("print");
            //两种写法都对
            Object o3=method3.invoke(a,new Object[]{});
            method3.invoke(a);

        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}

class A{

    public void print(int a,int b){
        System.out.println(a+b);
    }

    public void print(){
        System.out.println("============");
    }

    public void print(String a,String b){
        System.out.println(a.toUpperCase()+","+b.toUpperCase());
    }

}

