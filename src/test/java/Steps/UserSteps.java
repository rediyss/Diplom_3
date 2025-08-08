package Steps;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static praktikum.base.BaseURL.BASE;

public class UserSteps {

    @Step("Регистрация пользователя {user.email}")
    public Response registerUser(UserDto user) {
        return given()
                .header("Content-type", "application/json")
                .body(user)
                .when()
                .post(BASE + "/api/auth/register");
    }

    @Step("Получение accessToken для пользователя {user.email}")
    public String getAccessToken(UserDto user) {
        Response response = given()
                .header("Content-type", "application/json")
                .body(user)
                .when()
                .post(BASE + "/api/auth/login");

        return response.then().extract().path("accessToken");
    }


    @Step("Удаление пользователя по accessToken")
    public Response deleteUser(String accessToken) {
        return given()
                .header("Authorization", accessToken)
                .when()
                .delete(BASE + "/api/auth/user");
    }

    @Step("Генерация случайного email для пользователя")
    public String generateRandomEmail() {
        return "autotest_" + System.currentTimeMillis() + "@yandex.ru";
    }
}
