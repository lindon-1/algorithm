package Algorithm;

/**
 * @Description：剑指 Offer 42. 连续子数组的最大和
 * @Author: ldl
 * @CreateDate: 2020/7/13 10:45
 */
public class NumsMostNumAdd {
    /**
     * 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
     *
     * 要求时间复杂度为O(n)。
     *
     *  
     *
     * 示例1:
     *
     * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出: 6
     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof
     */

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(maxSubArray2(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
    }

    /**
     * 题解一：
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int sum =0;
        int max =nums[0];
        for(int i =0; i< nums.length;i++) {
            sum +=nums[i];
            sum = Math.max(sum, nums[i]);
            max = Math.max(max, sum);
        }

        return max;
    }

    /**
     * 题解二
     * 解题思路
     * 使用动态规划的思路解决
     *
     * 创建dp数组
     * 初始化值: dp[0] = nums[0]
     * 每次遍历判断dp[i-1]是否大于0
     * 如果大于0, 则用dp[i-1] + nums[i]
     * 如果小于0,则直接使用nums[i]
     * 每次都记录max值
     * 最后返回max
     *
     * 作者：liu-shi-2
     * 链接：https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/solution/javaban-ben-de-dong-tai-gui-hua-by-liu-shi-2/
     */

    public static int maxSubArray2(int[] nums) {
        if (nums.length <= 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] < 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = dp[i - 1] + nums[i];
            }
            max = Math.max(max, dp[i]);
        }


        return max;
    }
}
