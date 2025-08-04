// 这段代码用于演示异常处理，同学们可以从上到下依次注释掉异常语句，观察捕获的情况

package examples;

import java.io.FileReader;
import java.io.IOException;

// 自定义异常类
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class ExceptionExample {
    public static void main(String[] args) {
        try {
            // 运行时异常示例（Unchecked）
            int result = 10 / 0;

            // Checked 异常示例
            readFile("nonexistent.txt");

            // 自定义异常示例
            registerUser("Alice", 16);

        } catch (ArithmeticException e) {
            System.out.println("Runtime Exception: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Checked Exception: " + e.getMessage());
        } catch (InvalidAgeException e) {
            System.out.println("Custom Checked Exception: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Other Exception: " + e.getMessage());
        } finally {
            System.out.println("Finished exception handling.");
        }
    }

    // 方法声明抛出 Checked 异常
    public static void readFile(String fileName) throws IOException {
        FileReader reader = new FileReader(fileName);  // 若文件不存在会抛出 IOException
        reader.close();
    }

    // 方法声明抛出自定义异常
    public static void registerUser(String name, int age) throws InvalidAgeException {
        if (age < 18) {
            // throw：手动抛出异常
            throw new InvalidAgeException("User " + name + " is underaged.");
        }
        System.out.println("User " + name + " registered successfully.");
    }
}
