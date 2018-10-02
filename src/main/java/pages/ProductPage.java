package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = ".//*[@id='TPAMultiSection_jh9acbtniframe']")
    private WebElement productFrame;

    @FindBy(xpath = ".//button[@type='submit']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//a[contains(text(), 'STORES')]")
    public WebElement storesButton;

    @FindBy(xpath = ".//*[@class='slick-list draggable']//img")
    private List<WebElement> productImages;

    public ProductPage switchIntoProductFrame() {
        switchFromFrameToDefaultContent();
        switchIntoFrame(productFrame);
        return this;
    }

    public CartPopupPage clickAddToCartButton() {
        click(addToCartButton);
        return new CartPopupPage(driver);
    }

    public ShopPage clickStoresButton() {
        click(storesButton);
        return new ShopPage(driver);
    }
}
