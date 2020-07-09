package Thread;

/**
 * @Description：
 * @Author: ldl
 * @CreateDate: 2020/7/8 17:28
 */
public class Demo2 {
    /**
     * 现在有T1、T2、T3三个线程，你怎样保证T2在T1执行完后执行，T3在T2执行完后执行？
     */

    public static void main(String[] args) throws Exception{
        Project T1 = new Project("1");
        Project T2 = new Project("2");
        Project T3 = new Project("3");
        T1.start();
        T1.join();
        T2.start();
        T2.join();
        T3.start();
        T3.join();

    }
}

class Project extends Thread {
    public Project(String name) {
        super(name);
    }
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(this.getName() + i);
        }
    }
}