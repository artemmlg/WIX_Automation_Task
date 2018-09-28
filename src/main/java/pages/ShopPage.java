package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShopPage extends BasePage {
    public ShopPage(WebDriver driver) {
        super(driver);
    }

    private By getItemByVisibleText(String itemVisibleText){
        return By.xpath(String.format(".//*[@class='product-details']//h3[contains(text(), '%s')]", itemVisibleText));
    }

    public void clickOnItemWithName(String itemName){
        waitForElementDisplayed((WebElement) getItemByVisibleText(itemName));
        click(getItemByVisibleText(itemName));
    }
}
