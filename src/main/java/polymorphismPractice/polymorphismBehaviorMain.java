package polymorphismPractice;

import polymorphismPractice.entity.Animal;
import polymorphismPractice.entity.Cat;
import polymorphismPractice.entity.Dog;

/**
 * Created by ZQ.
 * 参考：菜鸟教程 https://www.runoob.com/java/java-polymorphism.html
 多态:
 一、多态的优点
 1. 消除类型之间的耦合关系
 2. 可替换性
 3. 可扩充性
 4. 接口性
 5. 灵活性
 6. 简化性

 二、多态存在的三个必要条件
 1、继承
 2、重写
 3、父类引用指向子类对象：Parent p = new Child();

 * @date 2021/2/25$ 14:42$
 */
public class polymorphismBehaviorMain {
    public static void main (String arg[]){
        show(new Cat());  // 以 Cat 对象调用 show 方法
        show(new Dog());  // 以 Dog 对象调用 show 方法

        System.out.println("----解释多态的原理：Cat继承Animal，重写eat()方法，以及父类引用指向子类Animal a = new Cat()----");
        Animal a = new Cat();  // 向上转型
        a.eat();               // 调用的是 Cat 的 eat
        Cat c = (Cat)a;        // 向下转型
        c.work();        // 调用的是 Cat 的 work
    }

    public static void show(Animal a)  {
        a.eat();
        // 类型判断
        if (a instanceof Cat)  {  // 猫做的事情
            Cat c = (Cat)a;
            c.work();
        } else if (a instanceof Dog) { // 狗做的事情
            Dog c = (Dog)a;
            c.work();
        }
    }
}
