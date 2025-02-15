package template;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class PageTemplate {

  private String BASE_URL = "http://the-internet.herokuapp.com";
  private String PATH;
  private WebDriver webDriver;

  public void initElements(WebDriver webDriver) {
    this.webDriver = webDriver;
    PageFactory.initElements(webDriver, this);
  }

  public void goToPage() {
    this.webDriver.get(this.BASE_URL.concat(this.PATH));
    this.webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
  }

  public void setPath(String path) {
    this.PATH = path;
  }

  public void setBaseUrl(String url) {
    this.BASE_URL = url;
  }
}
