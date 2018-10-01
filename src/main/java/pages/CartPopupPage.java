package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPopupPage extends BasePage {
    public CartPopupPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = ".//*[@id='TPAMultiSection_jh9acbtniframe']")
    private WebElement cartPopupFrame;

    @FindBy(xpath = ".//a[@class='button-primary is-button-wide']")
    private WebElement viewCartBtn;

    public void switchIntoCartPopupFrame(){
        switchIntoFrame(cartPopupFrame);
    }

    public void clickViewCart(){
        waitForElementDisplayed(viewCartBtn);
        click(viewCartBtn);
    }



}
