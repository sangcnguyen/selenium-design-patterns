package strategy;

import org.testng.Assert;
import org.testng.annotations.Test;
import template.TestTemplate;


public class LoginTest extends TestTemplate {

    @Test
    public void verifyLoginSuccessfully() {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.goToPage();
        loginPage.loginAs(new User("tomsmith", "SuperSecretPassword!"));
        Assert.assertEquals(loginPage.getMessage(), "You logged into a secure area!");
    }

    @Test
    public void verifyBasicAuthSuccessfully() {
        BaseAuthPage baseAuthPage = new BaseAuthPage(webDriver);
        baseAuthPage.loginAs(new User("admin", "admin"));
        Assert.assertEquals(baseAuthPage.getMessage(), "Congratulations! You must have the proper credentials.");
    }
}
