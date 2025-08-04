// 这段代码用于演示LinkedList的用法

package examples;

import java.util.LinkedList;

public class LinkedListExample {
    public static void main(String[] args) {
        // 创建 LinkedList，存储字符串
        LinkedList<String> fruits = new LinkedList<>();

        // 添加元素
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");

        // 在头部和尾部添加
        fruits.addFirst("Mango");
        fruits.addLast("Orange");

        // 获取元素
        System.out.println("First: " + fruits.getFirst());
        System.out.println("Last: " + fruits.getLast());

        // 遍历链表
        for (String fruit : fruits) {
            System.out.println("Fruit: " + fruit);
        }

        // 删除元素
        fruits.removeFirst();   // 删除头部
        fruits.removeLast();    // 删除尾部
        fruits.remove("Banana");

        System.out.println("After deletion: " + fruits);
    }
}