import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntConsumer;

/**
 * @Description
 *        三种使用方式：
 *                  类::静态方法
 *                  类::实例方法
 *                  对象::实例方法
 *      注意：引用的方法与函数式接口的抽象方法的入参数据类型与参数个数要一致
 * @Author hq
 * @Date 2022/7/26 13:42
 * @Version 1.0
 */
public class MethodReferenceTest {

    public static void main(String[] args) {

        //方法引用
        handleString("Hello Method Reference", System.out::println);
        //== 等价于 注意：引用的方法与函数式接口的抽象方法的入参数据类型与参数个数要一致
        handleString("Hello Method Reference", s -> System.out.println(s));

        //========================分隔符===============================
        System.out.println(getSum(3, 2, (x, y) -> Math.pow(x, y)));
        //== 等价于 注意：引用的方法与函数式接口的抽象方法的入参数据类型与参数个数要一致
        System.out.println(getSum(3, 2,  Math::pow));

        //构造器引用 注意：构造器是否有无参数、参数个数、参数数据类型
        Function<String, MyClass> classFunction = MyClass::new;

        //数组引用
        Function<Integer,Integer[]> array = Integer[]::new;

    }
    public static  void handleString(String str, Consumer<String> consumer){
        consumer.accept(str);
    }

    public static Double getSum(double x,double y,BinaryOperator<Double> binaryOperator){
         return binaryOperator.apply(x, y);
    }
}
class MyClass{

    private String name;

    public MyClass(String name){
        this.name = name;
    }
}