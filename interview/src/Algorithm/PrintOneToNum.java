package Algorithm;

/**
 * @Description： 打印从 1 到最大的 n 位数
 * @Author: ldl
 * @CreateDate: 2020/6/28 10:26
 */
public class PrintOneToNum {
    /**
     * 题目描述
     * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数即 999。
     *
     * 解题思路
     * 由于 n 可能会非常大，因此不能直接用 int 表示数字，而是用 char 数组进行存储。
     *
     * 使用回溯法得到所有的数。
     */

    public static void printOneToNum(int n) {
        if (n < 0) {
            return;
        }
        char[] nums = new char[n];
        printOneToNum(nums, 0);
    }

    private static void printOneToNum(char[] nums, int i) {
        if (nums.length == i) {
            printNum(nums);
            return;
        }
        for (int j = 0; j < 10; j++) {
            nums[i] = (char)(j + '0');
            printOneToNum(nums, i+1);
        }
    }

    private static void printNum(char[] nums) {
        int index = 0;
        while (index < nums.length && nums[index] == '0') {
            index++;
        }
        while (index < nums.length) {
            System.out.print(nums[index++]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
       printOneToNum(33);
    }
}
