package strategy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import template.PageTemplate;

public class BaseAuthPage extends PageTemplate implements LoginStrategy {

    public BaseAuthPage(WebDriver webDriver) {
        initElements(webDriver);
        setPath("/basic_auth");
    }

    @FindBy(css = ".example > p")
    private WebElement flashMessage;


    public void loginAs(User user) {
        setBaseUrl("http://" + user.getUsername() + ":" + user.getPassword() + "@the-internet.herokuapp.com");
        goToPage();
    }

    public String getMessage() {
        return flashMessage.getText().trim();
    }
}
