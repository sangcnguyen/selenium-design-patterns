package decorator;

import org.openqa.selenium.By;

import java.util.List;

public class LoggingDriver extends DriverDecorator {
    public LoggingDriver(Driver driver) {
        super(driver);
    }

    @Override
    public void start() {
        System.out.print("Start browser Chrome");
        System.out.print("\n");
        driver.start();
    }

    @Override
    public void quit() {
        System.out.print("Close browser");
        driver.quit();
    }

    @Override
    public void goToUrl(String url) {
        System.out.print(String.format("Go to url = %s", url));
        System.out.print("\n");
        driver.goToUrl(url);
    }

    @Override
    public Element findElement(By locator) {
        System.out.print(String.format("Find element = %s", locator));
        System.out.print("\n");
        return driver.findElement(locator);
    }

    @Override
    public List<Element> findElements(By locator) {
        System.out.print(String.format("Find elements = %s", locator));
        System.out.print("\n");
        return driver.findElements(locator);
    }

    @Override
    public void waitForAjax() {
        System.out.print("Wait for Ajax");
        System.out.print("\n");
        driver.waitForAjax();
    }

    @Override
    public void waitUntilPageLoadsCompletely() {
        System.out.print("Wait until page load completely");
        System.out.print("\n");
        driver.waitUntilPageLoadsCompletely();
    }
}
