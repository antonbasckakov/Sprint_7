import com.github.javafaker.Address;
import com.github.javafaker.DateAndTime;
import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.List;

public class OrderData {
    static Faker faker = new Faker();
    public static String firstName = faker.name().firstName();
    public static String lastName = faker.name().lastName();
    public static String address = faker.address().streetAddress();
    public static int metroStation  = Integer.parseInt(RandomStringUtils.randomNumeric(2));
    public static String phone = faker.phoneNumber().phoneNumber();
    public static int rentTime = Integer.parseInt(RandomStringUtils.randomNumeric(3));
    public static String deliveryDate = "01-01-2025";
    public static String comment = RandomStringUtils.randomAlphabetic(10);

}
