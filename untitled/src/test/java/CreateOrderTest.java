import io.qameta.allure.junit4.DisplayName;
import jdk.jfr.Description;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.notNullValue;

@RunWith(Parameterized.class)
public class CreateOrderTest {

    private List<String> color;
    public CreateOrderTest(List<String> color) {
        this.color = color;
    }
    @Parameterized.Parameters (name = "Цвет  - {0}")
    public static Object[][] dataGen() {
        return new Object[][] {
                {List.of("BLACK", "GREY")},
                {List.of("BLACK")},
                {List.of("GREY")},
                {List.of()}
        };
    }

    @Test
    @DisplayName("Создание заказа")
    @Description("Создание заказа BLACK или GREY цвета")

    public void createOrder() {
        OrderCreateRequestPojo orderCreateRequestPojo =
                new OrderCreateRequestPojo(OrderData.firstName,OrderData.lastName,OrderData.address,OrderData.metroStation,OrderData.phone,OrderData.rentTime,OrderData.deliveryDate,OrderData.comment,color) ;
        OrderSteps orderSteps = new OrderSteps();
        orderSteps.orderCreate(Pens.ORDER_CREATE_POST_PEN,orderCreateRequestPojo)
                .assertThat().body("track", instanceOf(Integer.class))
                .and()
                .statusCode(201);
    }


}
