package com.ai;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * 通过反射了解泛型本质
 */
public class ReflectCollection {

    public static void main(String[] args){
        ArrayList list=new ArrayList();

        ArrayList<String> list1=new ArrayList<>();
        list1.add("hello");

        Class c1=list.getClass();
        Class c2=list1.getClass();
        /**
         * c1==c2
         * 返回true
         */
        System.out.println(c1==c2);

        /**
         * 反射的操作都是编译之后的操作，即就是运行时操作
         */
        /**
         * c1==c2返回true说明编译之后集合的泛型是去泛型化的
         * java中集合的泛型，是防止错误输入，只在编译阶段有效
         * 绕过编译就无效了
         *
         *
         * 验证：我们可以通过方法的反射来操作，绕过编译
         */

        try {
            Method m=c2.getMethod("add",Object.class);
            /**
             * 绕过编译去操作，就绕过了泛型
             */
            m.invoke(list1,20);
            System.out.println(list1.size());
            System.out.println(list1);
            /**
             * 现在遍历list1不能用foreach，会报错，因为list1限制为String
             */

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
