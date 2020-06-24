package Algorithm;

/**
 * @Description： 数组中重复的数字
 * @Author: ldl
 * @CreateDate: 2020/6/24 10:18
 */
public class DuplicateInArray {
    /**
     * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
     *
     * Input:
     * {2, 3, 1, 0, 2, 5}
     *
     * Output:
     * 2
     */
    /**
     * 解题思路1
     * 要求时间复杂度 O(N)，空间复杂度 O(1)。因此不能使用排序的方法，也不能使用额外的标记数组。
     *
     * 对于这种数组元素在 [0, n-1] 范围内的问题，可以将值为 i 的元素调整到第 i 个位置上进行求解。本题要求找出重复的数字，因此在调整过程中，如果第 i 位置上已经有一个值为 i 的元素，就可以知道 i 值重复。
     *
     * 以 (2, 3, 1, 0, 2, 5) 为例，遍历到位置 4 时，该位置上的数为 2，但是第 2 个位置上已经有一个 2 的值了，因此可以知道 2 重复：
     */

    public static int duplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        for (int i = 0; i < nums.length; i++) {
           while (nums[i] != i) {
               if (nums[i] != nums[nums[i]]) {
                   swap(nums, i, nums[i]);
               } else {
                   return nums[i];
               }
           }
        }
        return -1;
    }

    private static void swap(int[] nums, int i, int num) {
        int temp = nums[i];
        nums[i] = nums[num];
        nums[num] = temp;
    }

    /**
     * 解题思路2  复杂度O(N) 空间复杂度O(N)   利用空间换时间的概念
     * 1、使用一个长度为len的boolean数组缓存元素是否出现过
     *  * 2、当再次出现的数字已经在数组中，即找到重复元素
     */
    public static int duplicate2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        boolean[] remaked = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if(remaked[nums[i]]) {
                return nums[i];
            } else {
                remaked[nums[i]] = true;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        System.out.println(duplicate(new int[]{5,1,3,2,3,2,2, 3, 1, 0, 2, 5}));
        System.out.println(duplicate2(new int[]{5, 1, 3, 2, 3, 2, 2, 3, 1, 0, 2, 5}));
    }
}
