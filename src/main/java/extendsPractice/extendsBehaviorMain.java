package extendsPractice;

import extendsPractice.entity.Animal;
import extendsPractice.entity.Dog;

/**
 * Created by ZQ.
 * 参考： 菜鸟教程  https://www.runoob.com/java/java-inheritance.html
 * 继承的练习：动物类、狗类
 *
 * @date 2021/2/25$ 10:00$
 */
public class extendsBehaviorMain {
    public static void main(String args[]){
        //狗的动作行为
        Dog dog = new Dog();
        System.out.println("---------------------狗的动作行为---------------------");
        dog.setHealthValue(5);
        System.out.println("狗的生命值为："+dog.getHealthValue());
        dog.lookGate();
        System.out.println("狗的生命值为："+dog.getHealthValue());
        dog.lookGate();
        System.out.println("狗的生命值为："+dog.getHealthValue());
        dog.lookGate();
        System.out.println("狗的生命值为："+dog.getHealthValue());

        System.out.println("---------------------动物的动作行为---------------------");
        Animal animal = new Animal();
        animal.setHealthValue(3);
        System.out.println("动物的生命值为："+animal.getHealthValue());
        animal.run();
        System.out.println("动物的生命值为："+animal.getHealthValue());
        animal.run();
        System.out.println("动物的生命值为："+animal.getHealthValue());
        animal.eat();
        System.out.println("动物的生命值为："+animal.getHealthValue());

    }
}
