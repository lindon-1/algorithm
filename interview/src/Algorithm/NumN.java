package Algorithm;

/**
 * @Description：数值的整数次方
 * @Author: ldl
 * @CreateDate: 2020/6/28 9:47
 */
public class NumN {
    /**
     * 题目描述
     * 给定一个 double 类型的浮点数 base 和 int 类型的整数 exponent，求 base 的 exponent 次方。
     *
     * 解题思路
     * 下面的讨论中 x 代表 base，n 代表 exponent。
     *
     *     x^n =   (x * x) ^(n/2)   当n% = 0
     *             x*(x*x) ^(n/2)    当n%2 = 1
     *
     * 因为 (x*x)n/2 可以通过递归求解，并且每次递归 n 都减小一半，因此整个算法的时间复杂度为 O(logN)。
     */

    public static double power(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        boolean isNati = false;
        if (exponent < 0) {
            isNati = true;
            exponent = -exponent;
        }
        double power;
        if (exponent % 2 == 0) {
            power = power(base * base, exponent/2);
        } else {
            power = base * power(base * base, exponent/2);
        }
        return isNati ? 1/power : power;

    }


    public static void main(String[] args) {
        System.out.println(power(4, -5));
    }

}
