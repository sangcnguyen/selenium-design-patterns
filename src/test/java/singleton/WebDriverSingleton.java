package singleton;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSingleton {
    private static WebDriverSingleton instance;
    private WebDriver webDriver;

    private WebDriverSingleton() {
    }

    public static WebDriverSingleton instance() {
        if (instance == null) {
            instance = new WebDriverSingleton();
        }
        return instance;
    }

    public void initialize() {
        if (webDriver == null) {
            webDriver = new ChromeDriver();
        }
    }

    public WebDriver getDriver() {
        return webDriver;
    }

    public void quitDriver() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
