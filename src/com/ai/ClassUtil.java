package com.ai;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 反射工具类，封装方法
 */
public class ClassUtil {

    /**
     * 打印类的成员函数信息
     * @param object
     */
    public static void printMethodMessage(Object object){
        //1、获取类的类类型
        //传递的是哪个子类的对象，c就是该子类的类类型
        Class c=object.getClass();
        //获取类的名称
        String name=c.getName();
        System.out.println("类的名称为"+name);
        /**
         * Method类，所有方法都是Method类的对象
         * 一个成员方法就是一个Method对象
         * getMethod方法获取的是所有public的函数，包括父类继承而来的
         * getDeclaredMethods()获取的是所有自己声明的方法，不问访问权限，包括private。父类继承而来的就没有了
         */
        Method[] methods=c.getMethods();
        Method[] methods1=c.getDeclaredMethods();
        for (int i = 0; i <methods.length ; i++) {

            //得到方法的返回值类型的类类型===》int.class,String.class.......
            Class returnType=methods[i].getReturnType();

            //得到方法的返回值类型的名字
            System.out.println(returnType.getName());

            //得到方法的名字
            System.out.print(methods[i].getName()+"(");

            //获取方法的参数类型->得到的是方法的各个参数的类型的类类型===》int.class,String.class.......
            Class[] paramTypes=methods[i].getParameterTypes();

            for (Class c1:paramTypes) {
                System.out.print(c1.getName()+",");
            }
            System.out.println(")");


        }

    }

    /**
     * 打印类的成员变量的信息
     * @param object
     */
    public static void printFieldMessage(Object object) {
        /**
         * 成员变量也是对象
         * java.lang.reflect.Field
         * Field类封装了关于成员变量的操作
         * getFields()方法获取的是所有的public的成员变量的信息
         * getDeclaredFields()获得的是该类自己声明的所有成员变量的信息，包括private
         */
        Class c=object.getClass();
        Field[] fs=c.getFields();
        Field[] fields=c.getDeclaredFields();
        for (Field field:fields) {
            //得到成员变量的类型的类类型
            Class fieldType=field.getType();
            String typeName=fieldType.getName();
            //得到成变量的名称
            String fieldName=field.getName();
            System.out.println(typeName+" "+fieldName);

        }
    }

    /**
     * 打印类的构造函数的信息
     * @param object
     */
    public static void printConstructMessage(Object object){

        Class c=object.getClass();
        /**
         * 构造函数也是对象
         * java.lang.Constructor中封装了构造函数的信息
         * getConstructors()获得所有的public构造方法
         * getDeclaredConstructors()获取到所有自己声明的构造方法，包括private
         */
        Constructor[] con=c.getConstructors();
        Constructor[] constructors=c.getDeclaredConstructors();
        for (Constructor constructor:constructors) {
            System.out.print(constructor.getName()+"(");
            /**
             * 获取构造函数的各个参数的类型的类类型
             */
            Class[] paramsType=constructor.getParameterTypes();
            for (Class class1:paramsType) {
                System.out.print(class1.getName());
            }
            System.out.println(")");
        }
    }




}
