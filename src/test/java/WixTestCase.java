import org.testng.annotations.Test;
import pages.CartPopupPage;
import pages.MainPage;
import pages.ProductPage;
import pages.ShopPage;

public class WixTestCase extends BaseTest {
    @Test public void testWixShop() {
        MainPage mainPage = new MainPage(driver);
        ShopPage shopPage = mainPage
                .openBaseURL()
                .clickShopButton();
        ProductPage productPage = shopPage
                .switchIntoShopFrame()
                .clickOnItemWithName("Premium Glasses");
        CartPopupPage cartPopupPage = productPage
                .switchIntoProductFrame()
                .clickAddToCartButton();
        cartPopupPage
                .switchIntoCartPopupFrame()
                .removeItemFromCartPopup(0)
                .closePopup();
        productPage
                .switchIntoProductFrame()
                .clickAddToCartButton();
        cartPopupPage
                .switchIntoCartPopupFrame()
                .closePopup();
        productPage
                .switchIntoProductFrame()
                .clickStoresButton();
        shopPage
                .switchIntoCartWidgetFrame()
                .clickOnCartWidgetButton()
                .switchIntoCartPopupFrame()
                .closePopup();
        shopPage
                .switchIntoShopFrame()
                .clickOnItemWithName("I\'m a product");
        productPage
                .switchIntoProductFrame()
                .clickAddToCartButton();
        cartPopupPage
                .switchIntoCartPopupFrame()
                .clickViewCart();
    }
}
