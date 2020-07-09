package Thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description： 生产者和消费者
 * @Author: ldl
 * @CreateDate: 2020/7/9 10:56
 */
public class ProductAndConsumer {

    public static void main(String[] args) {
        List list = new ArrayList(10);
        Product product = new Product(list);
//        Consumer product = new Consumer(list);
        new Thread(() -> {

            while (true) {
                product.product();
            }
        }).start();

        new Thread(() -> {
            while (true) {
                product.comsumer();
            }
        }).start();
    }

}

class Product{
    private List list;
    public Product(List list) {
        this.list = list;
    }

    public synchronized void product() {
        if (list.size() == 10) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        list.add(1);
        System.out.println("product: " + Thread.currentThread().getName() + "  size:"+ list.size());
        this.notifyAll();
    }

    public synchronized void comsumer() {
        if(list.size() <=0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.remove(list.size() - 1);
        System.out.println("consumer: " + Thread.currentThread().getName() + "  size:" + list.size());
        this.notifyAll();

    }
}

class Consumer{
    private List list;
    ReentrantLock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();

    public Consumer(List list) {
        this.list = list;
    }

    public  void product() {
        lock.lock();
        try {
            if (list.size() == 10) {
                condition1.await();
            }

            list.add(1);
            System.out.println("product: " + Thread.currentThread().getName() + "  size:"+ list.size());
            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void comsumer() {
        lock.lock();
        try {
            if(list.size() <=0) {
                condition2.await();
            }
            list.remove(list.size() - 1);
            System.out.println("consumer: " + Thread.currentThread().getName() + "  size:" + list.size());
            condition1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}