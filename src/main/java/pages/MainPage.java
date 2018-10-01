package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = ".//*[@id='comp-jhalo8eilink']")
    private WebElement shopBtn;

    public ShopPage clickShopButton() {
        shopBtn.click();
        return new ShopPage(driver);
    }
}
