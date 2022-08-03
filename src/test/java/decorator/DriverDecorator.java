package decorator;

import org.openqa.selenium.By;

import java.util.List;

public class DriverDecorator extends Driver {
    protected final Driver driver;

    public DriverDecorator(Driver driver) {
        this.driver = driver;
    }

    @Override
    public void start() {
        driver.start();
    }

    @Override
    public void quit() {
        driver.quit();
    }

    @Override
    public void goToUrl(String url) {
        driver.goToUrl(url);
    }

    @Override
    public Element findElement(By locator) {
        return driver.findElement(locator);
    }

    @Override
    public List<Element> findElements(By locator) {
        return driver.findElements(locator);
    }

    @Override
    public void waitForAjax() {
        driver.waitForAjax();
    }

    @Override
    public void waitUntilPageLoadsCompletely() {
        driver.waitUntilPageLoadsCompletely();
    }
}
