package multithreading.entity;

import java.util.concurrent.Callable;

/**
 * Created by ZQ.
 *
 * @date 2021/2/25$ 17:35$
 */
public class CallableThread implements Callable<Integer> {
//    @Override
    public Integer call() throws Exception
    {
        int i = 0;
        for(;i<100;i++)
        {
            System.out.println(Thread.currentThread().getName()+" "+i);
        }
        return i;
    }
}
