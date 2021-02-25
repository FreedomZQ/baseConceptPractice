package genericsPractice;

import genericsPractice.entity.Box;

import java.util.ArrayList;
import java.util.List;

import static genericsPractice.entity.ListEntity.getData;
import static genericsPractice.entity.ListEntity.getUperNumber;
import static genericsPractice.entity.MaximumEntity.maximum;
import static genericsPractice.entity.ArrayEntity.printArray;

/**
 * Created by ZQ.
 * 参考：菜鸟教程 https://www.runoob.com/java/java-generics.html
 * 泛型的练习：
 * 一、泛型方法：
 * 1、数组的泛型方法
 * 2、使用在一般意义上的extends（类）或者implements（接口）
 * 二、泛型类
 * 三、类型通配符
 * 1、类型通配符一般是使用?代替具体的类型参数。例如 List<?> 在逻辑上是List<String>,List<Integer> 等所有List<具体类型实参>的父类。
 * 2、类型通配符上限通过形如List来定义，如此定义就是通配符泛型值接受Number及其下层子类类型。
 *
 * @date 2021/2/25$ 10:43$
 */
public class genericsBehaviorMain {

    public static void main( String args[] )
    {
        /**
         * 一、泛型方法：1、数组的泛型方法
         */
        System.out.println("------------一、泛型方法:----------------\n1、数组的泛型方法");
        // 创建不同类型数组： Integer, Double 和 Character
        Integer[] intArray = { 1, 2, 3, 4, 5 };
        Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
        Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };

        System.out.println( "整型数组元素为:" );
        printArray( intArray  ); // 传递一个整型数组

        System.out.println( "\n双精度型数组元素为:" );
        printArray( doubleArray ); // 传递一个双精度型数组

        System.out.println( "\n字符型数组元素为:" );
        printArray( charArray ); // 传递一个字符型数组

        /**
         * 一、泛型方法：2、使用在一般意义上的extends（类）或者implements（接口）
         */
        System.out.println("------------一、泛型方法：----------------\n2、使用在一般意义上的extends（类）或者implements（接口）");
        System.out.printf( "%d, %d 和 %d 中最大的数为 %d\n\n", 3, 4, 5, maximum( 3, 4, 5 ) );

        System.out.printf( "%.1f, %.1f 和 %.1f 中最大的数为 %.1f\n\n", 6.6, 8.8, 7.7, maximum( 6.6, 8.8, 7.7 ) );

        System.out.printf( "%s, %s 和 %s 中最大的数为 %s\n","pear", "apple", "orange", maximum( "pear", "apple", "orange" ) );


        /**
         * 二、泛型类
         */
        System.out.println("------------二、泛型类----------------");
        Box<Integer> integerBox = new Box<Integer>();
        Box<String> stringBox = new Box<String>();

        integerBox.add(new Integer(10));
        stringBox.add(new String("菜鸟教程"));

        System.out.printf("整型值为 :%d\n\n", integerBox.get());
        System.out.printf("字符串为 :%s\n", stringBox.get());

        /**
         * 三、类型通配符
         *
         * 1、类型通配符一般是使用?代替具体的类型参数。例如 List<?> 在逻辑上是List<String>,List<Integer> 等所有List<具体类型实参>的父类。
         *  因为getData()方法的参数是List类型的，所以name，age，number都可以作为这个方法的实参，这就是通配符的作用
         */
        System.out.println("------------三、类型通配符：----------------\n1、类型通配符的使用");
        List<String> name = new ArrayList<String>();
        List<Integer> age = new ArrayList<Integer>();
        List<Number> number = new ArrayList<Number>();

        name.add("icon");
        age.add(18);
        number.add(314);

        getData(name);
        getData(age);
        getData(number);


        /**
         * 三、类型通配符
         *
         * 2、类型通配符上限通过形如List来定义，如此定义就是通配符泛型值接受Number及其下层子类类型。
         */
        System.out.println("------------三、类型通配符：----------------\n2、类型通配符上限通过形如List来定义，如此定义就是通配符泛型值接受Number及其下层子类类型。");
        //getUperNumber(name); getUperNumber()方法中的参数已经限定了参数泛型上限为Number，所以泛型为String是不在这个范围之内，所以会报错
        getUperNumber(age);
        getUperNumber(number);
    }
}
