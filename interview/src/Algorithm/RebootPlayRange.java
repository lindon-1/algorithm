package Algorithm;

/**
 * @Description：机器人的运动范围
 * @Author: ldl
 * @CreateDate: 2020/6/22 10:05
 */
public class RebootPlayRange {
    public static final int[][] index = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static int  count  = 0;

    /**
     * 题目描述
     * 地上有一个 m 行和 n 列的方格。一个机器人从坐标 (0, 0) 的格子开始移动，每一次只能向左右上下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于 k 的格子。
     *
     * 例如，当 k 为 18 时，机器人能够进入方格 (35,37)，因为 3+5+3+7=18。但是，它不能进入方格 (35,38)，因为 3+5+3+8=19。请问该机器人能够达到多少个格子？
     *
     * 解题思路
     * 使用深度优先搜索（Depth First Search，DFS）方法进行求解。回溯是深度优先搜索的一种特例，它在一次搜索过程中需要设置一些本次搜索过程的局部状态，
     * 并在本次搜索结束之后清除状态。而普通的深度优先搜索并不需要使用这些局部状态，虽然还是有可能设置一些全局状态。
     */

    public static int movingCount(int num, int row, int col) {
        boolean[][] marked = new boolean[row][col];
        int[][] digethSum = new int[row][col];
        initDigthSum(digethSum);
        dfs(digethSum, marked, 0, 0, num);


        return count;
    }

    private static void dfs(int[][] digethSum, boolean[][] marked, int row, int col, int num) {

        if (row < 0 || row >= digethSum.length || col < 0 || col >= digethSum[0].length || marked[row][col]) {
            return;
        }
        marked[row][col] = true;
        if (digethSum[row][col] > num) {
            return;
        }
        count++;
        for (int[] ints : index) {
            dfs(digethSum, marked, row + ints[0], col + ints[1], num);
        }

    }

    private static void initDigthSum(int[][] digethSum) {
        int row = digethSum.length;
        int col = digethSum[0].length;
        int[] digethOne = new int[Math.max(row, col)];
        for (int i = 0; i < digethOne.length; i++) {
            int n = i;
            while (n > 0) {
                digethOne[i] += n % 10;
                n /= 10;
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                digethSum[i][j] = digethOne[i] + digethOne[j];
            }

        }
    }

    public static void main(String[] args) {
        System.out.println(movingCount(3, 4, 2));
    }
}
