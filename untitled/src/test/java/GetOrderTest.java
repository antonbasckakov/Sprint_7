import io.qameta.allure.junit4.DisplayName;
import jdk.jfr.Description;
import org.junit.Test;
import static org.hamcrest.Matchers.instanceOf;

public class GetOrderTest {

    @Test
    @DisplayName("Список заказа")
    @Description("Получение списка заказа")
    public void orderGetList() {

        OrderSteps orderSteps = new OrderSteps();
        orderSteps.orderGet(Pens.ORDER_LIST_GET_PEN)
                .assertThat().body("orders.id", instanceOf(Integer.class))
                .and()
                .statusCode(200);
    }
}
