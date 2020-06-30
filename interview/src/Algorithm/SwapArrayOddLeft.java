package Algorithm;

import java.util.Arrays;

/**
 * @Description：   调整数组顺序使奇数位于偶数前面
 * @Author: ldl
 * @CreateDate: 2020/6/30 14:42
 */
public class SwapArrayOddLeft {
    /**
     * 需要保证奇数和奇数，偶数和偶数之间的相对位置不变，这和书本不太一样。
     *
     *
     *
     * 解题思路
     * 方法一：创建一个新数组，时间复杂度 O(N)，空间复杂度 O(N)。
     */

    public  static void reOrderArray(int[] arr) {
        if (arr == null || arr.length == 0) {
             return;
        }
        int oddCount = 0;
        int oddIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!isEven(arr[i])) {
                oddCount++;
            }
        }
        int[] copy = arr.clone();
        for (int i : copy) {
            if (isEven(i)) {
                arr[oddCount++] = i;
            } else {
                arr[oddIndex++] = i;
            }
        }

    }

    public static boolean isEven(int n) {
        return n % 2 == 0;
    }

    /**
     * 方法二：使用冒泡思想，每次都将当前偶数上浮到当前最右边。时间复杂度 O(N2)，空间复杂度 O(1)，时间换空间。
     */
    public static void reOrderArray2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (isEven(arr[j]) && !isEven(arr[j+1])) {
                    swap(arr, j, j+1);
                }
            }
        }
    }

    private static void swap(int[] arr, int j, int i) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9};
        reOrderArray(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
