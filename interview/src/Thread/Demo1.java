package Thread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Description：
 * @Author: ldl
 * @CreateDate: 2020/7/7 16:06
 */
public class Demo1 {

    public static void main(String[] args) throws Exception{
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 2L,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(10), new ThreadPoolExecutor.CallerRunsPolicy());

        List<Future> list = IntStream.rangeClosed(1, 100).boxed().map(e -> {
            return threadPoolExecutor.submit(() -> {
                Thread.sleep(1000);
                return Thread.currentThread().getName();
            });
        }).collect(Collectors.toList());

        Executor executor = CompletableFuture.delayedExecutor(10L, TimeUnit.SECONDS);
        executor.execute(() -> {
            System.out.println(Thread.currentThread().getName() + "延迟10秒执行！");
        });
        System.out.println(list.size());
        int i =0;
        for (Future e : list) {
            try {
                System.out.println(e.get());
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            } catch (ExecutionException ex) {
                ex.printStackTrace();
            }
            i += 1;
        }
        System.out.println(i);

        List arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        ListIterator listIterator = arrayList.listIterator();
        while (listIterator.hasNext()) {
//            System.out.println(listIterator.next());
            if (listIterator.next().equals(1))
                listIterator.remove();
        }
        System.out.println(arrayList);
    }


}
class MyCall implements Callable{

    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return Thread.currentThread().getName();
    }
}