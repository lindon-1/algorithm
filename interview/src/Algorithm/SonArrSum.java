package Algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description： 连续的子数组和
 * @Author: ldl
 * @CreateDate: 2020/7/14 10:53
 */
public class SonArrSum {
    /**
     * 给定一个包含 非负数 的数组和一个目标 整数 k，编写一个函数来判断该数组是否含有连续的子数组，其大小至少为 2，且总和为 k 的倍数，即总和为 n*k，其中 n 也是一个整数。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：[23,2,4,6,7], k = 6
     * 输出：True
     * 解释：[2,4] 是一个大小为 2 的子数组，并且和为 6。
     * 示例 2：
     * <p>
     * 输入：[23,2,6,4,7], k = 6
     * 输出：True
     * 解释：[23,2,6,4,7]是大小为 5 的子数组，并且和为 42。
     *  
     * <p>
     * 说明：
     * <p>
     * 数组的长度不会超过 10,000 。
     * 你可以认为所有数字总和在 32 位有符号整数范围内。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/continuous-subarray-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static boolean checkSubarraySum(int[] num, int k) {
        if (num.length < 1) {
            return false;
        }
        int sum = 0;
        int count = 0;
        k = Math.abs(k);
        for (int i = 0; i < num.length; i++) {
            for (int j = i; j >=0; j--) {
                sum += num[j];
                count++;
                if (k != 0 &&sum != 0 && sum % k == 0 && count > 1) {
                    return true;
                }
                if (sum == 0 && count > 1) {
                    return true;
                }
            }
            sum = 0;
            count = 0;
        }
        return false;
    }

    public static boolean checkSubarraySum2(int[] nums, int k) {
        if (nums.length < 1) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0) {
                sum = sum % k;
            }
            if (map.containsKey(sum)) {
                if (i - map.get(sum) > 1) {
                    return true;
                }
            } else {
                map.put(sum, i);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkSubarraySum(new int[]{0,0}, 6));
        System.out.println(checkSubarraySum2(new int[]{0,0}, 6));
    }
}
