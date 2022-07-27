import model.Employee;

import java.util.Arrays;
import java.util.List;

/**
 * @Description
 *              Stream 终止操作：
 *                      规约，将流中元素进行规约，最终得到一个值
 * @Author hq
 * @Date 2022/7/26 18:47
 * @Version 1.0
 */
public class StreamTerminationOfReduceTest {

    public static List<Integer> numberList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

    public static void main(String[] args) {

        Integer numberSum = numberList.stream().reduce(0, (x, y) -> x + y);
        System.out.println("数字总数:" + numberSum);
        Double salarySum = StreamFilterAndSliceTest.list.stream().map(Employee::getSalary).reduce(Double::sum).get();
        System.out.println("工资总数:" + salarySum);
        //需求：搜索list中"李"出现的次数
        Integer count = StreamFilterAndSliceTest.list.stream()
                .map(Employee::getName)
                .flatMap(StreamMappingAndSortedTest::filterCharcter)
                .map(character -> {
                    if (character.equals('李'))
                        return 1;
                    else
                        return 0;
                }).reduce(Integer::sum).orElse(0);
        System.out.println("员工姓名中李字出现的次数:" + count);
    }
}
