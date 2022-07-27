import model.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description
 *                  Stream 中间操作：映射
 * @Author hq
 * @Date 2022/7/26 16:41
 * @Version 1.0
 */
public class StreamMappingAndSortedTest {

    private static List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd");

    public static void main(String[] args) {
        //map()
        list.stream().map(e -> e.toUpperCase()).forEach(System.out::println);
        System.out.println("================分割线====================");
       //flatMap()
       list.stream().flatMap(StreamMappingAndSortedTest::filterCharcter).forEach(System.out::println);
       //== 等价于
        System.out.println("================分割线====================");
        list.stream().map(StreamMappingAndSortedTest::filterCharcter).forEach(e -> e.forEach(System.out::println));
        /**
         * 其实Map方法相当于 Collection 的 add 方法，如果 add 的是个集合就会变成二维数组，而flatMap 的话就相当于 Collection 的 addAll 方法，
         * 参数如果是集合，只是将2个集合合并，而不是变成二维数组
         */
        System.out.println("================分割线====================");
        //自然排序
        List<Employee> collect = StreamFilterAndSliceTest.list.stream().collect(Collectors.toList());
        System.out.println("================分割线====================");
        //定制排查
        List<Employee> collect1 = StreamFilterAndSliceTest.list.stream().sorted((e1,e2) -> Integer.compare(e1.getAge(),e2.getAge())).collect(Collectors.toList());
        System.out.println("end!");
    }

    public static Stream<Character> filterCharcter(String str){
        List<Character> dataList =new ArrayList<>();
        for (Character c : str.toCharArray()) {
            dataList.add(c);
        }
        return dataList.stream();
    }
}
