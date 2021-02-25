package overrideAndOverloadPractice.entity;

/**
 * Created by ZQ.
 * 重写Override
 * @date 2021/2/25$ 16:08$
 */
public class Dog extends Animal {
    /**
     * 重写了Animal的move方法
     */
    public void move(){
        System.out.println("狗可以跑和走");
    }

    /**
     * 当需要在子类中调用父类的被重写方法时，要使用 super 关键字。
     */
    public void drink(){
        super.drink(); //应用super类的方法
        System.out.println("狗可以喝水");
    }

    /**
     * 新的方法，父类中没有此方法
     */
    public void bark(){
        System.out.println("狗可以吠叫");
    }
}
