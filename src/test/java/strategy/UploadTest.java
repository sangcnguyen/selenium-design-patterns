package strategy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UploadTest {
    public WebDriver webDriver;
    String fileTest = "Fastlane.csv";

    @BeforeMethod
    public void beforeMethod() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
    }

    @AfterMethod
    public void afterMethod() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }


    @Test
    public void verifyUploadFileFromLocalMachine() {
        UploadPage uploadPage = new UploadPage(webDriver, new UploadLocalFile());
        uploadPage.goToPage();
        uploadPage.uploadFile(fileTest);
        Assert.assertEquals(uploadPage.getMsgUploadSuccess(), fileTest);
    }

    @Test
    public void verifyUploadByDraggingAndDroppingFile() {
        UploadPage uploadPage = new UploadPage(webDriver, new DragDropFile(webDriver));
        uploadPage.goToPage();
        uploadPage.uploadFile(fileTest);
        Assert.assertEquals(uploadPage.getMsgUploadSuccess(), fileTest);
    }
}
