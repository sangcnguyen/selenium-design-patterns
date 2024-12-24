package methodchaining;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage  {

  public WebDriver driver;

  public LoginPage(WebDriver webDriver) {
    this.driver = webDriver;
    PageFactory.initElements(webDriver, this);
  }

  @FindBy(id = "username")
  private WebElement usernameInput;

  @FindBy(id = "password")
  private WebElement passwordInput;

  @FindBy(css = "[type='submit'][class='radius']")
  private WebElement loginButton;

  @FindBy(css = ".flash")
  private WebElement flashMessage;

  public LoginPage goToPage() {
    driver.navigate().to("https://the-internet.herokuapp.com/login");
    return new LoginPage(driver);
  }

  public String getMessage() {
    return flashMessage.getText().split("\\n")[0].trim();
  }

  public void loginAs(String username, String password) {
    this.usernameInput.sendKeys(username);
    this.passwordInput.sendKeys(password);
    this.loginButton.click();
  }
}
