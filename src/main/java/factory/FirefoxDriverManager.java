package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverManager extends DriverManager {

    protected void createDriver() {
        WebDriverManager.firefoxdriver().setup();
        webDriver = new FirefoxDriver();
    }
}
