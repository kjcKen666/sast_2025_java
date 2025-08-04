// 这段代码用于演示HashMap的用法

package examples;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) {
        // 创建 HashMap，键为 String（学生姓名），值为 Integer（成绩）
        HashMap<String, Integer> scores = new HashMap<>();

        // 添加键值对
        scores.put("Alice", 90);
        scores.put("Bob", 85);
        scores.put("Charlie", 95);

        // 覆盖已有键的值（Bob 原来的值会被替换）
        scores.put("Bob", 88);

        // 允许值重复（两个键映射到同一个值）
        scores.put("David", 95);

        // 获取某个键对应的值
        System.out.println("Charlie's score: " + scores.get("Charlie"));

        // 判断是否包含某个键或值
        System.out.println("Contains key 'Alice'? " + scores.containsKey("Alice"));
        System.out.println("Contains value 100? " + scores.containsValue(100));

        // 删除一个键值对
        scores.remove("Alice");

        // 使用 keySet 遍历键
        System.out.println("\n遍历 keySet:");
        for (String name : scores.keySet()) {
            System.out.println(name + " => " + scores.get(name));
        }

        // 获取大小
        System.out.println("\nTotal entries: " + scores.size());

        // 清空映射
        scores.clear();
        System.out.println("Is map empty? " + scores.isEmpty());
    }
}
