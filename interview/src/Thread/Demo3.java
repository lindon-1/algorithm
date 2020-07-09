package Thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description：
 * @Author: ldl
 * @CreateDate: 2020/7/8 17:41
 */
public class Demo3 {
    /**
     * 编写一个程序，启动三个线程，三个线程的ID分别是A，B，C；，每个线程将自己的ID值在屏幕上打印5遍，打印顺序是ABCABC...
     */
    public static void main(String[] args) {
        ProjByLock proj = new ProjByLock();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                proj.printA();
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                proj.printB();
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                proj.printC();

            }
        }).start();
    }

}

class Proj{
     private  volatile int flag = 1;

     public synchronized void printA() {
         while (flag!=1) {
             try {
                 this.wait();
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }

         System.out.print("A");
         flag = 2;
         this.notifyAll();
     }

    public synchronized void printB() {
        while (flag!=2) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.print("B");
        flag = 3;
        this.notifyAll();
    }

    public synchronized void printC() {
        while (flag!=3) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print("C");
        flag = 1;
        this.notifyAll();
    }
}

class ProjByLock{
    private volatile int count =1;
    ReentrantLock reentrantLock = new ReentrantLock();
    Condition conditionA = reentrantLock.newCondition();
    Condition conditionB = reentrantLock.newCondition();
    Condition conditionC = reentrantLock.newCondition();

    public void printA()
    {

//
        reentrantLock.lock();
        try {
//            while (count != 1) {
//                conditionA.await();
//          }
            if (count != 1) {
                conditionA.await();
            }
            System.out.println("A");
            count = 2;
            conditionB.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }

    public void printB(){

//        while (count != 2) {
//
//        }
        reentrantLock.lock();
        try {
            if (count != 2) {
                conditionB.await();
            }
            System.out.println("B");
            count = 3;
            conditionC.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }

    public void printC(){

//        while (count != 3) {
//
//        }
        reentrantLock.lock();
        try {
            if (count != 3) {
                conditionC.await();
            }
            System.out.println("C");
            count =1;
            conditionA.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }
}