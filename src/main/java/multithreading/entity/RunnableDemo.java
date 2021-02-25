package multithreading.entity;

/**
 * Created by ZQ.
 * 通过实现 Runnable 接口来创建线程
 * @date 2021/2/25$ 17:08$
 */
public class RunnableDemo implements Runnable {
    private Thread t;
    private String threadName;

    public RunnableDemo( String threadName) {
        this.threadName = threadName;
        System.out.println("Creating " +  this.threadName );
    }

    public void run() {
        System.out.println("Running " +  threadName );
        try {
            for(int i = 4; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", " + i);
                // 让线程睡眠一会
                Thread.sleep(50);
            }
        }catch (InterruptedException e) {
            System.out.println("Thread " +  threadName + " interrupted.");
        }
        System.out.println("Thread " +  threadName + " exiting.");
    }

    public void start () {
        System.out.println("Starting " +  threadName );
        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }
    }
}