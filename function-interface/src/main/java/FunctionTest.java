import java.util.function.Function;

/**
 * @Description Function函数式接口示例
 * @Author hq
 * @Date 2022/7/26 10:33
 * @Version 1.0
 */
public class FunctionTest {

    public static void main(String[] args) {
        String str = handlerString("hq", s -> s.toUpperCase());
        System.out.println(str);
    }
    public static String handlerString(String str, Function<String, String> func){
        return func.apply(str);
    }
}
