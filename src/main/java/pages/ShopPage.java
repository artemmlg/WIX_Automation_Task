package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShopPage extends BasePage {
    public ShopPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = ".//*[@id='TPASection_jh9acbfxiframe']")
    private WebElement shopFrame;

    @FindBy(xpath = ".//*[@id='comp-jh9acbuwiframe']")
    private WebElement cartWidgetFrame;

    @FindBy(xpath = ".//*[@id='cart-widget-button']")
    private WebElement cartWidgetBtn;

    @FindBy(xpath = ".//*[@class='product-details']//h3")
    private List<WebElement> shopItems;

    private WebElement getItemByVisibleText(String itemVisibleText) {
        return shopItems.stream().filter(webElement -> webElement.getText().equals(itemVisibleText)).findAny().orElse(null);
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

    public ShopPage switchIntoCartWidgetFrame() {
        switchFromFrameToDefaultContent();
        switchIntoFrame(cartWidgetFrame);
        return this;
    }

    public CartPopupPage clickOnCartWidgetButton() {
        click(cartWidgetBtn);
        return new CartPopupPage(driver);
    }
}
