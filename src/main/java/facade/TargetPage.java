package facade;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TargetPage {
    private WebDriver driver;

    public TargetPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}
