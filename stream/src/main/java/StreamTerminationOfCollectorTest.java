import model.Employee;

import java.util.DoubleSummaryStatistics;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;

/**
 * @Description
 *               Stream 终止操作：
 *                           收集
 * @Author hq
 * @Date 2022/7/26 19:02
 * @Version 1.0
 */
public class StreamTerminationOfCollectorTest {


    public static void main(String[] args) {
        // 最大值
        Double maxSalary = StreamFilterAndSliceTest.list.stream().map(Employee::getSalary).collect(Collectors.maxBy(Double::compare)).get();
        //最小值
        Employee employee = StreamFilterAndSliceTest.list.stream().collect(Collectors.minBy((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))).get();
         //汇总
        Double sum = StreamFilterAndSliceTest.list.stream().collect(Collectors.summingDouble(Employee::getSalary));
         //平均值
        Double avg = StreamFilterAndSliceTest.list.stream().collect(Collectors.averagingDouble(Employee::getSalary));
        //个数
        Long count = StreamFilterAndSliceTest.list.stream().collect(Collectors.counting());
        //统计
        DoubleSummaryStatistics collect = StreamFilterAndSliceTest.list.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        //分组,映射
        Map<Integer, String> map = StreamFilterAndSliceTest.list.stream().collect(Collectors.groupingBy(Employee::getAge, Collectors.mapping(Employee::getName, Collectors.joining(","))));

        System.out.println(collect.getMax());
    }
}
