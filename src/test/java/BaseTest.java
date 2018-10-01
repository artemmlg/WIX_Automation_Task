import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.WebDriverFactory;

public abstract class BaseTest {
    protected WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = WebDriverFactory.setWebDriver();
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        if (driver != null) {
            driver.quit();
        }
    }
}
