package singleton;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {
    private WebDriver webDriver;

    public ForgotPasswordPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "form_submit")
    private WebElement submitButton;

    @FindBy(id = "content")
    private WebElement messageContent;

    public void goToPage() {
        webDriver.get("http://the-internet.herokuapp.com/forgot_password");
    }

    public void enterEmail(String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void submitForm() {
        submitButton.click();
    }

    public String getMessage() {
        return messageContent.getText().trim();
    }
}
