import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Description 创建流：有限流，无限流，空流
 * @Author hq
 * @Date 2022/7/26 16:06
 * @Version 1.0
 */
public class CreateStreamTest {
    public static void main(String[] args) {
        //集合
        List<String> list = Arrays.asList("a","b","c");
        //创建串行流
        list.stream().forEach(System.out::println);
        //创建并行流
        list.parallelStream().forEach(System.out::println);

        //数组
        Arrays.stream(new Integer[]{1,2,3}).forEach(System.out::println);
        //of方法
        Stream.of("a","b","c").forEach(System.out::println);
        //创建无限流
        Stream.iterate(0,x -> x+2).limit(10).forEach(System.out::println);
        //创建空流
        Stream.empty().forEach(System.out::println);
    }
}
