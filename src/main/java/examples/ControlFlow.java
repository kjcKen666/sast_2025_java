// 这段代码用于演示控制流语句

package examples;

import java.util.Scanner;

public class ControlFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // if-else 条件判断
        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();

        if (number > 0) {
            System.out.println("The number is positive.");
        } else if (number < 0) {
            System.out.println("The number is negative.");
        } else {
            System.out.println("The number is zero.");
        }

        // switch 多分支结构
        System.out.print("Enter a number for day of week (1-7): ");
        int day = scanner.nextInt();

        switch (day) {
            case 1:
                System.out.println("Today is Monday.");
                break;
            case 2:
                System.out.println("Today is Tuesday.");
                break;
            case 3:
                System.out.println("Today is Wednesday.");
                break;
            default:
                System.out.println("Today is another day.");
        }

        // for 循环：输出 1~5
        for (int i = 1; i <= 5; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        // while 循环：输出 5~1
        int count = 5;
        while (count > 0) {
            System.out.print(count + " ");
            count--;
        }
        System.out.println();

        // break 和 continue
        for (int i = 0; i < 10; i++) {
            if (i == 3) {
                continue;
            }
            if (i == 7) {
                break;
            }
            System.out.print(i + " ");
        }

        scanner.close();
    }
}
