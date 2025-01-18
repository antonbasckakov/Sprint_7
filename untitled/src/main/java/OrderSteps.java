import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class OrderSteps extends BaseHttpClient {
    @Step("Создание заказа")
    public ValidatableResponse orderCreate(String path, OrderCreateRequestPojo orderCreateRequestPojo){
        return given()
                .spec(baseRequestSpec)
                .body(orderCreateRequestPojo)
                .post(path)
                .then();
    }

    @Step("Получение списка заказов")
    public ValidatableResponse orderGet(String path){
        return given()
                .spec(baseRequestSpec)
                .get(path)
                .then();
    }
}
