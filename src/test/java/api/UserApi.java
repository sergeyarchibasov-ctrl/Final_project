package api;

import io.restassured.http.ContentType;
import model.User;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class UserApi {

    private static final String BASE_URL =
            "https://qa-desk.education-services.ru";

    public void createUser(User user) {
        Map<String, String> body = new HashMap<>();
        body.put("email", user.getEmail());
        body.put("password", user.getPassword());
        body.put("submitPassword", user.getPassword());

        given()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("/api/signup")
                .then()
                .statusCode(201);
    }
}