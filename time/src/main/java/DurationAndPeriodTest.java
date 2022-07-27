import java.time.*;

/**
 * @Description TODO
 * @Author hq
 * @Date 2022/7/27 10:56
 * @Version 1.0
 */
public class DurationAndPeriodTest {

    public static void main(String[] args) {
        //duration :用于计算两个"时间"的间隔
        Instant now = Instant.now();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Instant now1 = Instant.now();
        Duration between = Duration.between(now, now1);
        System.out.println(between.toMillis());
        LocalDateTime now2 = LocalDateTime.now();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LocalDateTime now3 = LocalDateTime.now();
        System.out.println(Duration.between(now2,now3).toMillis());

        LocalDate localDate = LocalDate.of(2018, 7, 9);
        LocalDate localDate1 = LocalDate.now();
        Period between1 = Period.between(localDate, localDate1);
        System.out.println(between1.getYears());
        System.out.println(between1.getMonths());
        System.out.println(between1.getDays());

    }

}
