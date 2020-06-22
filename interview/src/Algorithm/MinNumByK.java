package Algorithm;

import java.util.ArrayList;
import java.util.PriorityQueue;


/**
 * @Description：最小的 K 个数
 * @Author: ldl
 * @CreateDate: 2020/6/15 10:02
 */
public class MinNumByK {
    public static void main(String[] args) {
        int[] ints = {1, 18, 15, 29, 3, 6, 44, 23, 14, 15, 17, 55, 44};
        int index = ints.length - 5;
        System.out.println(GetLeastNumbers_Solution(ints, index));
        System.out.println(GetLeastNumbers_Solution_ByHeap(ints, index));
    }


    /**
     * 解题思路
     * 快速选择
     * 复杂度：O(N) + O(1)
     * 只有当允许修改数组元素时才可以使用
     * 快速排序的 partition() 方法，会返回一个整数 j 使得 a[l..j-1] 小于等于 a[j]，且 a[j+1..h] 大于等于 a[j]，
     * 此时 a[j] 就是数组的第 j 大元素。可以利用这个特性找出数组的第 K 个元素，这种找第 K 个元素的算法称为快速选择算法。
     * @param nums
     * @param k
     * @return
     */
    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] nums, int k) {
        ArrayList<Integer> res = new ArrayList<>(nums.length);
        if (k > nums.length || k < 0) {
            return res;
        }
        int left = 0;
        int right = nums.length -1;
        while (true) {
           int j = find(nums, left, right); 
           if (j == k) {
               break;
           } else if (j > k) {
                right = j - 1;
           } else {
               left = j + 1;
           }
        }
        for (int i = 0; i < k; i++) {
            res.add(nums[i]);
        }
        return res;
    }

    /**
     * 大小为 K 的最小堆
     * 复杂度：O(NlogK) + O(K)
     * 特别适合处理海量数据
     * 应该使用大顶堆来维护最小堆，而不能直接创建一个小顶堆并设置一个大小，企图让小顶堆中的元素都是最小元素。
     *
     * 维护一个大小为 K 的最小堆过程如下：在添加一个元素之后，如果大顶堆的大小大于 K，那么需要将大顶堆的堆顶元素去除。
     * @param nums
     * @param k
     * @return
     */
    public static  ArrayList<Integer> GetLeastNumbers_Solution_ByHeap(int[] nums, int k) {
        if (k > nums.length || k < 0) {
            return new ArrayList<>();
        }
        PriorityQueue<Integer> res = new PriorityQueue<Integer>((o1, o2) -> o2 - o1);
        for (int i = 0; i < nums.length; i++) {
            res.add(nums[i]);
            if (res.size() > k) {
                res.poll();
            }
        }
        return new ArrayList<>(res);
    }

    private static int find(int[] nums, int left, int right) {
        int l = left;
        int h = right + 1;
        int node = nums[l];
        while (true) {
            while (l != right && nums[++l] < node){};
            while (h != left && nums[--h] > node){};
            if (l >= h) {
                break;
            }
            swap(nums, l, h);
        }
        swap(nums, left, h);
        return h;
    }

    private static void swap(int[] nums, int l, int h) {
        int temp = nums[l];
        nums[l] = nums[h];
        nums[h] = temp;
    }


}
