package genericsPractice.entity;

/**
 * Created by ZQ.
 * 泛型方法
 * @date 2021/2/25$ 11:01$
 */
public class ArrayEntity {
    // 泛型方法 printArray
    public static < E > void printArray( E[] inputArray )
    {
        // 输出数组元素
        for ( E element : inputArray ){
            System.out.printf( "%s ", element );
        }
        System.out.println();
    }

}
