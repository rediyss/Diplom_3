package praktikum.base;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import praktikum.driver.DriverHelper;
import static praktikum.base.BaseURL.BASE;

import java.io.IOException;

public class BaseTest {
    protected WebDriver driver;

    @Before
    public void setUp() throws IOException {
        DriverHelper driverHelper = new DriverHelper();
        driver = driverHelper.initDriver();
        driver.manage().window().maximize();
        driver.get(BaseURL.BASE);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
