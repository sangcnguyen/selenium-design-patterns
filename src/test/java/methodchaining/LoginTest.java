package methodchaining;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import singleton.WebDriverSingleton;

public class LoginTest {

  @BeforeTest
  public void setUp() {
    WebDriverSingleton.instance().initialize();
  }

  @AfterTest
  public void tearDown() {
    WebDriverSingleton.instance().quitDriver();
  }

  @Test
  public void verifyLoginSuccessfully() {
    LoginPage loginPage = new LoginPage(WebDriverSingleton.instance().getDriver());
    loginPage.goToPage().loginAs("tomsmith", "SuperSecretPassword!");
    Assert.assertEquals(loginPage.getMessage(), "You logged into a secure area!");
  }
}
