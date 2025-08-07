package praktikum.testcases;

import org.junit.Test;
import praktikum.base.BaseTest;
import praktikum.page.MainPage;

import static org.junit.Assert.assertTrue;

public class ConstructorTabTest extends BaseTest {

    @Test
    public void testUserCanSwitchToBunsTab() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickBunTab();
        assertTrue("Булки не активны", mainPage.isBunTabActive());
    }

    @Test
    public void testUserCanSwitchToSaucesTab() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSauceTab();
        assertTrue("Соусы не активны", mainPage.isSauceTabActive());
    }

    @Test
    public void testUserCanSwitchToFillingsTab() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickFillingTab();
        assertTrue("Начинки не активны", mainPage.isFillingTabActive());
    }
}
