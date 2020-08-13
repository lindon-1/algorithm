package Thread;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Description：
 * @Author: ldl
 * @CreateDate: 2020/7/15 9:48
 */
public class ForkJoinPoolDemo {
    public static void main(String[] args) throws Exception{
        ForkJoinPool forkJoinPool = new ForkJoinPool(10, ForkJoinPool.defaultForkJoinWorkerThreadFactory, null, true);
        ForkJoinTask<Integer> submit = forkJoinPool.submit(new MyRecursiveTask(1, 100));
        System.out.println(submit.get());

        System.out.println(IntStream.rangeClosed(1, 100).sum());
        IntStream.of(1, 3, 5, 2, 7, 4, 4, 5).sorted().forEach(e -> System.out.println(e));

        //language=JSON
        String a = "{\n" +
                "  \"data\": {\n" +
                "      \"userId\": \"123352342\",\n" +
                "      \"password\": \"123456\"\n" +
                "  }\n" +
                "}";

    }

}


class MyRecursiveTask extends RecursiveTask<Integer> {
    private static final int threadHold = 2;
    private int start;
    private int end;
    private int sum = 0;

    public MyRecursiveTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        boolean flag = (end - start) <= threadHold;

        if (flag) {
            System.out.println("当前线程： " + Thread.currentThread().getName());
            System.out.println(start + ": " + end);
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        } else {
            int middle = (end + start) / 2;
            MyRecursiveTask leftTask = new MyRecursiveTask(start, middle);
            MyRecursiveTask rightTask = new MyRecursiveTask(middle + 1, end);
            leftTask.fork();
            rightTask.fork();
            sum = leftTask.join() + rightTask.join();
        }
        return sum;
    }
}
