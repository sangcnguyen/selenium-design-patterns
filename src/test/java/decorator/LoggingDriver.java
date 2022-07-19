package decorator;

import org.openqa.selenium.By;

import java.util.List;

public class LoggingDriver extends DriverDecorator {
    public LoggingDriver(Driver driver) {
        super(driver);
    }

    @Override
    public void start() {
        System.out.print("Start browser");
    }

    @Override
    public void quit() {
        System.out.print("Close browser");
        driver.quit();
    }

    @Override
    public void goToUrl(String url) {
        System.out.print(String.format("Go to url = %s", url));
        driver.goToUrl(url);
    }

    @Override
    public Element findElement(By locator) {
        System.out.print("Find element");
        return driver.findElement(locator);
    }

    @Override
    public List<Element> findElements(By locator) {
        System.out.print("Find elements");
        return driver.findElements(locator);
    }
}
