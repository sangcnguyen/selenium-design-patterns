package factory;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import strategy.LoginPage;
import strategy.User;

public class LoginWithCrossBrowserTest {
    DriverManager driverManager;

    @Test(dataProvider = "browserList")
    public void loginByMultiBrowsers(DriverType driverType) {
        driverManager = DriverManagerFactory.getManager(driverType);
        LoginPage loginPage = new LoginPage(driverManager.getDriver());
        loginPage.goToPage();
        loginPage.loginAs(new User("tomsmith", "SuperSecretPassword!"));
        Assert.assertEquals(loginPage.getMessage(), "You logged into a secure area!");
    }

    @DataProvider(name = "browserList")
    public static Object[] dataBrowser() {
        return new Object[]{DriverType.CHROME, DriverType.FIREFOX};
    }

    @AfterMethod
    public void afterMethod() {
        driverManager.quitDriver();
    }
}
