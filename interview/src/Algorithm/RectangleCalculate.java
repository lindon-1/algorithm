package Algorithm;

/**
 * @Description： 矩形覆盖跟跳台阶思路一样
 * @Author: ldl
 * @CreateDate: 2020/6/16 10:58
 */
public class RectangleCalculate {
    /**
     * 我们可以用 2*1 的小矩形横着或者竖着去覆盖更大的矩形。请问用 n 个 2*1 的小矩形无重叠地覆盖一个 2*n 的大矩形，总共有多少种方法？
     * 当 n 为 1 时，只有一种覆盖方法：
     *
     *
     * 当 n 为 2 时，有两种覆盖方法：
     *
     *
     *
     * 要覆盖 2*n 的大矩形，可以先覆盖 2*1 的矩形，再覆盖 2*(n-1) 的矩形；或者先覆盖 2*2 的矩形，再覆盖 2*(n-2) 的矩形。而覆盖 2*(n-1) 和 2*(n-2) 的矩形可以看成子问题。该问题的递推公式如下：
     *
     * f(n)  n =1,   f(n) =1;
     * f(n) n =2, f(n) = 2;
     * f(n) n >2,    f(n) = f(n -1) + f(n -2)
     *
     * --------------------------------
     * 跳台阶
     * 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
     * 思路：
     *         f(n)  n =1,   f(n) =1;
     *      * f(n) n =2, f(n) = 2;
     *      * f(n) n >2,    f(n) = f(n -1) + f(n -2)
     */

    public static void main(String[] args) {
        System.out.println(RectCover(4));
    }

    public static int  RectCover(int n) {

        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else if (n > 2) {
            return RectCover(n - 1) + RectCover(n - 2);
        }
        return -1;
    }

}
