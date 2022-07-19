package strategy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class UploadPage {
    private WebDriver driver;
    private UploadStrategy uploadStrategy;

    public UploadPage(WebDriver driver, UploadStrategy uploadStrategy) {
        this.driver = driver;
        this.uploadStrategy = uploadStrategy;
        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, uploadStrategy);
    }

    public void goToPage() {
        driver.get("https://the-internet.herokuapp.com/upload");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
    }

    public void uploadFile(String fileName) {
        String absolutePathOfFile = System.getProperty("user.dir") + "/src/test/resources/" + fileName;
        uploadStrategy.uploadFile(absolutePathOfFile);
    }

    public String getMsgUploadSuccess() {
        return uploadStrategy.getUploadMessage();
    }
}