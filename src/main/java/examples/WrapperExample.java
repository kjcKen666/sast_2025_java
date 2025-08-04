// 这段代码用于演示包装类的用法

package examples;

import java.util.ArrayList;

public class WrapperExample {
    public static void main(String[] args) {
        // 创建包装类对象：valueOf()
        Integer intObj = Integer.valueOf("123");
        Double doubleObj = Double.valueOf("3.14");

        // 字符串解析为基本类型：parseXxx()
        int parsedInt = Integer.parseInt("456");
        double parsedDouble = Double.parseDouble("6.28");

        // 包装类对象转换为字符串：toString()
        String str = Integer.valueOf("789").toString();

        System.out.println("intObj = " + intObj);
        System.out.println("doubleObj = " + doubleObj);
        System.out.println("parsedInt = " + parsedInt);
        System.out.println("parsedDouble = " + parsedDouble);
        System.out.println("str = " + str);

        // 比较包装类对象
        Integer a = 127;
        Integer b = 127;
        Integer c = 128;
        Integer d = 128;

        System.out.println("a == b: " + (a == b)); // true，缓存范围内
        System.out.println("c == d: " + (c == d)); // false，超出缓存范围
        System.out.println("c.equals(d): " + c.equals(d)); // true

        // 自动装箱与拆箱
        int x = 10;
        Integer obj = x;  // 自动装箱：int → Integer
        int y = obj;      // 自动拆箱：Integer → int

        System.out.println("x = " + x);
        System.out.println("obj = " + obj);
        System.out.println("y = " + y);

        // 泛型集合中使用包装类
        ArrayList<Integer> list = new ArrayList<>();
        list.add(100); // 自动装箱
        int value = list.get(0); // 自动拆箱
        System.out.println("From list: " + value);
    }
}
