package Algorithm;

import java.util.Arrays;

/**
 * @Description： 变态跳台阶
 * @Author: ldl
 * @CreateDate: 2020/6/17 15:58
 */
public class JumpFloorTwo {
    /**
     * 题目描述
     * 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级... 它也可以跳上 n 级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
     * 思路1：
     * f(1) =1;
     * f(2) = f(1) + 1 = 2 ;
     * f(3) = f(1) + f(2) + 1 = 4;
     * f(4) = f(1) + f(2) + f(3) = 8;
     * ...
     * f(n-1) = f(1) + f(2) + ...f(n-2) + 1;
     * f(n) = f(1) + f(2) + ...+ f(n-2) + f(n-1) + 1; --> f(n) = f(n -1) +f(n-1) = 2f(n-1)
     * f(n)是等比数列
     */

    public static int JumpFloorII(int target) {
        if (target == 0) {
            return 0;
        }
        return (int)Math.pow(2, target - 1);
    }
    /**
     * 思路2:
     * 利用动态规划
     */
    public static int JumpFloorByDon(int target) {
        if (target == 0) {
            return 0;
        }
        int[] dp = new int[target];
        Arrays.fill(dp, 1);
        for (int i = 1; i < dp.length; i++) {
            for(int j = 0; j < i; j++) {
                dp[i] += dp[j];
            }
        }
        return dp[target -1];
    }
}
