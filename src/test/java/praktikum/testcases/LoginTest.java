package praktikum.testcases;

import org.junit.Test;
import praktikum.base.BaseTest;
import praktikum.page.ForgotPasswordPage;
import praktikum.page.LoginPage;
import praktikum.page.MainPage;
import praktikum.page.RegisterPage;

import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    public void loginFromMainPage() {
        new MainPage(driver).clickLoginButton();
        new LoginPage(driver).login("test@example.com", "123456");
        assertTrue("Кнопка 'Личный Кабинет' не отображается",
                new MainPage(driver).isAccountButtonDisplayed());
    }

    @Test
    public void loginFromAccountButton() {
        new MainPage(driver).clickAccountButton();
        new LoginPage(driver).login("test@example.com", "123456");
        assertTrue("Кнопка 'Личный Кабинет' не отображается",
                new MainPage(driver).isAccountButtonDisplayed());
    }

    @Test
    public void loginFromRegistrationPage() {
        driver.get("https://stellarburgers.nomoreparties.site/register");
        new RegisterPage(driver).clickLoginLink();
        new LoginPage(driver).login("test@example.com", "123456");
        assertTrue("Кнопка 'Личный Кабинет' не отображается",
                new MainPage(driver).isAccountButtonDisplayed());
    }

    @Test
    public void loginFromForgotPasswordPage() {
        driver.get("https://stellarburgers.nomoreparties.site/forgot-password");
        new ForgotPasswordPage(driver).clickLoginLink();
        new LoginPage(driver).login("test@example.com", "123456");
        assertTrue("Кнопка 'Личный Кабинет' не отображается",
                new MainPage(driver).isAccountButtonDisplayed());
    }
}
