import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @Description predicate函数式接口示例
 * @Author hq
 * @Date 2022/7/26 10:35
 * @Version 1.0
 */
public class PredicateTest {

    public static void main(String[] args) {
        List<String> paramList = Arrays.asList("zhangsan", "lisi", "wangwu", "hq");
        List<String> resultList = filterString(paramList, s -> s.length() >= 5);
        System.out.println(resultList);
    }
    public static List<String> filterString(List<String> list, Predicate<String> predicate){
        List<String> dataList = new ArrayList<>();
        for (String s : list) {
            if (predicate.test(s)){
                dataList.add(s);
            }
        }
        return dataList;
    }
}
