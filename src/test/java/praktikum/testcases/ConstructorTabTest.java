package praktikum.testcases;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import praktikum.base.BaseTest;
import praktikum.page.MainPage;

import static org.junit.Assert.assertTrue;

public class ConstructorTabTest extends BaseTest {

    @Test
    @DisplayName("Переключение на вкладку 'Булки'")
    @Description("Проверка, что пользователь может переключиться на вкладку 'Булки' и она становится активной")
    public void testUserCanSwitchToBunsTab() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickBunTab();
        assertTrue("Булки не активны", mainPage.isBunTabActive());
    }

    @Test
    @DisplayName("Переключение на вкладку 'Соусы'")
    @Description("Проверка, что пользователь может переключиться на вкладку 'Соусы' и она становится активной")
    public void testUserCanSwitchToSaucesTab() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSauceTab();
        assertTrue("Соусы не активны", mainPage.isSauceTabActive());
    }

    @Test
    @DisplayName("Переключение на вкладку 'Начинки'")
    @Description("Проверка, что пользователь может переключиться на вкладку 'Начинки' и она становится активной")
    public void testUserCanSwitchToFillingsTab() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickFillingTab();
        assertTrue("Начинки не активны", mainPage.isFillingTabActive());
    }
}
