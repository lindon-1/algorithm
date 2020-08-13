package DesignModel;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Description：
 * @Author: ldl
 * @CreateDate: 2020/8/3 11:53
 */
public class MainDemo {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 1, TimeUnit.MINUTES, new ArrayBlockingQueue<>(10),new ThreadPoolExecutor.CallerRunsPolicy());
        List<Integer> collect = IntStream.rangeClosed(1, 100).boxed().parallel().map(t -> {
            CompletableFuture.runAsync(() -> {
                System.out.println(Thread.currentThread().getName() + ": " + SingoalDemo2.getInstance());
            }, threadPoolExecutor);
            return t;
        }).collect(Collectors.toList());

    }
}
