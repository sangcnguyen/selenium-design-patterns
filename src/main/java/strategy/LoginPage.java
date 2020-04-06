package strategy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import template.PageTemplate;

public class LoginPage extends PageTemplate implements LoginStrategy {

    public LoginPage(WebDriver webDriver) {
        initElements(webDriver);
        setPath("/login");
    }

    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(css = "[type='submit'][class='radius']")
    private WebElement loginButton;

    @FindBy(css = ".flash")
    private WebElement flashMessage;

    public String getMessage() {
        return flashMessage.getText().split("\\n")[0].trim();
    }

    public void loginAs(User user) {
        this.usernameInput.sendKeys(user.getUsername());
        this.passwordInput.sendKeys(user.getPassword());
        this.loginButton.click();
    }
}
