import io.qameta.allure.Step;
import io.restassured.response.Response;
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
    public Response courierLogin(String path, CourierLoginRequestPojo courierLoginRequestPojo){
        return (Response) given()
                .spec(baseRequestSpec)
                .body(courierLoginRequestPojo)
                .post(path)
                .thenReturn();
    }
    @Step("Удалить курьера")
    public void courierDelete(Integer courierId) {
                given()
                .spec(baseRequestSpec)
                .delete(Pens.COURIER_REMOVAL_DELETE_PEN + courierId);

    }


}
