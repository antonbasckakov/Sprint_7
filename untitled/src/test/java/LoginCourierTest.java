import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import jdk.jfr.Description;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;

public class LoginCourierTest {
    @Test
    @DisplayName("Авторизация ")
    @Description("Курьер авторизуется успешно")
    public void loginCourier() {

        CourierCreateRequestPojo courierCreateRequestPojo =
                new CourierCreateRequestPojo(CourierData.login,CourierData.password, CourierData.firstName);
        CourierLoginRequestPojo courierLoginRequestPojo =
                new CourierLoginRequestPojo(CourierData.login,CourierData.password);
        CourierSteps courierSteps = new CourierSteps();

        courierSteps.courierCreate(Pens.COURIER_CREATE_POST_PEN,courierCreateRequestPojo);
        courierSteps.courierLogin(Pens.COURIER_LOGIN_POST_PEN,courierLoginRequestPojo)
                .assertThat().body("id", instanceOf(Integer.class))
                .and()
                .statusCode(200);
    }
    @Test
    @DisplayName("Авторизация без пароля")
    @Description("Ошибка при авторизации без пароля")
    public void loginCourierWithoutPassword() {

        CourierCreateRequestPojo courierCreateRequestPojo =
                new CourierCreateRequestPojo(CourierData.login,CourierData.password, CourierData.firstName);
        CourierLoginRequestPojo courierLoginRequestPojo =
                new CourierLoginRequestPojo(CourierData.login,"");
        CourierSteps courierSteps = new CourierSteps();

        courierSteps.courierCreate(Pens.COURIER_CREATE_POST_PEN,courierCreateRequestPojo);
       courierSteps.courierLogin(Pens.COURIER_LOGIN_POST_PEN, courierLoginRequestPojo)
                .assertThat().body("message", equalTo("Недостаточно данных для входа"))
                .and()
                .statusCode(400);
    }
    @Test
    @DisplayName("Авторизация без Логина")
    @Description("Ошибка при авторизации без Логина")
    public void loginCourierWithoutLogin() {

        CourierCreateRequestPojo courierCreateRequestPojo =
                new CourierCreateRequestPojo(CourierData.login,CourierData.password, CourierData.firstName);
        CourierLoginRequestPojo courierLoginRequestPojo =
                new CourierLoginRequestPojo("",CourierData.password);
        CourierSteps courierSteps = new CourierSteps();

        courierSteps.courierCreate(Pens.COURIER_CREATE_POST_PEN,courierCreateRequestPojo);
        courierSteps.courierLogin(Pens.COURIER_LOGIN_POST_PEN, courierLoginRequestPojo)
                .assertThat().body("message", equalTo("Недостаточно данных для входа"))
                .and()
                .statusCode(400);
    }

    @Test
    @DisplayName("Авторизация c фейковыми даными")
    @Description("Ошибка при авторизации с фейковым логином и паролем")
    public void  nonExistentLoginAndPassword() {

        CourierLoginRequestPojo courierLoginRequestPojo =
                new CourierLoginRequestPojo(CourierData.login,CourierData.password);
        CourierSteps courierSteps = new CourierSteps();

        courierSteps.courierLogin(Pens.COURIER_LOGIN_POST_PEN, courierLoginRequestPojo)
                .assertThat().body("message", equalTo("Учетная запись не найдена"))
                .and()
                .statusCode(404);
    }
}
