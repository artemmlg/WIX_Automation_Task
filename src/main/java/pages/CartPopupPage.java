package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    private By listOfItemsInCat = By.xpath(".//*[@class='cart-content']//li");

    public CartPopupPage switchIntoCartPopupFrame() {
        switchIntoFrame(cartPopupFrame);
        return this;
    }

    public void clickViewCart() {
        click(viewCartBtn);
    }

    public void removeItemFromCartPopup(int itemNum) {
        moveToElementFromList(listOfItemsInCat, itemNum);
        click(removeItemFromCartPopup);
    }

    public ProductPage closeCartPopupBackToProduct() {
        click(closeCartPopupButton);
        return new ProductPage(driver);
    }

    public ShopPage closeCartPopupBackToShop() {
        click(closeCartPopupButton);
        return new ShopPage(driver);
    }
}
