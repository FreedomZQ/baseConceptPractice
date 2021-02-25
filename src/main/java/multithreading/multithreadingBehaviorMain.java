package multithreading;

import multithreading.entity.*;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;


/**
 * Created by ZQ.
 * 参考： 菜鸟教程 https://www.runoob.com/java/java-multithreading.html
 * 多线程编程
 一、一个线程的生命周期
   线程是一个动态执行的过程，它也有一个从产生到死亡的过程。
 1、新建状态:
    使用 new 关键字和 Thread 类或其子类建立一个线程对象后，该线程对象就处于新建状态。它保持这个状态直到程序 start() 这个线程。
 2、就绪状态:
    当线程对象调用了start()方法之后，该线程就进入就绪状态。就绪状态的线程处于就绪队列中，要等待JVM里线程调度器的调度。
 3、运行状态:
    如果就绪状态的线程获取 CPU 资源，就可以执行 run()，此时线程便处于运行状态。处于运行状态的线程最为复杂，它可以变为阻塞状态、就绪状态和死亡状态。
 4、阻塞状态:
    如果一个线程执行了sleep（睡眠）、suspend（挂起）等方法，失去所占用资源之后，该线程就从运行状态进入阻塞状态。在睡眠时间已到或获得设备资源后可以重新进入就绪状态。可以分为三种：
     1）等待阻塞：运行状态中的线程执行 wait() 方法，使线程进入到等待阻塞状态。
     2）同步阻塞：线程在获取 synchronized 同步锁失败(因为同步锁被其他线程占用)。
     3）其他阻塞：通过调用线程的 sleep() 或 join() 发出了 I/O 请求时，线程就会进入到阻塞状态。当sleep() 状态超时，join() 等待线程终止或超时，或者 I/O 处理完毕，线程重新转入就绪状态。
 5、死亡状态:
    一个运行状态的线程完成任务或者其他终止条件发生时，该线程就切换到终止状态。

 二、 线程的优先级
   每一个 Java 线程都有一个优先级，这样有助于操作系统确定线程的调度顺序。
   Java 线程的优先级是一个整数，其取值范围是 1 （Thread.MIN_PRIORITY ） - 10 （Thread.MAX_PRIORITY ）。
   默认情况下，每一个线程都会分配一个优先级 NORM_PRIORITY（5）。
   具有较高优先级的线程对程序更重要，并且应该在低优先级的线程之前分配处理器资源。但是，线程优先级不能保证线程执行的顺序，而且非常依赖于平台。

 三、创建线程的方法
 Java 提供了三种创建线程的方法：
     1、通过实现 Runnable 接口；
     2、通过继承 Thread 类本身；
     3、通过 Callable 和 Future 创建线程。

 四、创建线程的三种方式的对比
 1. 采用实现 Runnable、Callable 接口的方式创建多线程时，线程类只是实现了 Runnable 接口或 Callable 接口，还可以继承其他类。
 2. 使用继承 Thread 类的方式创建多线程时，编写简单，如果需要访问当前线程，则无需使用 Thread.currentThread() 方法，直接使用 this 即可获得当前线程。

 五、线程的几个主要概念
   在多线程编程时，你需要了解以下几个概念：
     1、线程同步
     2、线程间通信
     3、线程死锁
     4、线程控制：挂起、停止和恢复

 六、多线程的使用
     1、有效利用多线程的关键是理解程序是并发执行而不是串行执行的。例如：程序中有两个子系统需要并发执行，这时候就需要利用多线程编程。
     2、通过对多线程的使用，可以编写出非常高效的程序。不过请注意，如果你创建太多的线程，程序执行的效率实际上是降低了，而不是提升了。
     3、请记住，上下文的切换开销也很重要，如果你创建了太多的线程，CPU 花费在上下文的切换的时间将多于执行程序的时间！

 * @date 2021/2/25$ 16:52$
 */
public class multithreadingBehaviorMain {

