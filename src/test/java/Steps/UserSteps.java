package Steps;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static praktikum.base.BaseURL.BASE;

public class UserSteps {

    @Step("Регистрация пользователя с email: {email}, именем: {name}")
    public Response registerUser(String email, String password, String name) {
        return given()
                .header("Content-type", "application/json")
                .body(String.format("{\"email\":\"%s\",\"password\":\"%s\",\"name\":\"%s\"}", email, password, name))
                .when()
                .post(BASE + "/api/auth/register");
    }

    @Step("Получение accessToken для email: {email}")
    public String getAccessToken(String email, String password) {
        Response response = given()
                .header("Content-type", "application/json")
                .body(String.format("{\"email\":\"%s\",\"password\":\"%s\"}", email, password))
                .when()
                .post(BASE + "/api/auth/login");

        return response.then().extract().path("accessToken");
    }

    @Step("Удаление пользователя по accessToken")
    public void deleteUser(String accessToken) {
        given()
                .header("Authorization", accessToken)
                .when()
                .delete(BASE + "/api/auth/user")
                .then()
                .statusCode(202); // может быть 200 или 202 в зависимости от API
    }

    @Step("Генерация случайного email для пользователя")
    public String generateRandomEmail() {
        return "autotest_" + System.currentTimeMillis() + "@yandex.ru";
    }
}
