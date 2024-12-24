package strategy;

import org.testng.Assert;
import org.testng.annotations.Test;
import template.TestTemplate;

public class UploadTest extends TestTemplate {

  String fileTest = "Fastlane.csv";
  UploadPage uploadPage;

  @Test
  public void verifyUploadFileFromLocalMachine() {
    uploadPage = new UploadPage(webDriver, new UploadLocalFile());
    uploadPage.goToPage();
    uploadPage.uploadFile(fileTest);
    Assert.assertEquals(uploadPage.getMsgUploadSuccess(), fileTest);
  }

  @Test
  public void verifyUploadByDraggingAndDroppingFile() {
    uploadPage = new UploadPage(webDriver, new DragDropFile(webDriver));
    uploadPage.goToPage();
    uploadPage.uploadFile(fileTest);
    Assert.assertEquals(uploadPage.getMsgUploadSuccess(), fileTest);
  }
}
