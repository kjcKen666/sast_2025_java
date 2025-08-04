// 这段代码用于演示BigInteger和BigDecimal的用法

package examples;

import java.math.BigInteger;
import java.math.BigDecimal;

public class BigNumber {
    public static void main(String[] args) {
        // 创建两个大整数
        BigInteger big1 = new BigInteger("12345678901234567890");
        BigInteger big2 = new BigInteger("98765432109876543210");

        // 执行加法运算
        BigInteger sum = big1.add(big2);
        System.out.println("BigInteger Sum: " + sum);

        // 执行加法运算
        BigInteger product = big1.add(big2);
        System.out.println("BigInteger Product: " + product);

        // 创建两个高精度小数
        BigDecimal d1 = new BigDecimal("3.1415926535");
        BigDecimal d2 = new BigDecimal("2.7182818284");

        // 执行乘法运算
        BigDecimal result = d1.multiply(d2);
        System.out.println("BigDecimal Result: " + result);

    }
}
