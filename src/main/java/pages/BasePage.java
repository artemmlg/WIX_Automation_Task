package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    private static final long EXPLICIT_WAIT = 5;
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected WebElement getWebElement(By by) {
        return driver.findElement(by);
    }

    public void click(WebElement webElement) {
        webElement.click();
    }

    public void click(By by) {
        WebElement element = getWebElement(by);
        element.click();
    }

    public void openBaseURL() {
        driver.get("https://georgel8.wixsite.com/ait-ht");
    }

    /**
     * Explicitly/Implicitly waits.
     */

    public void waitForElementDisplayed(final WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_WAIT);
        wait.until(result -> webElement.isDisplayed());
    }

    public void waitForElementDisplayed(final By locator) {
        WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_WAIT);
        wait.until(result -> getWebElement(locator).isDisplayed());
    }

    /**
     * Frame methods.
     */

    public void switchFromFrameToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    public void switchParentFrame() {
        driver.switchTo().parentFrame();
    }

    public void switchIntoFrame(WebElement frameElement) {
        waitForElementDisplayed(frameElement);
        driver.switchTo().frame(frameElement);
    }

    public void switchToFrameActiveElement() {
        driver.switchTo().activeElement();
    }

    public void switchIntoFrame(String frameName) {
        WebElement element = getWebElement(By.id(frameName));
        driver.switchTo().frame(element);
    }


}
