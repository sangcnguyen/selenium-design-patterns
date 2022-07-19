package facade;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {
    private WebDriver driver;

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void findAndGoToPage(String pageUrl) {
        driver.findElement(By.xpath(String.format("//*[@id='search']//a[@href='%s']", pageUrl))).click();
    }
}
