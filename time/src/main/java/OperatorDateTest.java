import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

/**
 * @Description 日期操纵
 * @Author hq
 * @Date 2022/7/27 12:51
 * @Version 1.0
 */
public class OperatorDateTest {

    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        //获取当前月的第一天
        System.out.println(now.with(TemporalAdjusters.firstDayOfMonth()));
        //将日期调整到下个周日
        System.out.println(now.with(now.with(TemporalAdjusters.next(DayOfWeek.SUNDAY))));
        //自定义： 工作日
        System.out.println(now.with(l -> {
            LocalDateTime localDateTime = (LocalDateTime) l;
            DayOfWeek dayOfWeek = localDateTime.getDayOfWeek();
            if (dayOfWeek.equals(DayOfWeek.FRIDAY)) {
                return localDateTime.plusDays(3);
            } else if (dayOfWeek.equals(DayOfWeek.SATURDAY)) {
                return localDateTime.plusDays(2);
            } else {
                return localDateTime.plusDays(1);
            }
        }));
    }
}
