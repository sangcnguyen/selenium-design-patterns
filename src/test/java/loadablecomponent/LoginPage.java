package loadablecomponent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage extends LoadableComponent<LoginPage> {
    private final String baseURL = "https://the-internet.herokuapp.com/login";
    private WebDriver driver;

    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(css = "[type='submit'][class='radius']")
    private WebElement loginButton;

    @FindBy(css = ".flash")
    private WebElement flashMessage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Override
    protected void load() {
        driver.get(baseURL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
    }

    @Override
    protected void isLoaded() throws Error {
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.endsWith("/login"));
    }

    public void loginAs(String user, String pass) {
        this.usernameInput.sendKeys(user);
        this.passwordInput.sendKeys(pass);
        this.loginButton.click();
    }

    public String getMessage() {
        return flashMessage.getText().split("\\n")[0].trim();
    }
}
