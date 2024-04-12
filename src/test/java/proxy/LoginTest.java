package proxy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new WebDriverProxy(new ChromeDriver());
    }

    @AfterMethod
    public void terminate() {
        driver.quit();
    }

    @Test
    public void completePurchaseSuccessfully_whenNewClient() {
        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("[type='submit'][class='radius']")).click();
        String getMsg = driver.findElement(By.cssSelector(".flash")).getText().split("\\n")[0].trim();
        Assert.assertEquals(getMsg, "You logged into a secure area!");
    }
}
