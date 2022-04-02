package factory;

import org.testng.Assert;
import org.testng.annotations.*;

public class LoginWithParallelBrowserTest {
    DriverManager driverManager;

    @BeforeMethod
    @Parameters(value = {"browser"})
    public void beforeMethod(@Optional("CHROME") String browser) {
        driverManager = DriverManagerFactory.getManager(browser);
    }

    @Test()
    public void loginByMultiBrowsers() {
        LoginPage loginPage = new LoginPage(driverManager.getDriver());
        loginPage.goToPage();
        loginPage.loginAs("tomsmith", "SuperSecretPassword!");
        Assert.assertEquals(loginPage.getMessage(), "You logged into a secure area!");
    }

    @AfterMethod
    public void afterMethod() {
        driverManager.quitDriver();
    }
}
