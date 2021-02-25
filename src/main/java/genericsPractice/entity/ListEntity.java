package genericsPractice.entity;

import java.util.List;

/**
 * Created by ZQ.
 * 三、类型通配符
 *
 * @date 2021/2/25$ 14:01$
 */
public class ListEntity {
    /**
     * 1、类型通配符一般是使用?代替具体的类型参数。例如 List<?> 在逻辑上是List<String>,List<Integer> 等所有List<具体类型实参>的父类。
     * @param data
     */
    public static void getData(List<?> data) {
        System.out.println("data :" + data.get(0));
    }

    /**
     * 2、类型通配符上限通过形如List来定义，如此定义就是通配符泛型值接受Number及其下层子类类型。
     * @param data
     */
    public static void getUperNumber(List<? extends Number> data) {
        System.out.println("data :" + data.get(0));
    }
}