    public static void main (String[] args){
        /**
         * 方法一：通过实现 Runnable 接口来创建线程
         *  步骤：
         *  1、创建一个线程，最简单的方法是创建一个实现 Runnable 接口的类。
         *      为了实现 Runnable，一个类只需要执行一个方法调用 run()
         *  2、 在创建一个实现 Runnable 接口的类之后，你可以在类中实例化一个线程对象。
         *      Thread 定义了几个构造方法，下面的这个是我们经常使用的：Thread(Runnable threadOb,String threadName);
         *      这里，threadOb 是一个实现 Runnable 接口的类的实例，并且 threadName 指定新线程的名字。
         *  3、新线程创建之后，你调用它的 start() 方法它才会运行。
         */
        System.out.println("-----------方法一：通过实现 Runnable 接口来创建线程------------");
        RunnableDemo R1 = new RunnableDemo( "Thread-1");
        R1.start();

        RunnableDemo R2 = new RunnableDemo( "Thread-2");
        R2.start();

        //休息2秒后再进行第二种Thread方法运行
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /**
         * 方法二：通过继承Thread来创建线程
         *  创建一个线程的第二种方法是创建一个新的类，该类继承 Thread 类，然后创建一个该类的实例。
         * 步骤：继承类必须重写 run() 方法，该方法是新线程的入口点。它也必须调用 start() 方法才能执行。
         * 该方法尽管被列为一种多线程实现方式，但是本质上也是实现了 Runnable 接口的一个实例。
         */
        System.out.println("-----------方法二：通过继承Thread来创建线程------------");
        ThreadDemo T1 = new ThreadDemo( "Thread-1");
        T1.start();

        ThreadDemo T2 = new ThreadDemo( "Thread-2");
        T2.start();

        //休息2秒后再进行第二种Thread方法运行
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /**
         * Thread 的一些重要方法
         */
//        System.out.println("----------方法二：Thread 的一些重要方法-----------");
//        Runnable hello = new DisplayMessage("Hello");
//        Thread thread1 = new Thread(hello);
//        thread1.setDaemon(true);
//        thread1.setName("hello");
//        System.out.println("Starting hello thread...");
//        thread1.start();
//
//        Runnable bye = new DisplayMessage("Goodbye");
//        Thread thread2 = new Thread(bye);
//        thread2.setPriority(Thread.MIN_PRIORITY);
//        thread2.setDaemon(true);
//        System.out.println("Starting goodbye thread...");
//        thread2.start();
//
//        System.out.println("Starting thread3...");
//        Thread thread3 = new GuessANumber(7);
//        thread3.start();
//        try {
//            thread3.join();
//        }catch(InterruptedException e) {
//            System.out.println("Thread interrupted.");
//        }
//        System.out.println("Starting thread4...");
//        Thread thread4 = new GuessANumber(5);
//
//        thread4.start();
//        System.out.println("main() is ending...");
//
//        //休息2秒后再进行第二种Thread方法运行
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        /**
         * 方法三：通过 Callable 和 Future 创建线程
         * 步骤：
         *      1. 创建 Callable 接口的实现类，并实现 call() 方法，该 call() 方法将作为线程执行体，并且有返回值。
         *     2. 创建 Callable 实现类的实例，使用 FutureTask 类来包装 Callable 对象，该 FutureTask 对象封装了该 Callable 对象的 call() 方法的返回值。
         *     3. 使用 FutureTask 对象作为 Thread 对象的 target 创建并启动新线程。
         *     4. 调用 FutureTask 对象的 get() 方法来获得子线程执行结束后的返回值。
         */
        System.out.println("------------方法三：通过 Callable 和 Future 创建线程--------------");
        CallableThread ctt = new CallableThread();
        FutureTask<Integer> ft = new FutureTask<Integer>(ctt);
        for(int i = 0;i < 100;i++)
        {
            System.out.println(Thread.currentThread().getName()+" 的循环变量i的值"+i);
            if(i==20)
            {
                new Thread(ft,"有返回值的线程").start();
            }
        }
        try
        {
            System.out.println("子线程的返回值："+ft.get());
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        } catch (ExecutionException e)
        {
            e.printStackTrace();
        }

    }
}
