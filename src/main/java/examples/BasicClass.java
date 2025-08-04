// 这段代码用来演示java类的基本语法

package examples;

class Book {
    // static final 变量，全局常量
    public static final String DEFAULT_AUTHOR = "Musk";

    // private 实例变量，只能通过方法访问
    private String title;
    private String author;

    // static 变量：所有 Book 实例共享
    private static int totalBooks = 0;

    // 实例初始化块：每次创建对象都会执行
    {
        System.out.println("A new Book object is being initialized.");
    }

    // 构造函数（构造方法）
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        totalBooks++;
    }

    // 重载构造函数：只有书名
    public Book(String title) {
        this(title, DEFAULT_AUTHOR); // 调用另一个构造函数
    }

    // public 方法：获取书名
    public String getTitle() {
        return title;
    }

    // protected 方法：获取作者
    protected String getAuthor() {
        return author;
    }

    // static 方法：打印当前图书总数
    public static void printTotalBooks() {
        System.out.println("Total books created: " + totalBooks);
    }

    // final 方法：不能被子类重写
    public final void printInfo() {
        System.out.println("Book: " + title + " by " + author);
    }
}

public class BasicClass {
    public static void main(String[] args) {
        Book b1 = new Book("Effective Java", "Joshua Bloch");
        Book b2 = new Book("Clean Code");
        b1.printInfo();
        b2.printInfo();
        Book.printTotalBooks(); // 通过类名调用静态方法
    }
}