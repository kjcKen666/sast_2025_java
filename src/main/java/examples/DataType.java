// 这段代码主要演示不同数据类型的使用

package examples;

public class DataType {
    public static void main(String[] args) {
        // 基本数据类型
        byte b = 127;
        short s = 32000;
        int i = 100000;
        long l = 9999999999L;
        float f = 3.14f;
        double d = 3.14159;
        boolean isJavaFun = true;
        char letter = 'A';

        System.out.println("Byte value: " + b);
        System.out.println("Short value: " + s);
        System.out.println("Int value: " + i);
        System.out.println("Long value: " + l);
        System.out.printf("Float value: %.2f\n", f);
        System.out.println("Double value: " + d);
        System.out.println("Boolean value: " + isJavaFun);
        System.out.println("Char value: " + letter);

        // 引用类型：数组
        int[] scores = {85, 90, 95};
        System.out.println("First score: " + scores[0]);

        char[] letters = {'a', 'b', 'c'};
        System.out.println("Last letter: " + letters[2]);

        // 引用类型：字符串
        String greeting = "Hello";
        greeting += " Java!";
        System.out.println("Greeting: " + greeting);

        // 使用 StringBuilder 进行拼接
        StringBuilder builder = new StringBuilder();
        builder.append("Java");
        builder.append(" is awesome!");
        System.out.println("StringBuilder: " + builder.toString());

    }
}
