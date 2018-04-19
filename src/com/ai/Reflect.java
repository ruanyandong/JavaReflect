package com.ai;

public class Reflect {

    public static void main(String[] args){

        Class in=int.class;//int型的类类型

        Class In=Integer.class;//Integer类的类类型

        Class vo=void.class;//void型的类类型

        Class str=String.class;//String型的类类型

        System.out.println(in.getName());//输出int
        System.out.println(in.getSimpleName());//不包含包名的名称 int

        System.out.println(In.getName());//java.lang.Integer
        System.out.println(In.getSimpleName());//不包含包名的名称Integer

        System.out.println(vo.getName());//void
        System.out.println(vo.getSimpleName());//void

        System.out.println(str.getName());//java.lang.String
        System.out.println(str.getSimpleName());//String



        Foo foo1=new Foo();
        /**
         * 任何一个类都是Class的实例对象，这个实例对象有三种表示方式
         */
        //方式一=====>说明任何一个类都有一个静态成员变量class
        Class<?> c1=Foo.class;

        //方式二====>已知该类对象通过getClass方法
        Class c2=foo1.getClass();

        /**
         * c1、c2表示了Foo类的类类型(class type)
         * 类也是对象，是Class类的实例对象
         * 这个对象我们称为该类的类类型(Class的对象 c1、c2)
         */

        /**
         * 不管c1或c2都代表了Foo类的类类型，一个类只可能是Class类的一个实例对象
         */
        System.out.println(c1==c2);//true

        //第三种表达方式
        Class c3=null;
        try {
            c3=Class.forName("com.ai.Foo");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(c2==c3);//true

        //我们完全可以通过类的类类型创建该类的对象实例
        //即就是通过c1或c2或c3创建Foo的实例
        try {
            Foo foo=(Foo)c1.newInstance();
            foo.print();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }


}
class Foo{

    void print(){
        System.out.print("Foo方法");
    }
}
