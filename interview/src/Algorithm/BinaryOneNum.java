package Algorithm;

/**
 * @Description： 二进制中 1 的个数
 * @Author: ldl
 * @CreateDate: 2020/6/24 10:02
 */
public class BinaryOneNum {

    /**
     * 题目描述
     * 输入一个整数，输出该数二进制表示中 1 的个数。
     *
     * n&(n-1)
     * 该位运算去除 n 的位级表示中最低的那一位。
     *
     * n       : 10110100
     * n-1     : 10110011
     * n&(n-1) : 10110000
     * Copy to clipboardErrorCopied
     * 时间复杂度：O(M)，其中 M 表示 1 的个数。
     */


    public static int NumberOf1(int n) {
        int count  = 0;
        while (n > 0) {
            count ++;
            n &= (n - 1);
        }
        return count;
    }

    /**
     * Integer.bitCount()
     */

    public static int NumberOf1ByInteger(int n) {
        return Integer.bitCount(n);
    }

    public static void main(String[] args) {
        System.out.println(NumberOf1(12111119));
        System.out.println(NumberOf1ByInteger(12111119));

    }
}
