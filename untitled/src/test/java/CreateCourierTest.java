import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import jdk.jfr.Description;;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.equalTo;


public class CreateCourierTest   {
        @Test
        @DisplayName("Создание нового курьера")
        @Description("Курьера можно создать")
        public void createCourier() {
            CourierCreateRequestPojo courierCreateRequestPojo =
                    new CourierCreateRequestPojo(CourierData.login,CourierData.password, CourierData.firstName);
            CourierSteps courierSteps = new CourierSteps();
            CourierLoginRequestPojo courierLoginRequestPojo =
                    new CourierLoginRequestPojo(CourierData.login,CourierData.password);
            courierSteps.courierCreate(Pens.COURIER_CREATE_POST_PEN,courierCreateRequestPojo)
                    .assertThat().body("ok", equalTo(true))
                    .and()
                    .statusCode(201);
            Response response = courierSteps.courierLogin(Pens.COURIER_LOGIN_POST_PEN,courierLoginRequestPojo);
            Integer id = response.getBody().jsonPath().get("id");
            courierSteps.courierDelete(id);

        }

    @Test
    @DisplayName("Дублирование курьера курьера")
    @Description("Ошибка при создании дубля курьера")
    public void dublicateCourier() {
        CourierCreateRequestPojo courierCreateRequestPojo =
                new CourierCreateRequestPojo(CourierData.login,CourierData.password, CourierData.firstName);
        CourierLoginRequestPojo courierLoginRequestPojo =
                new CourierLoginRequestPojo(CourierData.login,CourierData.password);
        CourierSteps courierSteps = new CourierSteps();
        courierSteps.courierCreate(Pens.COURIER_CREATE_POST_PEN,courierCreateRequestPojo);
        courierSteps.courierCreate(Pens.COURIER_CREATE_POST_PEN,courierCreateRequestPojo)
                .assertThat().body("message", equalTo("Этот логин уже используется. Попробуйте другой."))
                .and()
                .statusCode(409);
        Response response = courierSteps.courierLogin(Pens.COURIER_LOGIN_POST_PEN,courierLoginRequestPojo);
        Integer id = response.getBody().jsonPath().get("id");
        courierSteps.courierDelete(id);
    }

    @Test
    @DisplayName("Создание курьера без логина")
    @Description("Ошибка при cоздании курьера без логина")
    public void createCourierWithoutLogin() {
        CourierCreateRequestPojo courierCreateRequestPojo =
                new CourierCreateRequestPojo(null,CourierData.password, CourierData.firstName);

        CourierSteps courierSteps = new CourierSteps();
        courierSteps.courierCreate(Pens.COURIER_CREATE_POST_PEN,courierCreateRequestPojo)
                .assertThat().body("message", equalTo("Недостаточно данных для создания учетной записи"))
                .and()
                .statusCode(400);

    }

    @Test
    @DisplayName("Создание курьера без пароля")
    @Description("Ошибка при cоздании курьера без пароля")
    public void createCourierWithoutPassword() {
        CourierCreateRequestPojo courierCreateRequestPojo =
                new CourierCreateRequestPojo(CourierData.login,null, CourierData.firstName);
        CourierSteps courierSteps = new CourierSteps();
        courierSteps.courierCreate(Pens.COURIER_CREATE_POST_PEN,courierCreateRequestPojo)
                .assertThat().body("message", equalTo("Недостаточно данных для создания учетной записи"))
                .and()
                .statusCode(400);
    }

}
