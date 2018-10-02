package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShopPage extends BasePage {
    public ShopPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = ".//*[@id='TPASection_jh9acbfxiframe']")
    private WebElement shopFrame;

    private By getItemByVisibleText(String itemVisibleText) {
        return By.xpath(String.format(".//*[@class='product-details']//h3[contains(text(), '%s')]", itemVisibleText));
    }

    public ProductPage clickOnItemWithName(String itemName) {
        click(getItemByVisibleText(itemName));
        return new ProductPage(driver);
    }

    public ShopPage switchIntoShopFrame() {
        switchFromFrameToDefaultContent();
        switchIntoFrame(shopFrame);
        return this;
    }
}
