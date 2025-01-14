import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import jdk.jfr.Description;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class CreateCourierTest  {

    CourierApi courierApi = new CourierApi();

        @Test
        @DisplayName("Создание нового курьера")
        @Description("Курьера можно создать")
        public void createCourier() {
            CourierCreateRequestPojo courierCreateRequestPojo =
                    new CourierCreateRequestPojo(CourierData.login,CourierData.password, CourierData.firstName);
            CourierSteps courierSteps = new CourierSteps();
            courierSteps.courierCreate(Pens.COURIER_CREATE_POST_PEN,courierCreateRequestPojo)
                    .assertThat().body("ok", equalTo(true))
                    .and()
                    .statusCode(201);
        }

    @Test
    @DisplayName("Дублирование курьера курьера")
    @Description("Ошибка при создании дубля курьера")
    public void dublicateCourier() {
        CourierCreateRequestPojo courierCreateRequestPojo =
                new CourierCreateRequestPojo(CourierData.login,CourierData.password, CourierData.firstName);
        CourierSteps courierSteps = new CourierSteps();
        courierSteps.courierCreate(Pens.COURIER_CREATE_POST_PEN,courierCreateRequestPojo);
        courierSteps.courierCreate(Pens.COURIER_CREATE_POST_PEN,courierCreateRequestPojo)
                .assertThat().body("message", equalTo("Этот логин уже используется. Попробуйте другой."))
                .and()
                .statusCode(409);
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


//    public void asert(){


//            final String login = RandomStringUtils.randomAlphabetic(10);
//            final String password = RandomStringUtils.randomAlphabetic(10);
//            final String firstName = RandomStringUtils.randomAlphabetic(10);
//
//            CourierCreateRequestPojo expectedCourierCreateRequestPojo =
//                    new CourierCreateRequestPojo(login,password,firstName);
//             courierApi.courierCreate(expectedCourierCreateRequestPojo);


//            assertEquals(firstName,expectedCourierCreateRequestPojo.getFirstName());

//        }

        // STEPS





}
