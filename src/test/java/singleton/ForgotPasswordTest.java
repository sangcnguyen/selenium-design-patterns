package singleton;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ForgotPasswordTest {

    @BeforeTest
    public void setUp() {
        WebDriverSingleton.instance().initialize();
    }

    @Test
    public void verifyForgotPassword() {
        ForgotPasswordPage forgotPassPage = new ForgotPasswordPage(WebDriverSingleton.instance().getDriver());
        forgotPassPage.goToPage();
        forgotPassPage.enterEmail("demo@example.com");
        forgotPassPage.submitForm();
        Assert.assertEquals(forgotPassPage.getMessage(), "Your e-mail's been sent!");
    }

    @AfterTest
    public void tearDown() {
        WebDriverSingleton.instance().quitDriver();
    }
}
