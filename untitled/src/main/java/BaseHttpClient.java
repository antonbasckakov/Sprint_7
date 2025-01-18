import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public abstract class BaseHttpClient {
    protected RequestSpecification baseRequestSpec = new RequestSpecBuilder()
            .setBaseUri(Pens.MAIN_PEN)
            .addHeader("Content-Type","application/json")
            .setRelaxedHTTPSValidation()
            .addFilter(new RequestLoggingFilter())
            .addFilter(new ResponseLoggingFilter())
            .addFilter(new ErrorLoggingFilter())
            .build();
    //    public Response courierCreate(String path, Object body){
//            return given()
//                    .spec(baseRequestSpec)
//                    .body(body)
//                    .post(path)
//                    .thenReturn();
//        }
//
//
//
//    public Response courierLogin(String path, Object body){
//        return given()
//                .spec(baseRequestSpec)
//                .body(body)
//                .post(path)
//                .thenReturn();
//}


}

