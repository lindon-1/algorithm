package Algorithm;

import java.util.Scanner;

/**
 * @Description：剪绳子
 * @Author: ldl
 * @CreateDate: 2020/6/23 10:08
 */
public class CutTheRope {
    /**
     * 题目描述
     * 题目描述
     * 　　给你一根长度为n的绳子，请把绳子剪成m段（m、n都是整数，n>1并且m>1），每段绳子的长度记为k[0],k[1],...,k[m]。
     * 请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
     * 输入描述:
     * 　　输入一个数n，意义见题面。（2 <= n <= 60）
     *
     * 示例1
     * 输入　　8
     * 输出　　18
     */

    /**
     * 解法1：贪心算法
     * 题目分析：
     *  * 先举几个例子，可以看出规律来。
     *  * 4 ： 2*2
     *  * 5 ： 2*3
     *  * 6 ： 3*3
     *  * 7 ： 2*2*3 或者4*3
     *  * 8 ： 2*3*3
     *  * 9 ： 3*3*3
     *  * 10：2*2*3*3 或者4*3*3
     *  * 11：2*3*3*3
     *  * 12：3*3*3*3
     *  * 13：2*2*3*3*3 或者4*3*3*3
     *  *
     *  * 下面是分析：
     *  * 首先判断k[0]到k[m]可能有哪些数字，实际上只可能是2或者3。
     *  * 当然也可能有4，但是4=2*2，我们就简单些不考虑了。
     *  * 5<2*3,6<3*3,比6更大的数字我们就更不用考虑了，肯定要继续分。
     *  * 其次看2和3的数量，2的数量肯定小于3个，为什么呢？因为2*2*2<3*3，那么题目就简单了。
     *  * 直接用n除以3，根据得到的余数判断是1就减少一个3，变成两个2
     *  * 由于题目规定m>1，所以2只能是1*1，3只能是2*1，这两个特殊情况直接返回就行了。
     *  *
     *  * 乘方运算的复杂度为：O(log n)，用动态规划来做会耗时比较多。
     */

    public static int maxLengthByGreedy(int n) {
        if (n < 2) {
            return 0;
        }
        if (n == 2) {
            return  1;
        }
        if (n == 3) {
            return 2;
        }

        int resBy3 = n / 3;
        if (n - 3*resBy3 == 1) {
            resBy3--;
        }
        int resBy2 = (n - resBy3 * 3) / 2;

        return (int)Math.pow(3, resBy3) * (int
                )Math.pow(2, resBy2);
    }

    /**
     * 动态规划特征
     * 从上往下分析问题，从下往上求解问题;
     *
     * 求一个问题的最优解;(最大值或者最小值)
     * 问题能够分解成若干个子问题,并且子问题之间还有重叠的更小的子问题
     * 分解后的小问题也存在最优解,如果把小问题的最优解组合起来能够得到整个问题的最优解,就可以使用动态规划
     *
     */

    public static int maxLengthByDp(int n) {
        if (n < 2) {
            return 0;
        }
        if (n == 2) {
            return  1;
        }
        if (n == 3) {
            return 2;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= n; i++) {
            for (int j = 1; j <= i /2; j++) {
                dp[i] = Math.max(dp[i], dp[j] * dp[i - j]);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(maxLengthByDp(n));
        System.out.println(maxLengthByGreedy(n));
    }
}
