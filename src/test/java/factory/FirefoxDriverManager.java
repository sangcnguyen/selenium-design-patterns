package factory;

import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverManager extends DriverManager {

    protected void createDriver() {
        webDriver.set(new FirefoxDriver());
    }
}
