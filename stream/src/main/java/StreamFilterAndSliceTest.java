import model.Employee;

import java.util.Arrays;
import java.util.List;

/**
 * @Description
 *               Stream 中间操作：筛选与切片
 * @Author hq
 * @Date 2022/7/26 16:15
 * @Version 1.0
 */
public class StreamFilterAndSliceTest {
    public static List<Employee> list = Arrays.asList(
            new Employee("张三", 18, 9999.99),
            new Employee("李四", 38, 5555.55),
            new Employee("王五", 60, 6666.66),
            new Employee("赵六", 8, 7777.77),
            new Employee("田七", 58, 3333.33),
            new Employee("李四", 38, 5555.55)
            );
    public static void main(String[] args) {
        //filter()
        list.stream().filter(e -> e.getAge() > 30).forEach(System.out::println);
        System.out.println("=================分割线====================");
        //limit()
        list.stream().filter(e -> e.getAge() > 30).limit(2).forEach(System.out::println);
        System.out.println("=================分割线====================");
        //skip
        list.stream().filter(e -> e.getAge() > 30).skip(2).forEach(System.out::println);
        System.out.println("=================分割线====================");
        //distinct() 需要实体中重写hashCode() 和 equals()方法才可以使用
        System.out.println(list.stream().filter(e -> e.getAge() > 30).distinct().count());
    }
}
