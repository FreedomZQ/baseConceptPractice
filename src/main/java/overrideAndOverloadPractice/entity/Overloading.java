package overrideAndOverloadPractice.entity;

/**
 * Created by ZQ.
 *
 * @date 2021/2/25$ 16:32$
 */
public class Overloading {
    public int test(){
        System.out.println("test1");
        return 1;
    }

    public void test(int a){
        System.out.println("test2");
    }

    //以下两个参数类型顺序不同
    public String test(int a,String s){
        System.out.println("test3");
        return "return test3";
    }

    public String test(String s,int a){
        System.out.println("test4");
        return "return test4";
    }
}
