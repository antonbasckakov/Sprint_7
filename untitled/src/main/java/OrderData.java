import org.apache.commons.lang3.RandomStringUtils;

import java.util.List;

public class OrderData {
    public static String firstName = RandomStringUtils.randomAlphabetic(10);
    public static String lastName = RandomStringUtils.randomAlphabetic(10);
    public static String address = RandomStringUtils.randomAlphabetic(10);
    public static int metroStation  = Integer.parseInt(RandomStringUtils.randomNumeric(3));
    public static String phone = "+7" + " " + RandomStringUtils.randomNumeric(3) + " " + RandomStringUtils.randomNumeric(3) + " " + RandomStringUtils.randomNumeric(2) + " " + RandomStringUtils.randomNumeric(2);
    public static int rentTime = Integer.parseInt(RandomStringUtils.randomNumeric(3));
    public static String deliveryDate = "2025-01-14";
    public static String comment = RandomStringUtils.randomAlphabetic(10);

}
