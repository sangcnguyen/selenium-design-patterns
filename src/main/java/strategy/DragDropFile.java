package strategy;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DragDropFile implements UploadStrategy {
    private WebDriver driver;

    @FindBy(id = "drag-drop-upload")
    private WebElement dragDropArea;

    @FindBy(css = "#drag-drop-upload > div > div.dz-details > div > span")
    private WebElement uploadMsg;

    @Override
    public void uploadFile(String fileName) {
        dropFile(fileName, dragDropArea, 0, 0);
    }

    @Override
    public String getUploadMessage() {
        return uploadMsg.getText();
    }

    public DragDropFile(WebDriver driver) {
        this.driver = driver;
    }

    private void dropFile(String fileName, WebElement target, int offsetX, int offsetY) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30000));

        String JS_DROP_FILE = "var target = arguments[0]," + "    offsetX = arguments[1]," + "    offsetY = arguments[2]," + "    document = target.ownerDocument || document," + "    window = document.defaultView || window;" + "" + "var input = document.createElement('INPUT');" + "input.type = 'file';" + "input.style.display = 'none';" + "input.onchange = function () {" + "  var rect = target.getBoundingClientRect()," + "      x = rect.left + (offsetX || (rect.width >> 1))," + "      y = rect.top + (offsetY || (rect.height >> 1))," + "      dataTransfer = { files: this.files };" + "" + "  ['dragenter', 'dragover', 'drop'].forEach(function (name) {" + "    var evt = document.createEvent('MouseEvent');" + "    evt.initMouseEvent(name, !0, !0, window, 0, 0, 0, x, y, !1, !1, !1, !1, 0, null);" + "    evt.dataTransfer = dataTransfer;" + "    target.dispatchEvent(evt);" + "  });" + "" + "  setTimeout(function () { document.body.removeChild(input); }, 25);" + "};" + "document.body.appendChild(input);" + "return input;";

        WebElement input = (WebElement) jse.executeScript(JS_DROP_FILE, target, offsetX, offsetY);
        input.sendKeys(fileName);
        wait.until(ExpectedConditions.stalenessOf(input));
    }
}
