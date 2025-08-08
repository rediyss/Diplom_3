package praktikum.page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private final WebDriver driver;

    private final By bunTab = By.xpath("//span[text()='Булки']/..");
    private final By sauceTab = By.xpath("//span[text()='Соусы']/..");
    private final By fillingTab = By.xpath("//span[text()='Начинки']/..");
    private final By loginButton = By.xpath("//button[text()='Войти в аккаунт']");
    private final By accountButton = By.xpath("//p[text()='Личный Кабинет']");
    private final By placeOrderButton = By.xpath("//button[text()='Оформить заказ']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Кликаем по вкладке: {tab}")
    private void clickTab(By tab) {
        WebElement element = driver.findElement(tab);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    @Step("Кликаем по вкладке 'Булки'")
    public void clickBunTab() {
        clickTab(bunTab);
    }

    @Step("Кликаем по вкладке 'Соусы'")
    public void clickSauceTab() {
        clickTab(sauceTab);
    }

    @Step("Кликаем по вкладке 'Начинки'")
    public void clickFillingTab() {
        clickTab(fillingTab);
    }

    @Step("Проверяем, что вкладка 'Булки' активна")
    public boolean isBunTabActive() {
        return driver.findElement(bunTab).getAttribute("class").contains("current");
    }

    @Step("Проверяем, что вкладка 'Соусы' активна")
    public boolean isSauceTabActive() {
        return driver.findElement(sauceTab).getAttribute("class").contains("current");
    }

    @Step("Проверяем, что вкладка 'Начинки' активна")
    public boolean isFillingTabActive() {
        return driver.findElement(fillingTab).getAttribute("class").contains("current");
    }

    @Step("Нажимаем кнопку 'Войти в аккаунт'")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    @Step("Нажимаем кнопку 'Личный кабинет'")
    public void clickAccountButton() {
        driver.findElement(accountButton).click();
    }

    @Step("Проверяем отображение кнопки 'Личный кабинет'")
    public boolean isAccountButtonDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(accountButton));
        return driver.findElement(accountButton).isDisplayed();
    }
}
