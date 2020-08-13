package DesignModel;

/**
 * @Description： 静态内部类单例
 * @Author: ldl
 * @CreateDate: 2020/8/3 12:00
 */
public class SingoalDemo2 {
    public static class nestClass {
        private static SingoalDemo2 singoalDemo2 = new SingoalDemo2();
    }

    public static SingoalDemo2 getInstance() {
        return nestClass.singoalDemo2;
    }
}
