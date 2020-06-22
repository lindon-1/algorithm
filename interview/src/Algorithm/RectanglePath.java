package Algorithm;

/**
 * @Description：矩阵中的路径
 * @Author: ldl
 * @CreateDate: 2020/6/19 11:13
 */
public class RectanglePath {
    /**
     * 矩阵中的路径
     * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
     * 路径可以从矩阵中任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
     * 例如在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用下划线标出）。
     * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
     *
     * 思路
     * 这是一个回溯法解决的典型题
     * 基本思路:
     * 0. 根据给定数组，初始化一个标志位数组，初始化为false，表示未走过，true表示已经走过，不能走第二次
     *
     * 根据行数和列数，遍历数组，先找到一个与str字符串的第一个元素相匹配的矩阵元素，进入hasPathCore
     * 根据col和row先确定一维数组的位置，因为给定的matrix是一个一维数组
     * 确定递归终止条件：越界，当前找到的矩阵值不等于数组对应位置的值，已经走过的，这三类情况，都直接false，说明这条路不通
     * 若pathLength，就是待判定的字符串str的索引已经判断到了最后一位，此时说明是匹配成功的
     * 下面就是本题的精髓，递归不断地寻找周围四个格子是否符合条件，只要有一个格子符合条件，就继续再找这个符合条件的格子的四周是否存在符合条件的格子，直到pathLength到达末尾或者不满足递归条件就停止。
     * 走到这一步，说明本次是不成功的，我们要还原一下标志位数组index处的标志位，进入下一轮的判断。
     */

    private final static int[][] index = new int[][]{{0,1}, {0,-1}, {1, 0}, {-1, 0}};

    public static Boolean findPath(char[] nums, char[] target, int rows, int cols) {
        char[][] rectNums = new char[rows][cols];
        for (int i = 0, dx =0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                rectNums[i][j] = nums[dx++];
            }
        }

        boolean[][] marked = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (backtracking(rectNums, target, marked, 0, rows, cols, i, j)) {
                    return true;
                }
            }
        }

        return false;

    }

    public static boolean backtracking(char[][] rectNums, char[] target, boolean[][] marked, int pathLength, int rows, int cols, int row, int col) {

        if(pathLength == target.length) {
            return true;
        }
        if (row < 0  || row > rows || col < 0 || col > cols || rectNums[row][col] != target[pathLength] || marked[row][col]) {
            return false;
        }
        marked[row][col] = true;
        for (int[] i : index) {
            if(backtracking(rectNums, target, marked, pathLength + 1, rows, cols, row + i[0], col + i[1])) {
                return true;
            }
        }
        marked[row][col] = false;
        return false;
    }

    public static void main(String[] args) {
        char[] rectangle = new char[]{'a', 'b', 't', 'g','c','f','c','s','j','d','e','h'};
        char[] target = new char[]{'b','f','c','a'};
        int rows = 3;
        int cols = 4;
        System.out.println(findPath(rectangle, target, rows, cols));
    }
}
