package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPopupPage extends BasePage {
    public CartPopupPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = ".//*[@class='s_yOSHETPAPopupSkiniframe']")
    private WebElement cartPopupFrame;

    @FindBy(xpath = ".//a[@class='button-primary is-button-wide']")
    private WebElement viewCartBtn;

    @FindBy(xpath = ".//button[@class='remove-item']")
    private WebElement removeItemFromCartPopup;

    @FindBy(xpath = ".//button[@id='cart-widget-close']")
    private WebElement closeCartPopupButton;

    @FindBy(xpath = ".//*[@class='cart-content']//li")
    private List<WebElement> listOfItemsInCart;

    public CartPopupPage switchIntoCartPopupFrame() {
        switchIntoFrame(cartPopupFrame);
        return this;
    }

    public void clickViewCart() {
        click(viewCartBtn);
    }

    public CartPopupPage removeItemFromCartPopup(int itemNum) {
        moveToElementFromList(listOfItemsInCart, itemNum);
        click(removeItemFromCartPopup);
        return this;
    }

    public Object closePopup() {
        click(closeCartPopupButton);
        return driver.getPageSource().contains("ADD TO CART") ? new ProductPage(driver) : new ShopPage(driver);
    }
}
