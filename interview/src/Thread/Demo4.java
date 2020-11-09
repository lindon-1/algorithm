package Thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description 交替打印100内数字
 * @Author Lindonglin
 * @date 2020/11/9 16:27
 **/
public class Demo4 {

    public static void main(String[] args) {
        AtomicInteger num = new AtomicInteger(0);
        new Thread(() -> {
            while (num.get() < 100) {
                if (num.get() % 2 == 0 && num.get() < 100) {
                    System.out.println(Thread.currentThread().getName() + ":" + num.get());
                    num.getAndIncrement();
                }
            }
        }).start();
        new Thread(() -> {
            while (num.get() < 100) {
                if (num.get() % 2 == 1 && num.get() < 100) {
                    System.out.println(Thread.currentThread().getName() + ":" + num.get());
                    num.getAndIncrement();
                }
            }
        }).start();
    }
}
