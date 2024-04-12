package decorator;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class WebCoreDriver extends Driver {
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    @Override
    public void start() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        webDriver = new ChromeDriver(options);
        webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
    }

    @Override
    public void quit() {
        webDriver.quit();
    }

    @Override
    public void goToUrl(String url) {
        webDriver.navigate().to(url);
    }

    @Override
    public Element findElement(By locator) {
        var nativeWebElement = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(locator));
        Element element = new WebCoreElement(webDriver, nativeWebElement, locator);
        return new LoggingElement(element);
    }

    @Override
    public List<Element> findElements(By locator) {
        List<WebElement> nativeWebElements = webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        var elements = new ArrayList<Element>();
        for (WebElement nativeWebElement : nativeWebElements) {
            Element element = new WebCoreElement(webDriver, nativeWebElement, locator);
            Element logElement = new LoggingElement(element);
            elements.add(logElement);
        }
        return elements;
    }

    @Override
    public void waitForAjax() {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
        webDriverWait.until(d -> (Boolean) javascriptExecutor.executeScript("return window.jQuery != undefined && jQuery.active == 0"));
    }

    @Override
    public void waitUntilPageLoadsCompletely() {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
        webDriverWait.until(d -> javascriptExecutor.executeScript("return document.readyState").toString().equals("complete"));
    }
}
