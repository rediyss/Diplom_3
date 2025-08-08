package praktikum.testcases;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import praktikum.base.BaseTest;
import praktikum.base.BaseURL;
import praktikum.page.ForgotPasswordPage;
import praktikum.page.LoginPage;
import praktikum.page.MainPage;
import praktikum.page.RegisterPage;
import Steps.UserSteps;

import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseTest {

    private final UserSteps userSteps = new UserSteps();
    private String email;
    private final String password = "123456";
    private String accessToken;

    @Before
    public void setUpUser() {
        email = userSteps.generateRandomEmail();
        userSteps.registerUser(email, password, "TestUser");
        accessToken = userSteps.getAccessToken(email, password);
    }

    @After
    public void tearDownUser() {
        if (accessToken != null) {
            userSteps.deleteUser(accessToken);
        }
    }

    @Test
    @DisplayName("Вход через кнопку «Войти в аккаунт» на главной")
    @Description("Проверка входа в систему через кнопку 'Войти в аккаунт' на главной странице сайта")
    public void loginFromMainPage() {
        new MainPage(driver).clickLoginButton();
        new LoginPage(driver).login(email, password);
        assertTrue("Кнопка 'Личный Кабинет' не отображается",
                new MainPage(driver).isAccountButtonDisplayed());
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    @Description("Проверка входа через кнопку 'Личный кабинет' на главной странице")
    public void loginFromAccountButton() {
        new MainPage(driver).clickAccountButton();
        new LoginPage(driver).login(email, password);
        assertTrue("Кнопка 'Личный Кабинет' не отображается",
                new MainPage(driver).isAccountButtonDisplayed());
    }

    @Test
    @DisplayName("Вход через форму регистрации")
    @Description("Проверка перехода со страницы регистрации по ссылке 'Войти' и успешного логина")
    public void loginFromRegistrationPage() {
        driver.get(BaseURL.REGISTER_PAGE);
        new RegisterPage(driver).clickLoginLink();
        new LoginPage(driver).login(email, password);
        assertTrue("Кнопка 'Личный Кабинет' не отображается",
                new MainPage(driver).isAccountButtonDisplayed());
    }

    @Test
    @DisplayName("Вход через форму восстановления пароля")
    @Description("Проверка логина через ссылку 'Войти' на странице восстановления пароля")
    public void loginFromForgotPasswordPage() {
        driver.get(BaseURL.FORGOT_PASSWORD_PAGE);
        new ForgotPasswordPage(driver).clickLoginLink();
        new LoginPage(driver).login(email, password);
        assertTrue("Кнопка 'Личный Кабинет' не отображается",
                new MainPage(driver).isAccountButtonDisplayed());
    }
}
