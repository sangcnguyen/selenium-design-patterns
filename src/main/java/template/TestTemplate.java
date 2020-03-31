package template;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public abstract class TestTemplate {
    public WebDriver webDriver;


    @BeforeTest
    public void beforeTest() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
    }

    @AfterTest
    public void afterTest() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
