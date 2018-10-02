import org.testng.annotations.Test;
import pages.CartPopupPage;
import pages.MainPage;
import pages.ProductPage;
import pages.ShopPage;

public class WixTestCase extends BaseTest {

    @Test
    public void testWixShop() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openBaseURL();
        ShopPage shopPage = mainPage.clickShopButton().switchIntoShopFrame();
        ProductPage productPage = shopPage.clickOnItemWithName("Premium Glasses").switchIntoProductFrame();
        CartPopupPage cartPopupPage = productPage.clickAddToCartButton().switchIntoCartPopupFrame();
        cartPopupPage.removeItemFromCartPopup(0);
        productPage = cartPopupPage.closeCartPopup().switchIntoProductFrame();
        cartPopupPage = productPage.clickAddToCartButton().switchIntoCartPopupFrame();
        productPage = cartPopupPage.closeCartPopup().switchIntoProductFrame();
        productPage.clickStoresButton();
    }
}
