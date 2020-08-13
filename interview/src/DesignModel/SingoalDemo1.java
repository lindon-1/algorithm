package DesignModel;

/**
 * @Description： 饿汉式单例
 * @Author: ldl
 * @CreateDate: 2020/8/3 11:51
 */
public class SingoalDemo1 {
    private static final SingoalDemo1 singoalDemo1= new SingoalDemo1();

    public static SingoalDemo1 getInstance() {
        return singoalDemo1;
    }


}
