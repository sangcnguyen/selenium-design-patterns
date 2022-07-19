package decorator;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.Browser;

import java.util.List;

public abstract class Driver {
    public abstract void start();

    public abstract void quit();

    public abstract void goToUrl(String url);

    public abstract Element findElement(By locator);

    public abstract List<Element> findElements(By locator);
}
