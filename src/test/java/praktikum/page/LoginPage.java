package praktikum.page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;

    private final By emailField = By.xpath("//input[@name='name' or @name='email']");
    private final By passwordField = By.xpath("//input[@name='Пароль' or @name='password']");
    private final By loginButton = By.xpath("//button[text()='Войти']");
    private final By loginLinkFromRegisterPage = By.linkText("Войти");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Логин с email: {email}")
    public void login(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    @Step("Переход по ссылке 'Войти' со страницы регистрации")
    public void clickLoginLinkFromRegisterPage() {
        driver.findElement(loginLinkFromRegisterPage).click();
    }
}
