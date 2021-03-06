package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {
    private static final long EXPLICIT_WAIT = 5;
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void click(WebElement webElement) {
        waitForElementDisplayed(webElement);
        webElement.click();
    }

    /**
     * Explicitly/Implicitly waits.
     */

    public void waitForElementDisplayed(final WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_WAIT);
        wait.until(result -> webElement.isDisplayed());
    }

    public void waitForFrameDisplayed(final WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_WAIT);
        wait.until(result -> ExpectedConditions.frameToBeAvailableAndSwitchToIt(webElement));
    }

    /**
     * Frame methods.
     */

    public void switchFromFrameToDefaultContent() {
        //temporary solution, due to Cart Pop Up didn't shown without sleep
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().defaultContent();
    }

    public void switchIntoFrame(WebElement frameElement) {
        switchFromFrameToDefaultContent();
        waitForFrameDisplayed(frameElement);
        driver.switchTo().frame(frameElement);
    }

    /**
     * Actions.
     */

    public void moveToElementFromList(List<WebElement> elements, int num) {
        Actions actions = new Actions(driver);
        WebElement element = elements.get(num);
        actions.moveToElement(element).build().perform();
    }
}
