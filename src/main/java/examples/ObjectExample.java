// 这段代码用于演示Object类的用法

package examples;

import java.util.HashSet;
import java.util.Objects;

public class ObjectExample {
    public static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        // 重写 toString()
        @Override
        public String toString() {
            return "Person[name=" + name + ", age=" + age + "]";
        }

        // 重写 equals()
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Person other = (Person) obj;
            return age == other.age && Objects.equals(name, other.name);
        }

        // 重写 hashCode()
        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }
    }

    public static void main(String[] args) {
        Person p1 = new Person("Alice", 25);
        Person p2 = new Person("Alice", 25);
        Person p3 = new Person("Bob", 30);

        // 打印对象，调用toString()
        System.out.println(p1);  // Person[name=Alice, age=25]

        // 比较对象，调用equals()
        System.out.println(p1.equals(p2));  // true
        System.out.println(p1.equals(p3));  // false

        // 比较 hashCode
        System.out.println(p1.hashCode() == p2.hashCode());  // true

        // 在 HashSet 中的效果
        HashSet<Person> set = new HashSet<>();
        set.add(p1);
        System.out.println(set.contains(p2));  // true
        System.out.println(set.contains(p3));  // false
    }
}
