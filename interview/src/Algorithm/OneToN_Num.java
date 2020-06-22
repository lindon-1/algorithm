package Algorithm;

/**
 * @Description：计算1-n之间1的个数
 * @Author: ldl
 * @CreateDate: 2020/6/18 10:24
 */
public class OneToN_Num {

    /**
     * 若x = abcde，我们来看百位为1出现的次数，这里分3种情况讨论：
     * 1. 百位为0时，假设x = 45021，可以算出百位为1出现情况：
     *       100~199
     *      1100~1199
     *     ...
     *     44100~44199
     *     总共是45*100个1
     * 2. 百位为1时，假设x = 45121，可以算出百位为1出现情况：
     *       100~199
     *      1100~1199
     *     ...
     *     44100~44199
     *     45100~45145
     *     总共是45*100+(45+1)个1
     * 3. 百位大于1时，假设x = 45821，可以算出百位为1出现情况：
     *       100~199
     *      1100~1199
     *     ...
     *     44100~44199
     *     45100~45199
     *     总共是(45+1)*100个1
     *
     * 于是，我们可以找到这样一个规律，对于某一特定的位，该位出现1的次数为：
     *
     * (1) 当该位 = 0时，次数num = 高位数 * 该位的进制
     * （2）当该位 =1时， 次数 num= 高位数 * 该位的进制 + 低位数 + 1
     * （3） 当该位 》 1时， 次数 num = (高位数+1) * 该位的进制
     * @param n
     * @return
     */

    public static int NumberOf1Between1AndN_Solution(int n) {
        if (n <= 0) {
            return 0;
        }
        int low;
        int hight;
        int cur;
        int res = 0;
        int level = 1;
        while (n/level != 0) {
            low = n % level;
            cur = n / level % 10;
            hight = n / level / 10;
            if (cur == 0) {
                res += hight * level;
            } else if (cur == 1) {
                res += hight * level + low + 1;
            } else {
                res += (hight+1) *level;
            }
            level *=10;
        }

        return res;

    }

    public static void main(String[] args) {
        System.out.println(NumberOf1Between1AndN_Solution(1111));

        String  s = new String("1") + new String("1");
        s.intern();
        String s2 = "11";
        System.out.println(s == s2);

        String s3 = new String("1");
        s3.intern();
        String s4 = "1";
        System.out.println(s3 == s4);
    }
}
