package decorator;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductPurchaseTests {
    private Driver driver;
    private static MainPage mainPage;
    private static CartPage cartPage;

    @BeforeMethod
    public void testInit() {
        driver = new LoggingDriver(new WebCoreDriver());
        driver.start();
        mainPage = new MainPage(driver);
        cartPage = new CartPage(driver);
    }

    @AfterMethod
    public void testCleanup() {
        driver.quit();
    }

    @Test
    public void completePurchaseSuccessfully_whenNewClient() {
        mainPage.addRocketToShoppingCart();
        cartPage.applyCoupon("happybirthday");

        Assert.assertEquals(cartPage.getMessageNotification(), "Coupon code applied successfully.");

        cartPage.increaseProductQuantity(2);

        Assert.assertEquals("114.00€", cartPage.getTotal());

        cartPage.clickProceedToCheckout();

        var receivedMessage = driver.findElement(By.xpath("//h1"));
        Assert.assertEquals(receivedMessage.getText(), "Checkout");
    }
}
