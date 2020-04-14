package factory;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import strategy.LoginPage;
import strategy.User;

public class LoginWithParallelBrowserTest {
    DriverManager driverManager;

    @BeforeMethod
    @Parameters(value = {"browser"})
    public void beforeMethod(String browser) {
        driverManager = DriverManagerFactory.getManager(browser);
    }

    @Test()
    public void loginByMultiBrowsers() {
        LoginPage loginPage = new LoginPage(driverManager.getDriver());
        loginPage.goToPage();
        loginPage.loginAs(new User("tomsmith", "SuperSecretPassword!"));
        Assert.assertEquals(loginPage.getMessage(), "You logged into a secure area!");
    }

    @AfterMethod
    public void afterMethod() {
        driverManager.quitDriver();
        DriverType.cleanUp();
    }
}
