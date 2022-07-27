import model.EmployeeExtend;
import java.util.Arrays;
import java.util.List;

/**
 * @Description
 *                stream 终止操作：
 *                         查找与匹配
 * @Author hq
 * @Date 2022/7/26 18:21
 * @Version 1.0
 */
public class StreamTerminationOfFindTest {

    public static List<EmployeeExtend> dataList = Arrays.asList(
            new EmployeeExtend("张三", 18, 9999.99, EmployeeExtend.Status.SLEEPING),
            new EmployeeExtend("李四", 38, 5555.55, EmployeeExtend.Status.WORKING),
            new EmployeeExtend("王五", 60, 6666.66, EmployeeExtend.Status.WORKING),
            new EmployeeExtend("赵六", 8, 7777.77, EmployeeExtend.Status.SLEEPING),
            new EmployeeExtend("田七", 58, 3333.33, EmployeeExtend.Status.VOCATION)
    );
    public static void main(String[] args) {
        /**
         * 匹配三种方法：
         *       allMatch、anyMatch、noneMatch
         */
        boolean flag = dataList.stream().allMatch(e -> EmployeeExtend.Status.SLEEPING.equals(e.getStatus()));
        System.out.println(flag);
        boolean flag2 = dataList.stream().anyMatch(e -> EmployeeExtend.Status.SLEEPING.equals(e.getStatus()));
        System.out.println(flag2);
        boolean flag3 = dataList.stream().noneMatch(e -> EmployeeExtend.Status.SLEEPING.equals(e.getStatus()));
        System.out.println(flag3);
        /**
         *  查找
         */
        //findFirst：查找第一位
        System.out.println(dataList.stream().sorted((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())).findFirst().orElse(new EmployeeExtend()));
        //findAny:随机获取一位
        System.out.println(dataList.stream().filter(e -> EmployeeExtend.Status.WORKING.equals(e.getStatus())).findAny().orElse(new EmployeeExtend()));
        //count: 获取流中所有元素个数
        System.out.println(dataList.stream().count());
       //max: 获取流中最大值
        System.out.println(dataList.stream().max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())).orElse(new EmployeeExtend()));
        //min: 获取流中最小值
        System.out.println(dataList.stream().min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())).orElse(new EmployeeExtend()));
        //foreach：内部迭代
        dataList.stream().forEach(System.out::println);
    }
}

