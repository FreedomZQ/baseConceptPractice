package overrideAndOverloadPractice;

import overrideAndOverloadPractice.entity.Animal;
import overrideAndOverloadPractice.entity.Dog;
import overrideAndOverloadPractice.entity.Overloading;

/**
 * Created by ZQ.
 * 参考： 菜鸟教程 https://www.runoob.com/java/java-override-overload.html
 *
 * 一、重写（Override）
 1）规则：
     1、参数列表与被重写方法的参数列表必须完全相同。
     2、返回类型与被重写方法的返回类型可以不相同，但是必须是父类返回值的派生类（java5 及更早版本返回类型要一样，java7 及更高版本可以不同）。
     3、访问权限不能比父类中被重写的方法的访问权限更低。例如：如果父类的一个方法被声明为 public，那么在子类中重写该方法就不能声明为 protected。
     4、父类的成员方法只能被它的子类重写。
     5、声明为 final 的方法不能被重写。
     6、声明为 static 的方法不能被重写，但是能够被再次声明。
     7、子类和父类在同一个包中，那么子类可以重写父类所有方法，除了声明为 private 和 final 的方法。
     8、子类和父类不在同一个包中，那么子类只能够重写父类的声明为 public 和 protected 的非 final 方法。
     9、重写的方法能够抛出任何非强制异常，无论被重写的方法是否抛出异常。但是，重写的方法不能抛出新的强制性异常，或者比被重写方法声明的更广泛的强制性异常，反之则可以。
     10、构造方法不能被重写。
     11、如果不能继承一个类，则不能重写该类的方法。
 2）Super关键字的使用
    当需要在子类中调用父类的被重写方法时，要使用 super 关键字。

 * 二、重载（Overload）
 1）规则
     1、被重载的方法必须改变参数列表(参数个数或类型不一样)；
     2、被重载的方法可以改变返回类型；
     3、被重载的方法可以改变访问修饰符；
     4、被重载的方法可以声明新的或更广的检查异常；
     5、方法能够在同一个类中或者在一个子类中被重载。
     6、无法以返回值类型作为重载函数的区分标准。

 三、重写与重载之间的区别
     区别点 	重载方法 	重写方法
     参数列表 	必须修改 	一定不能修改
     返回类型 	可以修改 	一定不能修改
     异常 	    可以修改 	可以减少或删除，一定不能抛出新的或者更广的异常
     访问 	    可以修改 	一定不能做更严格的限制（可以降低限制）
 * @date 2021/2/25$ 16:07$
 */
public class overrideAndOverloadBehaviorMain {
    public static void main(String args[]){
        /**
         * 一、重写Override
         * 继承的子类重写父类的方法
         * 重写是子类对父类的允许访问的方法的实现过程进行重新编写, 返回值和形参都不能改变。即外壳不变，核心重写
         */
        System.out.println("----------一、重写Override-----------\n1、继承的子类重写父类的方法");
        Animal a = new Animal(); // Animal 对象
        Animal b = new Dog(); // Dog 对象

        a.move();// 执行 Animal 类的方法
        b.move();//执行 Dog 类的方法
        // b.bark(); //该语句程序将抛出一个编译错误，因为b的引用类型Animal没有bark方法，如果将b强转为Dog类即可以使用此方法
        System.out.println("【说明】子类中特有的方法需要变量类型为此子类时才可以使用");
        ((Dog) b).bark();

        System.out.println("----------一、重写Override-----------\n2、Super关键字的使用");
        b.drink(); //执行Dog类的方法，此方法中调用父类别重写的方法

        /**
         * 二、重载Overload
         * 重载(overloading) 是在一个类里面，方法名字相同，而参数不同。返回类型可以相同也可以不同。
         * 每个重载的方法（或者构造函数）都必须有一个独一无二的参数类型列表。
         * 最常用的地方就是构造器的重载。
         */
        System.out.println("----------二、重载Overload----------");
        Overloading o = new Overloading();
        System.out.println(o.test());
        o.test(1);
        System.out.println(o.test(1,"test3"));
        System.out.println(o.test("test4",1));
    }
}
