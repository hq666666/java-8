import java.util.Optional;

/**
 * @Description TODO
 * @Author hq
 * @Date 2022/7/26 20:13
 * @Version 1.0
 */
public class OptionalTest {

    public static void main(String[] args) {
        //空对象
        Optional<Object> empty = Optional.empty();
        // of 方法
        String name = "hq";
        Optional<String> opt = Optional.of(name);
        //ofNullable 如果为空值，则返回Optional.empty()空对象
        Optional<String> opt2 = Optional.ofNullable(name);
        //isPresent 检查optional对象中是否有值，值非空返回true
        boolean present = opt.isPresent();
        //orElse/orElseGet/orElseThrow 检查optional 对象的值是否为空，是返回 默认值/函数接口/异常
        String name2 = opt.orElse("hq2");
        //get 获取Optional对象的具体值
        String name3 = opt.get();
        //filter、map、flatmap 与 stream类似
    }
}
