package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager extends DriverManager {

    protected void createDriver() {
        WebDriverManager.chromedriver().setup();
        webDriver.set(new ChromeDriver());
    }
}
