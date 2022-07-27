import java.util.function.Consumer;

/**
 * @Description Consumer函数式接口示例
 * @Author hq
 * @Date 2022/7/26 10:28
 * @Version 1.0
 */
public class ConsumerTest {

    public static void main(String[] args) {
        handlerConsumer(10000,i -> System.out.println(i));
    }

    public static void handlerConsumer(Integer number, Consumer<Integer> consumer){
        consumer.accept(number);
    }
}
