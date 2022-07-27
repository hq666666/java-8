import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * @Description TODO
 * @Author hq
 * @Date 2022/7/27 13:30
 * @Version 1.0
 */
public class ZoneIdTest {

    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now(ZoneId.of("America/El_Salvador"));
        LocalDateTime now1 = LocalDateTime.now(ZoneId.of("Africa/Nairobi"));
        System.out.println(now);
        System.out.println(now1);
    }
}
