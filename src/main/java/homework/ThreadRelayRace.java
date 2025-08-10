package homework;

import java.util.Random;
import java.util.Scanner;

class Runner extends Thread {
    private final String name;
    private final Runner nextRunner; // 下一位选手
    private final Random random = new Random();

    public Runner(String name, Runner nextRunner) {
        this.name = name;
        this.nextRunner = nextRunner;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " started running...");
            // TODO: 随机生成 500~1500 毫秒的跑步时间

            // TODO: 使用 Thread.sleep() 模拟跑步过程

            System.out.println(name + " finished! Time: " + time + " ms");

            if (nextRunner != null) {
                System.out.println(name + " passing baton to " + nextRunner);
                // TODO: 如果有下一位选手，则启动并等待其完成

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ThreadRelayRace {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of runners: ");
        int numRunners = scanner.nextInt();

        if (numRunners <= 0) {
            System.out.println("Number of runners must be greater than 0.");
            return;
        }
        // TODO: 创建 Runner 数组，并按顺序链接（最后一位选手的 nextRunner 为 null）

        // TODO: 启动第一位 Runner，并等待比赛结束

        System.out.println("Race finished!");
    }
}
