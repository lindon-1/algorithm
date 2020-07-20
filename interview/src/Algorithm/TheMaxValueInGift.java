package Algorithm;

/**
 * @Description： 礼物的最大价值
 * @Author: ldl
 * @CreateDate: 2020/7/20 15:20
 */
public class TheMaxValueInGift {

    /**
     * 题目描述
     * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
     *
     * 示例 1:
     *
     * 输入:
     * [
     *   [1,3,1],
     *   [1,5,1],
     *   [4,2,1]
     * ]
     * 输出: 12
     * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
     * 提示：
     *
     * 0 < grid.length <= 200
     * 0 < grid[0].length <= 200
     *
     * 动态规划解法
     */

    public static int maxValue(int[][] gift) {
        if (gift == null || gift.length == 0) {
            return -1;
        }
        int[][] dp = new int[gift.length][gift[0].length];
        dp[0][0] = gift[0][0];
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = dp[i - 1][0] + gift[i][0];
        }
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = dp[0][i - 1] + gift[0][i];
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = gift[i][j] + Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[gift.length - 1][gift[0].length - 1];
    }

    public static void main(String[] args) {
        System.out.println(maxValue(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
    }
}
