import org.testng.annotations.Test;
import pages.CartPopupPage;
import pages.MainPage;
import pages.ProductPage;
import pages.ShopPage;

public class WixTestCase extends BaseTest {

    @Test
    public void testWixShop() {
        MainPage mainPage = new MainPage(driver);
        ShopPage shopPage = mainPage.openBaseURL().clickShopButton().switchIntoShopFrame();
        ProductPage productPage = shopPage.clickOnItemWithName("Premium Glasses").switchIntoProductFrame();
        CartPopupPage cartPopupPage = productPage.clickAddToCartButton().switchIntoCartPopupFrame();
        cartPopupPage.removeItemFromCartPopup(0);
        cartPopupPage.closeCartPopupBackToProduct().switchIntoProductFrame();
        productPage.clickAddToCartButton().switchIntoCartPopupFrame();
        cartPopupPage.closeCartPopupBackToProduct().switchIntoProductFrame();
        productPage.clickStoresButton().switchIntoCartWidgetFrame();
        shopPage.clickOnCartWidgetButton().switchIntoCartPopupFrame();
        cartPopupPage.closeCartPopupBackToShop().switchIntoShopFrame();
        shopPage.clickOnItemWithName("I\'m a product").switchIntoProductFrame();
        productPage.clickAddToCartButton().switchIntoCartPopupFrame();
        cartPopupPage.clickViewCart();
    }
}
