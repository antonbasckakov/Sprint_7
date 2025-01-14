import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class CourierSteps extends BaseHttpClient {

    @Step("Создание курьера")
    public ValidatableResponse courierCreate(String path,  CourierCreateRequestPojo courierCreateRequestPojo){
        return given()
                .spec(baseRequestSpec)
                .body(courierCreateRequestPojo)
                .post(path)
                .then();
    }

    @Step("Логин курьера")
    public ValidatableResponse courierLogin(String path,  CourierLoginRequestPojo courierLoginRequestPojo){
        return given()
                .spec(baseRequestSpec)
                .body(courierLoginRequestPojo)
                .post(path)
                .then();
    }
}
