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
    private WebElement shopFrame;

    @FindBy(xpath = ".//button[@type='submit']")
    private WebElement addToCartButton;

    @FindBy(xpath = ".//*[@class='slick-list draggable']//img")
    private List<WebElement> productImages;

    public void switchIntoProductFrame() {
        switchIntoFrame(shopFrame);
    }

    public CartPopupPage clickAddToCartButton() {
        click(addToCartButton);
        return new CartPopupPage(driver);
    }
}
