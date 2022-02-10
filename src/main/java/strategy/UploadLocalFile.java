package strategy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UploadLocalFile implements UploadStrategy {

    @FindBy(id = "file-upload")
    private WebElement fileUploadBtn;

    @FindBy(id = "file-submit")
    private WebElement submitBtn;

    @FindBy(id = "uploaded-files")
    private WebElement uploadMsg;

    @Override
    public void uploadFile(String fileName) {
        fileUploadBtn.sendKeys(fileName);
        submitBtn.click();
    }

    @Override
    public String getUploadMessage() {
        return uploadMsg.getText();
    }
}
