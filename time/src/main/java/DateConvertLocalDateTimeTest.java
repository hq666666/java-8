import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.TimeZone;

/**
 * @Description TODO
 * @Author hq
 * @Date 2022/7/27 13:32
 * @Version 1.0
 */
public class DateConvertLocalDateTimeTest {

    public static void main(String[] args) {
        //Date 与 Instant
        Date date = new Date();
        Instant instant = date.toInstant();
        System.out.println(instant);
        System.out.println(Date.from(instant));
        //timestamp 与 Instant
        Timestamp timestamp = new Timestamp(date.getTime());
        Instant instant1 = timestamp.toInstant();
        System.out.println(Timestamp.from(instant1));

        //
        LocalDate now = LocalDate.now();
        java.sql.Date date1 = java.sql.Date.valueOf(now);
        System.out.println(date1);
        System.out.println(date1.toLocalDate());

        //
        LocalDateTime now1 = LocalDateTime.now();
        Timestamp timestamp1 = Timestamp.valueOf(now1);
        System.out.println(timestamp1);
        System.out.println(timestamp1.toLocalDateTime());

        TimeZone timeZone = TimeZone.getTimeZone(ZoneId.of("Asia/Shanghai"));
        System.out.println(timeZone);
        System.out.println(timeZone.toZoneId().getId());
    }
}
