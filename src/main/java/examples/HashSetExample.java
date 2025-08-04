// 这段代码用于演示HashSet的用法

package examples;

import java.util.HashSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

public class HashSetExample {
    public static void main(String[] args) {
        // 创建 HashSet，存储姓名
        HashSet<String> names = new HashSet<>();

        // 添加元素
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");

        // 尝试添加重复元素
        boolean added = names.add("Alice");  // 不会添加
        System.out.println("Was 'Alice' added again? " + added);  // false

        // 判断元素是否存在
        System.out.println("Contains Bob? " + names.contains("Bob"));

        // 删除元素
        names.remove("Charlie");

        // 遍历集合（顺序不保证）
        System.out.println("\nCurrent elements in HashSet:");
        for (String name : names) {
            System.out.println("Name: " + name);
        }

        System.out.println("Total size: " + names.size());

        // 与 List 相互转换：ArrayList 去重
        ArrayList<String> list = new ArrayList<>(Arrays.asList("Tom", "Jerry", "Tom", "Anna", "Jerry"));
        System.out.println("\nOriginal list with duplicates: " + list);

        HashSet<String> uniqueSet = new HashSet<>(list);  // 自动去重
        System.out.println("Set after removing duplicates: " + uniqueSet);

    }
}
