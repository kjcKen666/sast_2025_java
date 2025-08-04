// 这段代码用于演示Array和Arraylist的用法

package examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArrayExample {
    public static void main(String[] args) {
        int[] scores = {88, 92, 75, 90, 100};

        // 遍历数组
        System.out.println("Original Array:");
        for (int i = 0; i < scores.length; i++) {
            System.out.println("scores[" + i + "] = " + scores[i]);
        }

        // 排序数组
        Arrays.sort(scores);
        System.out.println("Sorted Array: " + Arrays.toString(scores));

        // 使用 ArrayList（动态扩容）
        ArrayList<String> students = new ArrayList<>();
        students.add("Alice");
        students.add("Bob");
        students.add("Charlie");

        // 插入与删除
        students.add(1, "David");
        students.remove("Charlie");

        // 遍历 ArrayList
        System.out.println("\nStudent List:");
        for (String name : students) {
            System.out.println(name);
        }

        // 排序 ArrayList
        Collections.sort(students);
        System.out.println("Sorted Student List: " + students);

        // 数组与 ArrayList 相互转换
        String[] langArray = {"Java", "Python", "C++"};
        ArrayList<String> langList = new ArrayList<>(Arrays.asList(langArray));

        langList.add("Go");  // 添加元素

        System.out.println("\nLanguages: " + langList);

        // ArrayList 转换为数组
        String[] newArray = langList.toArray(new String[0]);
        System.out.println("Converted Back to Array: " + Arrays.toString(newArray));
    }
}
