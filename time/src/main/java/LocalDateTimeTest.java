import java.time.LocalDateTime;

/**
 * @Description 本地时间
 * @Author hq
 * @Date 2022/7/27 10:35
 * @Version 1.0
 */
public class LocalDateTimeTest {

    public static void main(String[] args) {

        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        System.out.println(LocalDateTime.of(2019, 10, 27, 13, 45, 10));
        System.out.println(now.plusYears(3).minusMonths(3));
        System.out.println(now.getYear());
        System.out.println(now.getMonthValue());
        System.out.println(now.getDayOfWeek());
        System.out.println(now.getHour());
        System.out.println(now.getMinute());
        System.out.println(now.getSecond());
        System.out.println(now.withDayOfMonth(10));
    }
}
