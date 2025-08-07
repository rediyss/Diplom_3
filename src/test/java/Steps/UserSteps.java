package Steps;


import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserSteps {

    private final String baseUrl = "https://stellarburgers.nomoreparties.site";

    public Response registerUser(String email, String password, String name) {
        return given()
                .header("Content-type", "application/json")
                .body(String.format("{\"email\":\"%s\",\"password\":\"%s\",\"name\":\"%s\"}", email, password, name))
                .when()
                .post(baseUrl + "/api/auth/register");
    }

    public String getAccessToken(String email, String password) {
        Response response = given()
                .header("Content-type", "application/json")
                .body(String.format("{\"email\":\"%s\",\"password\":\"%s\"}", email, password))
                .when()
                .post(baseUrl + "/api/auth/login");

        return response.then().extract().path("accessToken");
    }

    public void deleteUser(String accessToken) {
        given()
                .header("Authorization", accessToken)
                .when()
                .delete(baseUrl + "/api/auth/user")
                .then()
                .statusCode(202); // может быть 200 или 202 в зависимости от API
    }

    public String generateRandomEmail() {
        return "autotest_" + System.currentTimeMillis() + "@yandex.ru";
    }
}
