// 这段代码用来演示基本的包和导入，main方法程序的入口，输入输出等知识点

package examples;  // 包声明，必须在第一行

import java.util.Scanner;  // 导入标准库中的 Scanner 类
import java.util.Date;     // 再引入一个用于演示的类

/**
 * HelloWorld 是演示 Java 基础语法的示例类
 * @author Alice
 * @version 1.0
 * 这是文档注释
 */
public class HelloWorld {
    // main 方法是程序的入口
    public static void main(String[] args) {
        // 输出一行文本
        System.out.println("Welcome to Java!");

        // 创建 Scanner 对象读取用户输入
        Scanner sc = new Scanner(System.in);
        System.out.print("Please Enter your name:");
        String name = sc.nextLine();

        // 输出带用户输入的字符串
        System.out.println("Hello," + name + "!");

        // 显示当前时间
        Date now = new Date();
        System.out.println("It is: " + now);

        // 关闭 Scanner，避免资源泄露
        sc.close();
    }
}
