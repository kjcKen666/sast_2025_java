// 这段代码用于演示Array和Arraylist的用法

package examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArrayExample {
    public static void main(String[] args) {
        int[] scores = {88, 92, 75, 90, 100};

        // 遍历
        System.out.println("Original Array:");
        for (int i = 0; i < scores.length; i++) {
            System.out.println("scores[" + i + "] = " + scores[i]);
        }

        // 排序
        Arrays.sort(scores);
        System.out.println("Sorted Array: " + Arrays.toString(scores));

        // 比较数组值是否相同
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 2, 3};
        System.out.println("Arrays equal? " + Arrays.equals(arr1, arr2));

        // 二分查找（必须先排序）
        int[] sortedNums = {1, 3, 5, 7, 9};
        int index = Arrays.binarySearch(sortedNums, 5);
        System.out.println("Index of 5: " + index);

        ArrayList<String> students = new ArrayList<>();
        students.add("Alice");
        students.add("Bob");
        students.add("Charlie");

        // 插入与删除
        students.add(1, "David");
        students.remove("Charlie");

        // 遍历
        System.out.println("\nStudent List:");
        for (String name : students) {
            System.out.println(name);
        }

        Collections.sort(students);
        System.out.println("Sorted Student List: " + students);

        // 判断是否包含某元素
        boolean hasBob = students.contains("Bob");
        System.out.println("Contains Bob? " + hasBob);

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
