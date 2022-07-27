import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Description 日期解析与格式化
 * @Author hq
 * @Date 2022/7/27 13:25
 * @Version 1.0
 */
public class DateFormatAndParseTest {

    public static void main(String[] args) {
        DateTimeFormatter isoDate = DateTimeFormatter.ISO_DATE;
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now.format(isoDate));

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = dateTimeFormatter.format(now);
        System.out.println(format);

        System.out.println(LocalDateTime.parse(format, dateTimeFormatter));
    }
}
