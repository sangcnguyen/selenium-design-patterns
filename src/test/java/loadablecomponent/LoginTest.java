package loadablecomponent;

import org.testng.Assert;
import org.testng.annotations.Test;
import template.TestTemplate;

public class LoginTest extends TestTemplate {

    @Test
    public void verifyLoginSuccessfully() {
        LoginPage loginPage = new LoginPage(webDriver);
        // check whether page is loaded or not
        loginPage.get();
        loginPage.loginAs("tomsmith", "SuperSecretPassword!");
        Assert.assertEquals(loginPage.getMessage(), "You logged into a secure area!");
    }
}
