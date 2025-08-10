package homework;

import java.util.Arrays;
import java.util.Scanner;

public class TwoNumbersClosestDifference {
    public static int[] findClosestPair(int[] nums, int target) {
        // TODO begin

        // TODO end
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array length: ");
        int n = sc.nextInt();
        int[] nums = new int[n];

        System.out.println("Enter array elements (space-separated):");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter target difference: ");
        int target = sc.nextInt();

        int[] ans = findClosestPair(nums, target);

        System.out.println(ans[0] + " " + ans[1]);

        sc.close();
    }
}
