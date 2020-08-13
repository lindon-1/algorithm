package DataStructure;


import java.util.Arrays;

/**
 * @Description： 冒泡排序
 * @Author: ldl
 * @CreateDate: 2020/8/3 16:34
 */
public class MaoPaoSort {

    public static void main(String[] args) {
        int[] a = new int[]{1, 4, 2, 45, 44, 3, 23};
        quikeSort(a, 0, 6);
        Arrays.stream(a).forEach(e -> {
            System.out.print(e + " ,");
        });
    }

    /**
     * 冒泡排序
     *
     * @param src
     * @return
     */
    public static void sort(int[] src) {
        for (int i = 0; i < src.length; i++) {
            for (int j = 0; j < src.length - (i + 1); j++) {
                if (src[j] > src[j + 1]) {
                    swap(src, j, j + 1);
                }
            }
        }

    }


    /**
     * 选择排序
     *
     * @param src
     * @return
     */
    public static void xuanzeSort(int[] src) {
        for (int i = 0; i < src.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < src.length; j++) {
                if (src[j] < src[min]) {
                    min = j;
                }
            }
            if (min != i) {
                swap(src, i, min);
            }
        }
    }

    /**
     * 插入排序
     *
     * @param src
     * @return
     */
    public static void charuSort(int[] src) {
        for (int i = 1; i < src.length; i++) {
            int index = i;
            for (int j = i - 1; j >= 0; j--) {
                if (src[i] <= src[j]) {
                    index = j;
                } else {
                    break;
                }
            }
            if (index != i) {
                int temp = src[i];
                for (int j = i; j >= index; j--) {
                    src[j] = src[j - 1];
                }
                src[index] = temp;
            }
        }

    }

    public static void quikeSort(int[] src, int low, int hight) {

        if (low > hight) {
            return;
        }
        int temp = src[low];
        int nowLow = low;
        int nowHight = hight;
        while (nowLow < nowHight) {
            while (src[nowHight] >=temp && nowLow < nowHight) {
                nowHight--;
            }

            while (src[nowLow] <= temp && nowLow < nowHight) {
                nowLow++;
            }
            if (nowLow < nowHight) {
                swap(src, nowLow, nowHight);

            }
        }

        src[low] = src[nowLow];
        src[nowLow] = temp;
        quikeSort(src, low, nowHight - 1);
        quikeSort(src, nowHight + 1, hight);


    }


    private static void swap(int[] src, int j, int i) {
        int temp = src[j];
        src[j] = src[i];
        src[i] = temp;
    }
}
