package polymorphismPractice.entity;

/**
 * Created by ZQ.
 *
 * @date 2021/2/25$ 14:47$
 */
public class Cat extends Animal {
    public void eat() {
        System.out.println("吃鱼");
    }
    public void work() {
        System.out.println("抓老鼠");
    }
}
