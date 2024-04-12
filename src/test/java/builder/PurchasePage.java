package builder;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PurchasePage {
    private WebDriver webDriver;

    public PurchasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(id = "inputName")
    private WebElement nameInput;

    @FindBy(id = "address")
    private WebElement addressInput;

    @FindBy(id = "city")
    private WebElement cityInput;

    @FindBy(id = "state")
    private WebElement stateInput;

    @FindBy(id = "zipCode")
    private WebElement zipCodeInput;

    @FindBy(id = "cardType")
    private WebElement cardTypeDropdown;

    @FindBy(id = "creditCardNumber")
    private WebElement cardNumberInput;

    @FindBy(id = "creditCardMonth")
    private WebElement cardMonthInput;

    @FindBy(id = "creditCardYear")
    private WebElement cardYearInput;

    @FindBy(id = "nameOnCard")
    private WebElement nameOnCardInput;

    @FindBy(xpath = "//input[@value='Purchase Flight']")
    private WebElement purchaseFlightButton;

    public void goToPage() {
        webDriver.get("http://blazedemo.com/purchase.php");
    }

    public void enterName(String name) {
        nameInput.sendKeys(name);
    }

    public void enterAddress(String address) {
        addressInput.sendKeys(address);
    }

    public void enterCity(String city) {
        cityInput.sendKeys(city);
    }

    public void enterState(String state) {
        skipEnterValueIfNull(stateInput, state);
    }

    public void enterZipCode(String zipcode) {
        skipEnterValueIfNull(zipCodeInput, zipcode);
    }

    public void enterCardType(String cardType) {
        if (cardType != null) {
            Select select = new Select(cardTypeDropdown);
            select.selectByVisibleText(cardType);
        }
    }

    public void enterCardNumber(String cardNumber) {
        skipEnterValueIfNull(cardNumberInput, cardNumber);
    }

    public void enterCardMonth(String cardMonth) {
        skipEnterValueIfNull(cardMonthInput, cardMonth);
    }

    public void enterCardYear(String cardYear) {
        skipEnterValueIfNull(cardYearInput, cardYear);
    }

    public void enterNameOnCard(String nameOnCard) {
        skipEnterValueIfNull(nameOnCardInput, nameOnCard);
    }

    public void enterBillingInfo(BillingInfo billingInfo) {
        enterName(billingInfo.getName());
        enterAddress(billingInfo.getAddress());
        enterCity(billingInfo.getCity());
        enterState(billingInfo.getState());
        enterZipCode(billingInfo.getZipCode());
        enterCardType(billingInfo.getCardType());
        enterCardNumber(billingInfo.getCardNumber());
        enterCardMonth(billingInfo.getCardMonth());
        enterCardYear(billingInfo.getCardYear());
        enterNameOnCard(billingInfo.getNameOnCard());
    }

    private void skipEnterValueIfNull(WebElement element, String value) {
        if (value != null) {
            element.sendKeys(value);
        }
    }

    public void submitForm() {
        purchaseFlightButton.click();
    }
}
