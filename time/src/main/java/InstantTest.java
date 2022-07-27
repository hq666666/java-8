import java.time.Instant;
import java.time.ZoneOffset;

/**
 * @Description 时间戳
 * @Author hq
 * @Date 2022/7/27 10:40
 * @Version 1.0
 */
public class InstantTest {

    public static void main(String[] args) {
        Instant now = Instant.now();
        System.out.println(now);//默认获取UTC时区
        System.out.println(now.atOffset(ZoneOffset.ofHours(8)));//偏移量计算
        System.out.println(now.toEpochMilli());
        System.out.println(Instant.ofEpochMilli(60));//以Unix元年为起点，进行偏移量运算
    }
}
