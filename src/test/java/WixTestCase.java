import org.testng.annotations.Test;
import pages.CartPopupPage;
import pages.MainPage;
import pages.ProductPage;
import pages.ShopPage;

public class WixTestCase extends BaseTest {

    @Test
    public void testWixShop() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.openBaseURL();
        ShopPage shopPage = mainPage.clickShopButton();
        shopPage.switchIntoShopFrame();
        ProductPage productPage = shopPage.clickOnItemWithName("Premium Glasses");
        productPage.switchFromFrameToDefaultContent();
        productPage.switchIntoProductFrame();
        CartPopupPage cartPopupPage = productPage.clickAddToCartButton();
        cartPopupPage.switchFromFrameToDefaultContent();
        cartPopupPage.switchIntoCartPopupFrame();
        cartPopupPage.clickViewCart();
    }
}
