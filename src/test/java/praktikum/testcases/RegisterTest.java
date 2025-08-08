
package praktikum.testcases;

import org.junit.Test;
import praktikum.base.BaseTest;
import praktikum.base.BaseURL;
import praktikum.page.RegisterPage;

import static org.junit.Assert.assertTrue;

public class RegisterTest extends BaseTest {

    @Test
    public void successRegistration() {
        driver.get(BaseURL.REGISTER_PAGE);
        String email = "test" + System.currentTimeMillis() + "@example.com";
        new RegisterPage(driver).register("Test User", email, "123456");
    }

    @Test
    public void errorWhenShortPassword() {
        driver.get(BaseURL.REGISTER_PAGE);
        new RegisterPage(driver).register("Test User", "short@example.com", "123");
        assertTrue(new RegisterPage(driver).getErrorMessage().contains("Некорректный пароль"));
    }
}
