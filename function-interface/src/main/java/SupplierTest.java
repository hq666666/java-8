import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

/**
 * @Description supplier函数式接口示例
 * @Author hq
 * @Date 2022/7/26 10:30
 * @Version 1.0
 */
public class SupplierTest {

    public static void main(String[] args) {
        List<Integer> nubmerList = getNubmerList(100, () -> new Random().nextInt(100));
        System.out.println(nubmerList);
    }

    public static List<Integer>  getNubmerList(int num, Supplier<Integer> supplier) {
        List<Integer> dataList = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            dataList.add(supplier.get());
        }
        return dataList;
    }
}
