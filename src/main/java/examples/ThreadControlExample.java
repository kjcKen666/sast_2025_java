// 这段代码用于演示进程的基础知识

package examples;

public class ThreadControlExample {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyTask(), "Worker1");
        Thread t2 = new Thread(new MyTask(), "Worker2");

        // 启动线程，进入就绪状态
        t1.start();
        t2.start();

        // 主线程监控子线程状态
        while (t1.isAlive() || t2.isAlive()) {
            System.out.println("Main thread: Waiting for workers to finish...");
            try {
                Thread.sleep(500);  // 主线程睡眠一段时间，避免 CPU 忙等
            } catch (InterruptedException e) {
                System.out.println("Main thread interrupted.");
            }
        }

        System.out.println("Main thread: All workers finished.");
    }

    // Runnable 实现方式创建线程任务类
    static class MyTask implements Runnable {
        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            for (int i = 1; i <= 5; i++) {
                System.out.println(threadName + " - Step " + i);

                if (i == 3) {
                    // 第 3 步主动让出 CPU，模拟线程调度
                    System.out.println(threadName + " yields the CPU.");
                    Thread.yield();
                }

                try {
                    Thread.sleep(300);  // 线程休眠，释放 CPU
                } catch (InterruptedException e) {
                    System.out.println(threadName + " was interrupted.");
                }
            }
        }
    }
}
