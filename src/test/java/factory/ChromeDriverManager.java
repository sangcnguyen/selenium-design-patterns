package factory;

import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager extends DriverManager {

    protected void createDriver() {
        webDriver.set(new ChromeDriver());
    }
}
