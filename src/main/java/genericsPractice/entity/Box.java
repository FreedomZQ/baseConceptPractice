package genericsPractice.entity;

/**
 * Created by ZQ.
 * 泛型类
 * @date 2021/2/25$ 11:29$
 */
public class Box<T> {
        private T t;

        public void add(T t) {
            this.t = t;
        }

        public T get() {
            return t;
        }
}
