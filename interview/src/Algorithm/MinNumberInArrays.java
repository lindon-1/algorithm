package Algorithm;

/**
 * @Description：旋转数组的最小数字
 * @Author: ldl
 * @CreateDate: 2020/6/17 14:53
 */
public class MinNumberInArrays {
    /**
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
     * 解题思路
     * 将旋转数组对半分可以得到一个包含最小元素的新旋转数组，以及一个非递减排序的数组。新的旋转数组的数组元素是原数组的一半，
     * 从而将问题规模减少了一半，这种折半性质的算法的时间复杂度为 O(logN)（为了方便，这里将 log2N 写为 logN）。
     * 此时问题的关键在于确定对半分得到的两个数组哪一个是旋转数组，哪一个是非递减数组。我们很容易知道非递减数组的第一个元素一定小于等于最后一个元素。
     *
     * 通过修改二分查找算法进行求解（l 代表 low，m 代表 mid，h 代表 high）：
     *
     * 当 nums[m] <= nums[h] 时，表示 [m, h] 区间内的数组是非递减数组，[l, m] 区间内的数组是旋转数组，此时令 h = m；
     * 否则 [m + 1, h] 区间内的数组是旋转数组，令 l = m + 1。
     */

    public static int minNumberInRotateArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        int mid = left;

        while (left <= right) {
            mid =left + (right - left)/2;
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                return orderFind(nums, left, right);
            }
            if (nums[mid] <= nums[right]) {
                right = mid;

            } else {
                left = mid + 1;
            }
//
        }
        return nums[mid];
    }

    public static int orderFind(int[] nums, int left, int right) {
        for (int i = left; i < right; i++) {
            if (nums[i] >nums[i + 1]) {
                return nums[i + 1];
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        System.out.println(minNumberInRotateArray(new int[]{ 1,1,1,1,1,1,0}));
    }
}
