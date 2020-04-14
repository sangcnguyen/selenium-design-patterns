package factory;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
    protected static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();

    protected abstract void createDriver();

    public WebDriver getDriver() {
        if (webDriver.get() == null) {
            createDriver();
        }
        return webDriver.get();
    }

    public void quitDriver() {
        if (webDriver.get() != null) {
            webDriver.get().quit();
            webDriver.remove();
        }
    }
}