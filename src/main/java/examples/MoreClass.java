// 这段代码用于演示类的组合，继承，抽象类和接口的知识

package examples;

// 接口定义：Flyable 表示能飞的能力
interface Flyable {
    void fly();
}

// 抽象类定义：Animal 是一个抽象类，定义通用属性和行为
abstract class Animal {
    int age;
    int weight;

    public Animal(int age, int weight) {
        this.age = age;
        this.weight = weight;
    }

    // 抽象方法：要求子类必须实现
    public abstract void makeSound();

    // 普通方法：可以被子类继承或使用 super 调用
    public void sleep() {
        System.out.println("Sleeping zzz...");
    }
}

// 组合类：
class Engine {
    void start() {
        System.out.println("Engine starts...");
    }
}

// 使用组合的类：Car 拥有一个Engine
class Car {
    private Engine engine = new Engine(); // 组合

    public void drive() {
        engine.start();
        System.out.println("Car is driving...");
    }
}

// Dog 类继承自 Animal，并实现接口 Flyable
class Dog extends Animal implements Flyable {
    String color;

    public Dog(int age, int weight, String color) {
        super(age, weight);
        this.color = color;
    }

    @Override
    public void makeSound() {
        System.out.println("Bark.");
    }

    @Override
    public void fly() {
        System.out.println("SuperDog is flying!");
    }
}

// Cat 类继承自 Animal，没有实现 Flyable 接口
class Cat extends Animal {
    String name;

    public Cat(int age, int weight, String name) {
        super(age, weight);
        this.name = name;
    }

    @Override
    public void makeSound() {
        System.out.println("Meow.");
    }
}

public class MoreClass {
    public static void main(String[] args) {
        // 测试继承与接口
        Animal dog = new Dog(3, 15, "White");
        Animal cat = new Cat(2, 5, "Kitty");

        dog.makeSound(); // Bark.
        cat.makeSound(); // Meow.

        dog.sleep(); // 来自抽象类的普通方法
        cat.sleep();

        ((Flyable) dog).fly(); // 向下转型并调用fly

        Car car = new Car();
        car.drive(); // Engine starts... + Car is driving...
    }
}
